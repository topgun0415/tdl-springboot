package springboot.tdl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@Tag(name = "login", description = "login page's API")
public class LoginController {

    @Operation(summary = "rendering", description = "rendering login page")
    @GetMapping()
    public String view() {
        return "page/login";
    }



}
