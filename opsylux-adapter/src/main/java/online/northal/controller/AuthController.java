package online.northal.controller;

import online.northal.domain.entity.SysUser;
import online.northal.dto.auth.LoginRequestDTO;
import online.northal.response.ActionResult;
import online.northal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ActionResult<String> login(@RequestBody @Valid LoginRequestDTO dto) {
        String login = userService.login(dto);
        return ActionResult.success(login);
    }

    @GetMapping("/test")
    public ActionResult<String> test() {
        return ActionResult.success("Test successful");
    }
}
