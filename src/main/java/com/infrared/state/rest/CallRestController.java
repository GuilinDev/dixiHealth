package com.infrared.state.rest;

import com.infrared.state.model.CallInfo;
import com.infrared.state.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call")
public class CallRestController {
    @Autowired
    private CallService service;

    @PostMapping("/stateful")
    public CallInfo handleCallStateful(@RequestBody CallInfo info) {
        return service.handleCallsStateful(info);
    }

    @PostMapping("/stateless")
    public CallInfo handleCallStateless(@RequestBody CallInfo info) {
        return service.handleCallsStateless(info);
    }
}
