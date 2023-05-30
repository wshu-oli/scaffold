package net.ws.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * @author Oliver
 * @date 2023年03月10日 12:57 PM
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class UpdateEntity extends BaseEntity {

    /**
     * 创建用户
     */
    private Long modifier;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;
}
