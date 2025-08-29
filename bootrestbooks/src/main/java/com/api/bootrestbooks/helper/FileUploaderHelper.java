package com.api.bootrestbooks.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
    
    //path where we need to store the image
   // public final String upload_dir="C:\\Users\\Hp\\Documents\\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\\SpringBootUsingVSCode\\bootrestbooks\\src\\main\\resources\\static\\images";
    public final String upload_dir=new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploaderHelper() throws IOException{

    }

    //upload the image-
    public boolean uploadImage(MultipartFile file){
        boolean b=false;//abhi file upload nhi hui
        try {
            // InputStream is=file.getInputStream();
            // byte data[]=new byte[is.available()];
            // is.read(data);

            // //write 
            // FileOutputStream fos=new FileOutputStream(upload_dir+"\\"+file.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();
  

            //Alternative Way-
            Files.copy(file.getInputStream(), Paths.get(upload_dir+"\\"+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

            b=true;    //file upload ho chuki hai
        } catch (Exception e) {
            e.getStackTrace();
              
        }
       return b;
    }




}
