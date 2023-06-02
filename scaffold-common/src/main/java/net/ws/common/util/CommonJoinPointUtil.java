package net.ws.common.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

/**
 * Spring切面工具类
 */
public class CommonJoinPointUtil {

    /**
     * 获取切面的参数JSON
     *
     * @author xuyuxiang
     * @date 2022/9/2 15:51
     */
    public static String getArgsJsonString(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        // 参数名数组
        String[] parameterNames = ((MethodSignature) signature).getParameterNames();
        // 构造参数组集合
        Map<String, Object> map = MapUtil.newHashMap();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (ObjectUtil.isNotEmpty(args[i]) && isUsefulParam(args[i])) {
                if (JSONUtil.isTypeJSON(StrUtil.toString(args[i]))) {
                    map.put(parameterNames[i], JSONUtil.parseObj(args[i]));
                } else {
                    map.put(parameterNames[i], JSONUtil.toJsonStr(args[i]));
                }
            }
        }
        return JSONUtil.toJsonStr(map);
    }

    /**
     * 判断是否需要拼接的参数，过滤掉HttpServletRequest,MultipartFile,HttpServletResponse等类型参数
     *
     * @author xuyuxiang
     * @date 2022/9/2 15:51
     */
    private static boolean isUsefulParam(Object arg) {
        return !(arg instanceof MultipartFile) &&
                !(arg instanceof HttpServletRequest) &&
                !(arg instanceof HttpServletResponse);
    }
}
