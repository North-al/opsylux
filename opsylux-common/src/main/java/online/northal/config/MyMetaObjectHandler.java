package online.northal.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createdAt = getFieldValByName("createdAt", metaObject);
        Object updatedAt = getFieldValByName("updatedAt", metaObject);

        if (createdAt == null) this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now());
        if (updatedAt == null) this.strictInsertFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedAt", LocalDateTime.class, LocalDateTime.now());
    }
}