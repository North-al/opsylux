package online.northal.controller;

import online.northal.response.ActionResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "Login successful";
    }

    @GetMapping("/test")
    public ActionResult<String> test() {
        return ActionResult.success("Test successful");
    }
}
