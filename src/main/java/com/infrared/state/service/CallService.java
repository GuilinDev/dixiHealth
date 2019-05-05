package com.infrared.state.service;

import com.infrared.state.model.CallInfo;

public interface CallService {
    public CallInfo handleCallsStateful(CallInfo info);

    public CallInfo handleCallsStateless(CallInfo info);
}
