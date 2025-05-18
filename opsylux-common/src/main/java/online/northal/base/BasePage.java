package online.northal.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BasePage {
    @Schema(description = "当前页码", example = "1")
    private Integer page = 1;

    @Schema(description = "每页条数", example = "10")
    private Integer limit = 10;

    // 一个可选的搜索关键字
    @Schema(description = "搜索关键字", example = "keyword", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String keyword = "";

    public <T> IPage<T> toPage() {
        return new Page<>(this.page == null ? 1 : this.page, this.limit == null ? 10 : this.limit);
    }
}
