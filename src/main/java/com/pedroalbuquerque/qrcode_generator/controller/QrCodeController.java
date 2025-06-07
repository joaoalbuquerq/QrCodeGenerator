package com.pedroalbuquerque.qrcode_generator.controller;

import com.pedroalbuquerque.qrcode_generator.dto.qrcode.QrCodeGenerateRequest;
import com.pedroalbuquerque.qrcode_generator.dto.qrcode.QrCodeGenerteResponse;
import com.pedroalbuquerque.qrcode_generator.service.QrCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService){
        this.qrCodeService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerteResponse> generate(@RequestBody QrCodeGenerateRequest dto){

        try {
            QrCodeGenerteResponse response = this.qrCodeService.generateAndUploadQrCode(dto.mensagem());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
