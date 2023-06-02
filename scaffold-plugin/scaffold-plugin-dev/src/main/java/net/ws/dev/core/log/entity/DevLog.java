package net.ws.dev.core.log.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import net.ws.common.entity.BaseEntity;
import net.ws.dev.enums.DevLogCategory;
import net.ws.dev.enums.DevLogExeStatus;

import java.io.Serial;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 日志
 * </p>
 *
 * @author Oliver
 * @since 2023-06-02
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "dev_log", autoResultMap = true)
@EqualsAndHashCode(callSuper = true)
public class DevLog extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 日志名称
     */
    private String name;
    /**
     * 操作ip
     */
    private String opIp;
    /**
     * 操作系统
     */
    private String opOs;
    /**
     * 签名数据
     */
    private String sign;
    /**
     * 操作人姓名
     */
    private String opUserName;
    /**
     * 请求地址
     */
    private String reqUrl;
    /**
     * 请求参数
     */
    private String reqJson;
    /**
     * 日志分类
     */
    private DevLogCategory category;
    /**
     * 返回结果
     */
    private String respJson;
    /**
     * 执行状态
     */
    private DevLogExeStatus exeStatus;
    /**
     * 操作地址
     */
    private String opAddress;
    /**
     * 操作浏览器
     */
    private String opBrowser;
    /**
     * 类名称
     */
    private String className;
    /**
     * 请求方式
     */
    private String reqMethod;
    /**
     * 具体消息
     */
    private String exeMessage;
    /**
     * 方法名称
     */
    private String methodName;
    /**
     * 操作时间
     */
    private LocalDateTime opTime;
}
