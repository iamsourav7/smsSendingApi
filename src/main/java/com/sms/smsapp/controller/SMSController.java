package com.sms.smsapp.controller;

import com.sms.smsapp.payload.SMSRequest;
import com.sms.smsapp.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final TwilioService twilioService;

    @Autowired
    public SMSController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send-sms")
    public void sendSMS(@RequestBody SMSRequest smsRequest) {
        twilioService.sendSMS(smsRequest.getPhoneNumber(), smsRequest.getMessage());
    }
}

