package online.northal.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.base.BaseController;
import online.northal.domain.entity.SysUser;
import online.northal.dto.user.UserResponseDto;
import online.northal.response.ActionResult;
import online.northal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "用户接口")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @GetMapping("/profile")
    @Operation(summary = "获取用户信息", description = "获取当前登录用户的信息")
    public ActionResult<SysUser> getUserProfile() {
        Long id = this.getUserId();
        SysUser user = userService.getUserById(id);
        if (user == null) return ActionResult.fail("用户不存在");
        return ActionResult.success(user);
    }
}
