package net.ws.common.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;

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
public abstract class CommonEntity extends UpdateEntity {
    /**
     * 是否已删除
     */
    @TableLogic
    private Integer deleted;

}
