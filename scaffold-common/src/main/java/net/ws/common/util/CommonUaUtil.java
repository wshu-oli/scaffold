package net.ws.common.util;


import jakarta.servlet.http.HttpServletRequest;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.useragent.UserAgent;

/**
 * 用户代理工具类
 */
public class CommonUaUtil {

    /**
     * 获取客户端浏览器
     */
    public static String getBrowser(HttpServletRequest request) {
        UserAgent userAgent = getUserAgent(request);
        if (ObjectUtil.isEmpty(userAgent)) {
            return StrUtil.DASHED;
        } else {
            String browser = userAgent.getBrowser().toString();
            return "Unknown".equals(browser) ? StrUtil.DASHED : browser;
        }
    }

    /**
     * 获取客户端操作系统
     */
    public static String getOs(HttpServletRequest request) {
        UserAgent userAgent = getUserAgent(request);
        if (ObjectUtil.isEmpty(userAgent)) {
            return StrUtil.DASHED;
        } else {
            String os = userAgent.getOs().toString();
            return "Unknown".equals(os) ? StrUtil.DASHED : os;
        }
    }

    /**
     * 获取请求代理头
     */
    private static UserAgent getUserAgent(HttpServletRequest request) {
        /*String userAgentStr = ServletUtil.getHeaderIgnoreCase(request, "User-Agent");
        UserAgent userAgent = UserAgentUtil.parse(userAgentStr);
        if (ObjectUtil.isNotEmpty(userAgentStr)) {
            if ("Unknown".equals(userAgent.getBrowser().getName())) {
                userAgent.setBrowser(new Browser(userAgentStr, null, ""));
            }
        }
        return userAgent;*/
        return null;
    }
}
