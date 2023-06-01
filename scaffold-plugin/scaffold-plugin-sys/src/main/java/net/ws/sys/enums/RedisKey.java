package net.ws.sys.enums;

import net.ws.common.Constant;
import net.ws.common.cache.IRedisKey;

/**
 * @author ws
 * @date 2023年06月01日 09:37
 */
public enum RedisKey implements IRedisKey {

    ORG_CACHE_ALL_KEY("sys-org:all", Constant.ONE_DAY_SECONDS, "信息组织"),
    USER_CACHE_ALL_KEY("sys-user:all",Constant.ONE_DAY_SECONDS, "用户信息");
    ;

    private final String prefix;
    private final String desc;
    private final Integer expireSecond;

    RedisKey(String prefix, Integer expireSecond, String desc) {
        this.prefix = prefix;
        this.expireSecond = expireSecond;
        this.desc = desc;
    }

    public String buildKey() {
        return prefix;
    }

    public String buildKey(Object... params) {
        if (params == null || params.length == 0 || (params.length == 1 && params[0] == null)) {
            return prefix;
        }
        return String.format(prefix, params);
    }

    public String getDesc() {
        return desc;
    }

    public String getPrefix() {
        return prefix;
    }

    public Integer getExpireSecond() {
        return expireSecond;
    }

    public Integer getExpireMinute() {
        if (expireSecond == null) {
            return null;
        }
        return expireSecond / 60;
    }

}
