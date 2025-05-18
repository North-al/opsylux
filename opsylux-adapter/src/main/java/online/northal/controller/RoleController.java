package online.northal.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.base.BaseController;
import online.northal.base.BasePage;
import online.northal.domain.entity.SysRole;
import online.northal.domain.entity.SysUser;
import online.northal.dto.role.RoleListResponseDTO;
import online.northal.dto.role.RoleSaveRequestDTO;
import online.northal.response.ActionResult;
import online.northal.service.IRoleService;
import online.northal.validation.Create;
import online.northal.validation.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Tag(name = "角色管理", description = "角色管理相关接口")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @PostMapping
    @Operation(summary = "新增角色", description = "根据请求参数创建新的角色，返回创建的角色ID")
    public ActionResult<Long> add(@Validated(Create.class) @RequestBody RoleSaveRequestDTO role) {
        Long savedRoleId = this.roleService.saveRole(role);
        return ActionResult.success(savedRoleId);
    }

    @PutMapping
    @Operation(summary = "更新角色", description = "根据请求参数更新现有角色，返回更新是否成功")
    public ActionResult<Boolean> update(@Validated(Update.class) @RequestBody RoleSaveRequestDTO role) {
        boolean updated = this.roleService.updateRole(role);
        if (!updated) {
            return ActionResult.fail(false,"更新角色失败");
        }
        return ActionResult.success(true, "更新角色成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除角色", description = "根据ID删除角色，返回删除是否成功")
    public ActionResult<Boolean> delete(@PathVariable Long id) {
        boolean deleted = this.roleService.deleteRole(id);
        if (!deleted) {
            return ActionResult.fail(false,"删除角色失败");
        }
        return ActionResult.success(true, "删除角色成功");
    }

    @GetMapping
    @Operation(summary = "获取角色列表", description = "获取角色分页列表")
    public ActionResult<IPage<RoleListResponseDTO>> list(BasePage page) {
        IPage<RoleListResponseDTO> rolePage = this.roleService.getRoleByPage(page);
        return ActionResult.success(rolePage, "获取角色列表成功");
    }
}
