package net.ws.redis;

public interface IRedisKey {

    String getDesc();

    String getPrefix();

    Integer getExpireMinute();

    default String buildKey() {
        return getPrefix();
    }

    default String buildKey(Object... params) {
        if (params == null || params.length == 0 || (params.length == 1 && params[0] == null)) {
            return getPrefix();
        }
        return String.format(getPrefix(), params);
    }


}
