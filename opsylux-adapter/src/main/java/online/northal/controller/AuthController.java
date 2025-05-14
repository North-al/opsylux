package online.northal.controller;

import online.northal.domain.entity.SysUser;
import online.northal.response.ActionResult;
import online.northal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ActionResult<SysUser> login() {
        SysUser user = userService.getUserById(1L);
        return ActionResult.success(user);
    }

    @GetMapping("/test")
    public ActionResult<String> test() {
        return ActionResult.success("Test successful");
    }
}
