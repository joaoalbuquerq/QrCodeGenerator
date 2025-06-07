package com.pedroalbuquerque.qrcode_generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pedroalbuquerque.qrcode_generator.dto.qrcode.QrCodeGenerteResponse;
import com.pedroalbuquerque.qrcode_generator.infraestructure.S3StorageAdapter;
import com.pedroalbuquerque.qrcode_generator.ports.StoragePort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeService {

    private final StoragePort storage;

    public QrCodeService(StoragePort storagePort){
        this.storage = storagePort;
    }

    public QrCodeGenerteResponse generateAndUploadQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutPutStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutPutStream);
        byte[] pngQrCodeData = pngOutPutStream.toByteArray();

        String url = storage.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "image/png");

        return new QrCodeGenerteResponse(url);
    }

}
