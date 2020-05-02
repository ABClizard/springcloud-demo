package com.demo.springcloud.controller;


import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.serive.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("#############      insert result" + result);
        if (result > 0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(444, "fail", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("############# get result " + paymentById);
        if (null != paymentById ) {
            return new CommonResult(200, "success", paymentById);
        } else {
            return new CommonResult(444, "faind fail", null);
        }
    }
}
