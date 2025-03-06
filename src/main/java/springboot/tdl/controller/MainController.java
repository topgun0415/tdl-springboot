package springboot.tdl.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Tag(name = "main", description = "main page's API")
public class MainController {

    @Operation(summary = "rendering", description = "rendering main page")
    @GetMapping()
    public String view() {
        return "redirect:/login";
    }



}
