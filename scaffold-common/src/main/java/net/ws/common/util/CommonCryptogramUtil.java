package net.ws.common.util;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
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


    public static void main(String[] args) {
        RSA rsa = new RSA();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        System.out.println("privateKeyBase64 = " + privateKeyBase64);
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        System.out.println("publicKeyBase64 = " + publicKeyBase64);
    }

    /**
     * 加密方法
     *
     * @param str 待加密数据
     * @return 加密后的密文
     */
    public static String encrypt(String str) {
        RSA rsa = new RSA();
        return StrUtil.str(rsa.encrypt(StrUtil.bytes(str, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey),
                CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 解密方法
     *
     * @param str 密文
     * @return 解密后的明文
     */
    public static String decrypt(String str) {
        // 解密
        RSA rsa = new RSA();
        rsa.decrypt(encrypt, KeyType.PrivateKey);
        return Sm2.doDecrypt(str, PRIVATE_KEY);
    }

    /**
     * 加密方法
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 待加密数据
     * @return 加密后的密文
     */
    /*public static String doSm4CbcEncrypt(String str) {
        // SM4 加密  cbc模式
        Sm4Options sm4Options4 = new Sm4Options();
        sm4Options4.setMode("cbc");
        sm4Options4.setIv("fedcba98765432100123456789abcdef");
        return Sm4.encrypt(str, KEY, sm4Options4);
    }*/

    /**
     * 解密方法
     * 如果采用加密机的方法，用try catch 捕捉异常，返回原文值即可
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 密文
     * @return 解密后的明文
     */
    /*public static String doSm4CbcDecrypt(String str) {
        // 解密，cbc 模式，输出 utf8 字符串
        Sm4Options sm4Options8 = new Sm4Options();
        sm4Options8.setMode("cbc");
        sm4Options8.setIv("fedcba98765432100123456789abcdef");
        String docString =  Sm4.decrypt(str, KEY, sm4Options8);
        if (docString.equals("")) {
            log.warn(">>> 字段解密失败，返回原文值：{}", str);
            return str;
        } else {
            return docString;
        }
    }*/

    /**
     * 纯签名
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 待签名数据
     * @return 签名结果
     */
    /*public static String doSignature(String str) {
        return Sm2.doSignature(str, PRIVATE_KEY);
    }*/

    /**
     * 验证签名结果
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param originalStr 签名原文数据
     * @param str 签名结果
     * @return 是否通过
     */
    /*public static boolean doVerifySignature(String originalStr, String str) {
        return Sm2.doVerifySignature(originalStr, str, PUBLIC_KEY);
    }*/

    /**
     * 通过杂凑算法取得hash值，用于做数据完整性保护
     *
     * @author yubaoshan
     * @date 2022/9/15 21:51
     * @param str 字符串
     * @return hash 值
     */
    /*public static String doHashValue(String str) {
        return Sm3.sm3(str);
    }*/
}
