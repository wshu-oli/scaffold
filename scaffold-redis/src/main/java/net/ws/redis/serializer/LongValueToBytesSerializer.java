package net.ws.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class LongValueToBytesSerializer implements RedisSerializer<Number> {
    static byte[] NULL = new byte[]{0};

    @Override
    public byte[] serialize(Number aLong) throws SerializationException {
        if (aLong == null) {
            return NULL;
        } else {
            return long2Bytes(aLong.longValue());
        }
    }

    @Override
    public Long deserialize(byte[] bytes) throws SerializationException {
        assert bytes != null;
        if (bytes.length == 1 && bytes[0] == 0) {
            return null;
        }
        return bytes2Long(bytes);
    }

    public static byte[] long2Bytes(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    public static Long bytes2Long(byte[] byteNum) {
        long num = 0;
        for (int ix = 0; ix < 8; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }


}
