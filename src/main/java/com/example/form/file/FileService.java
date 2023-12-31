package com.example.form.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    
    private final String uploadDir = "uploads/photo";
   
    Tika tika=new Tika();

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
            outputStream.write(decodedImage(selectedFile));
            outputStream.close();
            return file.getPath(); // Kaydedilen dosyanın yolunu döndür
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            // Hata işleme
            e.printStackTrace();
        }
        return null;
    }

    public String detectType(String value) {
        try {
            return tika.detect(decodedImage(value));
        } catch (Exception e) {
            // Log or handle the exception as needed
            e.printStackTrace();
            return null;
        }
    }

    private byte[] decodedImage(String selectedFile){
        try {
            String[] parts = selectedFile.split(",");
            if (parts.length > 1) {
                return Base64.getDecoder().decode(parts[1]);
            } else {
                throw new IllegalArgumentException("Invalid image data");
            }
        } catch (IllegalArgumentException e) {
            // Log or handle the exception as needed
            e.printStackTrace();
            return null;
        }
    }

    public void deleteImage(String selectedFile) {
    if(selectedFile == null || selectedFile.isEmpty()) return; // If the file path is null or empty, do nothing

    // Assuming the selectedFile is the relative path from the application's root
    Path pathToFile = Paths.get(selectedFile); // Constructing the full path as a Path object

    try {
        Files.deleteIfExists(pathToFile); // Attempt to delete the file if it exists
        System.out.println("File deleted successfully if it existed: " + selectedFile);
    } catch (IOException e) {
        System.err.println("Failed to delete the file: " + selectedFile);
        e.printStackTrace();
        // Handle the exception as needed
    }
}
    
}