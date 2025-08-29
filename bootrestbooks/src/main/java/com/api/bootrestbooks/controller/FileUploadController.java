package com.api.bootrestbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.bootrestbooks.helper.FileUploaderHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploaderHelper fileUploaderHelper;


    @PostMapping("/fileUpload")
    public ResponseEntity<String> FileUpload(@RequestParam("file") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());
       try{
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file!");
        }
        if(!file.getContentType().equals("image/png")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only png file allowed!");
        }
        //file uploaded-
            Boolean b=fileUploaderHelper.uploadImage(file);
            if(b){
            //return ResponseEntity.ok("File Uploaded Successfully!");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
            }
        }catch (Exception e) {
        e.getStackTrace();
        }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");

    }




    
}
