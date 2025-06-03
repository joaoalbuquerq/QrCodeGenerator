package com.pedroalbuquerque.qrcode_generator.controller;

import com.pedroalbuquerque.qrcode_generator.dto.qrcode.QrCodeGenerateRequest;
import com.pedroalbuquerque.qrcode_generator.dto.qrcode.QrCodeGenerteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {



    @PostMapping
    public ResponseEntity<QrCodeGenerteResponse> generate(@RequestBody QrCodeGenerateRequest dto){
        return null;
    }
}
