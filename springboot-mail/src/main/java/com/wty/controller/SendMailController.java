package com.wty.controller;

import com.wty.constant.MailConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

/**
 * @author wty
 * @date 2019/12/07 9:54
 */
@Controller
public class SendMailController {
    @Autowired
    private JavaMailSender jms;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private TemplateEngine templateEngine;

    @RequestMapping(value = "sendSimpleEmail", method = RequestMethod.GET)
    public String sendSimpleEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(MailConstant.TO_USER_MAIL);
            message.setSubject(MailConstant.MAIL_EASY_SUBJECT);
            message.setText("使用Spring Boot发送简单邮件。");
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "sendHtmlEmail", method = RequestMethod.GET)
    public String sendHtmlEmail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(MailConstant.TO_USER_MAIL);
            helper.setSubject(MailConstant.MAIL_HTML_SUBJECT);
            // 带HTML格式的内容
            StringBuffer sb = new StringBuffer("<p style='color:#42b183'>使用Spring Boot发送HTML格式邮件。</p>");
            helper.setText(sb.toString(), true);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "sendAttachmentsMail", method = RequestMethod.GET)
    public String sendAttachmentsMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(MailConstant.TO_USER_MAIL);
            helper.setSubject(MailConstant.MAIL_ACCESSORY_SUBJECT);
            helper.setText("详情参见附件内容！");
            // 传入附件
            FileSystemResource file = new FileSystemResource(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/file/文档.txt"));
            helper.addAttachment("文档.txt", file);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "sendInlineMail", method = RequestMethod.GET)
    public String sendInlineMail() {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(MailConstant.TO_USER_MAIL);
            helper.setSubject(MailConstant.MAIL_IMG_SUBJECT);
            helper.setText("<html><body>图片加载：<img src='cid:img'/></body></html>", true);
            // 传入附件
            FileSystemResource file = new FileSystemResource(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/images/sunshine.png"));
            helper.addInline("img", file);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(value = "sendTemplateEmail", method = RequestMethod.GET)
    public String sendTemplateEmail(String code) {
        MimeMessage message = null;
        try {
            message = jms.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(MailConstant.TO_USER_MAIL);
            helper.setSubject(MailConstant.MAIL_TEMPLATE_SUBJECT);
            // 处理邮件模板
            Context context = new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("verificationCode", context);
            helper.setText(template, true);
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
