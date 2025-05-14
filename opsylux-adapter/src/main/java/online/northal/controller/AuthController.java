package online.northal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.domain.entity.SysUser;
import online.northal.dto.auth.LoginRequestDTO;
import online.northal.response.ActionResult;
import online.northal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "认证接口")
public class AuthController {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户登录")
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
