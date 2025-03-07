package springboot.tdl.service.login;

public interface MailService {

    /**
     * @param recipient 宛先
     * @return randomNumber
     */
    Integer sendMail(String recipient);
}
