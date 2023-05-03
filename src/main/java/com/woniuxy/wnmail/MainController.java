package com.woniuxy.wnmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @GetMapping("/sendmail")
    public void sendMail(int id,String email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1048321255@qq.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("用户注册激活邮件");
        simpleMailMessage.setText("<a href='http://localhost:8080/active?id=1'></a>");
        javaMailSender.send(simpleMailMessage);
    }
}
