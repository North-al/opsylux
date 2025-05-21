package online.northal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import online.northal.base.BaseController;
import online.northal.domain.entity.SysMenu;
import online.northal.dto.menu.MenuSaveRequestDTO;
import online.northal.dto.menu.MenuTreeResponseDTO;
import online.northal.response.ActionResult;
import online.northal.service.IMenuService;
import online.northal.validation.Create;
import online.northal.validation.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
@Tag(name = "Menu", description = "菜单接口")
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;


    @PostMapping
    @Operation(summary = "添加菜单")
    public ActionResult<Long> add(@Validated(Create.class) @RequestBody MenuSaveRequestDTO menu) {
        Long menuId = this.menuService.saveMenu(menu);
        return ActionResult.success(menuId, "添加菜单成功");
    }

    @PutMapping
    @Operation(summary = "更新菜单")
    public ActionResult<Boolean> update(@Validated(Update.class) @RequestBody MenuSaveRequestDTO menu) {
        boolean b = this.menuService.updateMenu(menu);
        if (!b) return ActionResult.fail(false, "更新菜单失败");
        return ActionResult.success(true, "更新菜单成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除菜单")
    public ActionResult<Boolean> delete(@PathVariable Long id) {
        boolean b = this.menuService.deleteMenu(id);
        if (!b) return ActionResult.fail(false, "删除菜单失败");
        return ActionResult.success(true, "删除菜单成功");
    }

    @GetMapping("/list")
    @Operation(summary = "获取菜单列表")
    public ActionResult<List<SysMenu>> getAllMenuList(@RequestParam(value = "menuTitle", required = false) String menuTitle) {
        return ActionResult.success(this.menuService.getAllMenuList(menuTitle), "获取菜单列表成功");
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取菜单详情")
    public ActionResult<SysMenu> getMenuById(@PathVariable Long id) {
        SysMenu menu = this.menuService.getMenuById(id);
        if (menu == null) return ActionResult.fail(null, "获取菜单详情失败");
        return ActionResult.success(menu, "获取菜单详情成功");
    }

    @GetMapping("/tree")
    @Operation(summary = "获取菜单树")
    public ActionResult<ArrayList<MenuTreeResponseDTO>> getMenuTree(
            @RequestParam(value = "menuTitle", required = false) String menuTitle,
            @RequestParam(value = "type", required = false, defaultValue = "0,1,2") String[] type
    ) {
        return ActionResult.success(this.menuService.getMenuTree(menuTitle, type), "获取菜单树成功");
    }

}
