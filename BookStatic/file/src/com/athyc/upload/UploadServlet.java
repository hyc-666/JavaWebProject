package com.athyc.upload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/8/14
 **/
public class UploadServlet extends HttpServlet {

    //处理上传的文件

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到文件");
        resp.setContentType("text/html;charset=UTF-8");
        //客户端发送文件是以二进制字节流的形式发送，于实在服务器端也要使用二进制字节流来接受数据
        ServletInputStream inputStream = req.getInputStream();

        byte[] buffer = new byte[102400];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));
    }
}
