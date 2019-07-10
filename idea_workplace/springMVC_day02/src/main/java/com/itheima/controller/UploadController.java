package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UploadController {
    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("文件正在上传");
        String realPath = request.getSession().getServletContext().getRealPath("/controllers/");
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        String name = upload.getName();
        name=name+ UUID.randomUUID().toString().replace("-","");
        upload.transferTo(new File(realPath,name));
        return "success";
    }
    @RequestMapping("/fileupload2")
    public String fileupload2( MultipartFile upload) throws IOException {
        System.out.println("跨服务器上传");
        String path="http://localhost:9090/uploads";
        String filename=upload.getOriginalFilename();
        String uuid=UUID.randomUUID().toString().replace("-","");
        filename=uuid+filename;
        Client client = Client.create();
        WebResource resource = client.resource(path + filename);
        resource.put(upload.getBytes());
        return "success";
    }
}
