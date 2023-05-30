package net.ws.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.StringUtils;

public class LongValueSerializer implements RedisSerializer<Number> {
    @Override
    public byte[] serialize(Number aLong) throws SerializationException {
        String value = "";
        if (aLong != null) {
            value = aLong.toString();
        }
        return value.getBytes();
    }

    @Override
    public Long deserialize(byte[] bytes) throws SerializationException {
        String value = new String(bytes);
        if (StringUtils.hasLength(value)) {
            return Long.valueOf(value);
        }
        return null;
    }
}
