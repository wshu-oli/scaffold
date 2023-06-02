package net.ws.dev.core.config.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import net.ws.common.entity.CommonEntity;

import java.io.Serial;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 配置
 * </p>
 *
 * @author Oliver
 * @since 2023-06-02
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dev_config", autoResultMap = true)
@EqualsAndHashCode(callSuper = true)
public class DevConfig extends CommonEntity {


    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 备注
     */
    private String remark;
    /**
     * 扩展信息
     */
    private String extJson;
    /**
     * 分类
     */
    private String category;
    /**
     * 配置键
     */
    private String configKey;
    /**
     * 排序码
     */
    private Integer sortCode;
    /**
     * 配置值
     */
    private String configValue;

}
