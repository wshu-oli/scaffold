package net.ws.auth.core.annotation;


import net.ws.auth.core.util.StpClientUtil;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;

/**
 * 角色认证(前台User版)：必须具有指定角色标识才能进入该方法
 * 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 *
 **/
@SaCheckRole(type = StpClientUtil.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaClientCheckRole {

    /**
     * 需要校验的角色标识
     * @return 需要校验的角色标识
     */
    @AliasFor(annotation = SaCheckRole.class)
    String [] value() default {};

    /**
     * 验证模式：AND | OR，默认AND
     * @return 验证模式
     */
    @AliasFor(annotation = SaCheckRole.class)
    SaMode mode() default SaMode.AND;

}
