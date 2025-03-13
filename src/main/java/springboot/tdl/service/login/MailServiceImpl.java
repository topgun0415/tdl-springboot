package springboot.tdl.service.login;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "topgun920415@gmail.com";

    /**
     * メール送信
     *
     * @param recipient 宛先
     * @return randomNumber
     */
    @Override
    public Integer sendMail(String recipient) {
        MimeMessage message = createMail(recipient);
        javaMailSender.send(message);

        return createRandomNumber();
    }

    /**
     * メール新規作成
     *
     * @param recipient 宛先
     * @return randomNumber
     */
    private MimeMessage createMail(String recipient) {
        int randomNumber = createRandomNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, recipient);
            message.setSubject("For Your Precious Dayのメール認証番号です。");
            String body = "";
            body += "<h3>" + "お客様の認証番号です。" + "</h3>";
            body += "<h1>" + randomNumber + "</h1>";
            body += "<h3>" + "ありがとうございます。" + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * メール新規作成
     *
     * @return ランダム認証番号（169139）
     */
    private static Integer createRandomNumber() {
        return (int)(Math.random() * (90000)) + 100000;
    }
}


