package online.northal.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.base.BaseController;
import online.northal.domain.entity.SysUser;
import online.northal.dto.user.UserProfileResponseDTO;
import online.northal.dto.user.UserSaveRequestDTO;
import online.northal.response.ActionResult;
import online.northal.service.IUserService;
import online.northal.validation.Create;
import online.northal.validation.Update;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "用户接口")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @GetMapping("/profile")
    @Operation(summary = "获取用户信息", description = "获取当前登录用户的信息")
    public ActionResult<UserProfileResponseDTO> getUserProfile() {
        Long id = this.getUserId();
        SysUser user = userService.getUserById(id);
        if (user == null) return ActionResult.fail("用户不存在");

        UserProfileResponseDTO userProfileResponseDTO = new UserProfileResponseDTO();
        BeanUtils.copyProperties(user, userProfileResponseDTO);
        return ActionResult.success(userProfileResponseDTO);
    }

    @PutMapping
    @Operation(summary = "更新用户信息")
    public ActionResult<Boolean> update(@Validated(Update.class) @RequestBody UserSaveRequestDTO dto) {
        boolean b = this.userService.updateUser(dto);
        if (!b) return ActionResult.fail(false, "更新用户信息失败");
        return ActionResult.success(true, "更新用户信息成功");
    }

    @PostMapping
    @Operation(summary = "添加用户")
    public ActionResult<Long> add(@Validated(Create.class) @RequestBody UserSaveRequestDTO dto) {
        Long userId = this.userService.saveUser(dto);
        return ActionResult.success(userId, "添加用户成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户")
    public ActionResult<Boolean> delete(@PathVariable Long id) {
        boolean b = this.userService.deleteUser(id);
        if (!b) return ActionResult.fail(false, "删除用户失败");
        return ActionResult.success(true, "删除用户成功");
    }
}
