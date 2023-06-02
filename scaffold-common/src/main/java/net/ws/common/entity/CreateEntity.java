package net.ws.common.entity;

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
public abstract class CreateEntity extends BaseEntity {
    /**
     * 创建用户
     */
    private Long creator;

}
