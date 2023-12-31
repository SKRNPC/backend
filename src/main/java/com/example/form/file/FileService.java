package com.example.form.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class FileService {
    private final String uploadDir = "uploads/photo";

    public String saveBase64StringAsFile(String selectedFile) {
        // Yolun ve dosya adının oluşturulması
        String filename = UUID.randomUUID().toString() + ".jpg"; // Or the appropriate extension
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // Eğer dizin yoksa, oluştur
        }
        File file = new File(directory, filename);
        
        try {
            // Dosya yazma işlemleri
            OutputStream outputStream = new FileOutputStream(file);
            byte[] base64decoded = Base64.getDecoder().decode(selectedFile.split(",")[1]);
            outputStream.write(base64decoded);
            outputStream.close();
            return file.getPath(); // Kaydedilen dosyanın yolunu döndür
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            // Hata işleme
            e.printStackTrace();
        }
        return null;
    }
}