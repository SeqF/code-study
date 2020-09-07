package com.study.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10MissionApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {

        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("你好");
        mailMessage.setText("共产党万岁");
        mailMessage.setTo("15622971263@163.com");
        mailMessage.setFrom("505475064@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {

        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("歪比歪比");
        helper.setText("<p style='color:red'>are you good 常平</p>", true);

        //附件
        helper.addAttachment("rabbit.png", new File("C:\\Users\\50547\\Desktop\\newPic\\rabbit.png"));

        helper.setTo("15622971263@163.com");
        helper.setFrom("505475064@qq.com");
        mailSender.send(mimeMessage);
    }

    public void sendMail(boolean multi,String subject,String text) throws MessagingException{

        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multi);

        helper.setSubject(subject);
        helper.setText(text, true);

        //附件
        helper.addAttachment("rabbit.png", new File("C:\\Users\\50547\\Desktop\\newPic\\rabbit.png"));

        helper.setTo("15622971263@163.com");
        helper.setFrom("505475064@qq.com");
        mailSender.send(mimeMessage);

    }
}
