package springboot.tdl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.tdl.service.login.MailService;
import springboot.tdl.service.login.LoginService;


@Controller
@RequestMapping("/login")
@Tag(name = "login", description = "login page's API")
public class LoginController {

    private final MailService mailService;
    private final LoginService loginService;

    @Autowired
    public LoginController(MailService mailService, LoginService loginService) {
        this.mailService = mailService;
        this.loginService = loginService;

    }




    @Operation(summary = "rendering", description = "rendering login page")
    @GetMapping()
    public String view() {
        return "page/login";
    }



}
