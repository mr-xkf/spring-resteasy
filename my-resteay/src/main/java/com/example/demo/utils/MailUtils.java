/**
 * FileName: MailUtils
 * Author:   13235
 * Date:     2019/1/24 17:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/24
 * @since 1.0.0
 */
public class MailUtils {
    @Autowired
    private JavaMailSender mailSender;


    public void sendText(){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom("");
            mimeMessageHelper.setSubject("");
            mimeMessageHelper.setTo("");
            mimeMessageHelper.addAttachment("", new File(""));
            mimeMessageHelper.setText("<img src='cid:xxx'>", true);
            mimeMessageHelper.addInline("xxx",new File(""));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
