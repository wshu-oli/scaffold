package net.ws.common.util;


import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonCryptogramUtil {

    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCn+m+kIBlnK" +
            "/MQ4AoV3q0bQQ6RyrERrsG8xQ2PIhTZBAG" +
            "+Rel0183DJdWKqh0g7cXkCrjnT0t6jv4Q7PH4Ev2cmKgHhKQaml5tBy0McOkL1TArlvedxFlZ0970yXAo2ihhGIcZGpnNh" +
            "/rUlTUjmUEyEduOet2794s/9gZbcPAfHwIDAQAB";

    /**
     * 私钥
     */
    private static final String PRIVATE_KEY =
            "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKf6b6QgGWcr8xDgChXerRtBDpHKsRGuwbzFDY8iFNkEAb5F6XTXzcMl1YqqHSDtxeQKuOdPS3qO/hDs8fgS/ZyYqAeEpBqaXm0HLQxw6QvVMCuW953EWVnT3vTJcCjaKGEYhxkamc2H+tSVNSOZQTIR24563bv3iz/2Bltw8B8fAgMBAAECgYAKb6USAFXeXWemNmp0qLdT3dCG6Z3jUwUsXN3BH8VFz67qtbM8aXqaKOFB0ocpbZGsNPz/Ofj0LgAbkxexaZSh/86nEj/BCp+VKWJnj1tphbwjmN7d1fCNAshUZ3kbUEYgJBslgK6mQnjotleBvFouPjTVplwG1m+oshA0hb5MmQJBAOP108ZF939bjiFp/mH3fYu6xDXreP0MLO9gT48OXoTYgraYYNPCz5MVkRu2hAis1KuKF9xOHFknBbt/wcTNVG0CQQC8o9qIQ/wEMNhBhYwSZ0M6SRP8vCqDH01AX5hZ9EyP8gOsRdhfumjAB39AZEZAVlWJgGWhnsjbCIH2u8EjphI7AkBNA5cpbCfieg75kPKlLFTY6R8yzDvS2dMwiAw423TpUrBOegp0YGN6YJXmk/HlcGZlEcFf52/CWuGf59iR4YC9AkABc2Ei2yL9BUMkfdpt6c1ijV1R/EB3ca4uaI3LY02TbdEJaiAX3F8h2uznmd3QcNmHjS066PWyeYZGV3tMwuIxAkB3kc5KJlDmR8MHCXF5WWwLfbeafjZDnjRf7pNq0DfXYOhKNP6EnJvowdtg6e+2UPCSGrb6MvREkGy9WdBH2ha+";

    /**
     * 加密方法
     *
     * @param data 待加密数据
     * @return 加密后的密文
     */
    public static String encrypt(String data) {
        RSA rsa = SecureUtil.rsa(PRIVATE_KEY, PUBLIC_KEY);
        byte[] result = rsa.encrypt(data.getBytes(), KeyType.PublicKey);
        return Base64.encode(result);
    }

    /**
     * 解密方法
     *
     * @param data 密文
     * @return 解密后的明文
     */
    public static String decrypt(String data) {
        RSA rsa = SecureUtil.rsa(PRIVATE_KEY, PUBLIC_KEY);
        byte[] result = rsa.decrypt(Base64.decode(data), KeyType.PrivateKey);
        return new String(result);
    }

    /**
     * 验证加密结果
     *
     * @param originalStr 签名原文数据
     * @param str         加密数据
     * @return 是否通过
     */
    public static boolean verify(String originalStr, String str) {
        String decrypt = decrypt(str);
        return originalStr.equals(decrypt);
    }

}
