package springboot.tdl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
@Tag(name = "signup", description = "sign page's API")
public class SignUpController {

    @Operation(summary = "rendering", description = "rendering signup page")
    @GetMapping()
    public String view() {
        return "page/signup";
    }


    @PostMapping("signup")
    public String signUp() {

        return "redirect:/login";

    }


}
