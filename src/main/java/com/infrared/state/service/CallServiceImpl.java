package com.infrared.state.service;

import com.infrared.state.entity.CallLimitEntity;
import com.infrared.state.model.Call;
import com.infrared.state.model.CallBalance;
import com.infrared.state.model.CallInfo;
import com.infrared.state.model.CallStatus;
import com.infrared.state.repository.CallLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CallServiceImpl implements CallService {

    @Autowired
    private CallLimitRepository limitRepo;

    private CallBalance callBalance;

    @Override
    public CallInfo handleCallsStateful(CallInfo info) {
        if (callBalance == null) {
            callBalance = mapToCallBalance(limitRepo.findAll());
        }
        handleCalls(info, callBalance);
        return info;
    }

    @Override
    public CallInfo handleCallsStateless(CallInfo info) {
        CallBalance balance = mapToCallBalance(limitRepo.findAll());
        handleCalls(info, balance);
        return info;
    }

    private void handleCalls(CallInfo info, CallBalance balance) {
        for (Call call : info.getCalls()) {
            if (handleCall(call, balance)) {
                info.increaseNumOfAccepted();
            } else {
                info.increaseNumOfSkipped();
            }
        }
    }

    private boolean handleCall(Call call, CallBalance balance) {
        //超过group的限制数
        if (balance.getGroupBalance() <= 0) {
            call.setStatus(CallStatus.SKIPPED);
            call.setReason("Call is skipped since it exceeds the group limit");
            return false;
        }

        //超过了个体的限制数
        int representativeBalance = balance.getRepresentativeBalance().get(call.getRepresentative());
        if (representativeBalance <= 0) {
            call.setStatus(CallStatus.SKIPPED);
            call.setReason("Call is skipped since it exceeds " + call.getRepresentative() + "'s limit");
            return false;
        }

        //可以oncall
        call.setStatus(CallStatus.ACCEPTED);
        balance.reduceGroupBalance();
        balance.getRepresentativeBalance().put(call.getRepresentative(), representativeBalance - 1);
        return true;
    }

    private CallBalance mapToCallBalance(List<CallLimitEntity> entities) {
        CallBalance balance = new CallBalance();
        balance.setRepresentativeBalance(new HashMap<>());
        entities.forEach(e -> {
            if (e.getGroupIndicator().equals("Y")) {
                balance.setGroupBalance(e.getLimits());
            } else {
                balance.getRepresentativeBalance().put(e.getId(), e.getLimits());
            }
        });
        return balance;
    }
}
