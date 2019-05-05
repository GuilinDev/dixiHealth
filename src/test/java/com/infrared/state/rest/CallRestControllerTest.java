package com.infrared.state.rest;

import com.infrared.state.StateApplication;
import com.infrared.state.model.Call;
import com.infrared.state.model.CallInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StateApplication.class)
public class CallRestControllerTest {
    @Autowired
    private CallRestController controller;

    @Test
    public void testHandleCallStateful() {
        CallInfo info = generateRequest();
        CallInfo resultInfo = controller.handleCallStateful(info);
        assertEquals(4, resultInfo.getNumOfAccepted());
        assertEquals(2, resultInfo.getNumOfSkipped());
    }

    @Test
    public void testHandleCallStateless() {
        CallInfo info = generateRequest();
        CallInfo resultInfo = controller.handleCallStateless(info);
        assertEquals(4, resultInfo.getNumOfAccepted());
        assertEquals(2, resultInfo.getNumOfSkipped());
    }

    private CallInfo generateRequest() {
        CallInfo info = new CallInfo();
        info.setCalls(new ArrayList<>());
        info.getCalls().add(new Call(1, "A1"));
        info.getCalls().add(new Call(2, "A1"));
        info.getCalls().add(new Call(3, "A1"));
        info.getCalls().add(new Call(4, "A2"));
        info.getCalls().add(new Call(5, "A2"));
        info.getCalls().add(new Call(6, "A2"));
        return info;
    }
}
