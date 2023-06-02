package net.ws.auth.core.annotation;

import net.ws.auth.core.util.StpClientUtil;

import java.lang.annotation.*;

import cn.dev33.satoken.annotation.SaCheckLogin;

/**
 * 登录认证(前台User版)：只有登录之后才能进入该方法
 * 可标注在函数、类上（效果等同于标注在此类的所有方法上）
 *
 **/
@SaCheckLogin(type = StpClientUtil.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface SaClientCheckLogin {

}
