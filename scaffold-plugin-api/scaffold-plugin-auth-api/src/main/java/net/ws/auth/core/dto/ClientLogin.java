package net.ws.auth.core.dto;

import net.ws.auth.core.enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 基础的C端登录用户对象，可继承此类扩展更多属性
 */
@Getter
@Setter
public abstract class ClientLogin {

    /**
     * id
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别
     */
    private Gender gender;
    /**
     * 民族
     */
    private String nation;
    /**
     * 学位
     */
    private Degree degree;
    /**
     * 账号
     */
    private String account;
    /**
     * 毕业院校
     */
    private String college;
    /**
     * 家庭电话
     */
    private String homeTel;
    /**
     * 扩展信息
     */
    private String extJson;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户密码hash值
     */
    private String password;
    /**
     * 签名
     */
    private String signature;
    /**
     * 办公电话
     */
    private String officeTel;
    /**
     * 排序码
     */
    private Integer sortCode;
    /**
     * 学制
     */
    private Integer eduLength;
    /**
     * 出生日期
     */
    private LocalDate birthday;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 家庭住址
     */
    private String homeAddress;
    /**
     * 上次登录ip
     */
    private String lastLoginIp;
    /**
     * 证件号码
     */
    private String idCardNumber;
    /**
     * 通信地址
     */
    private String mailingAddress;
    /**
     * 证件类型
     */
    private IdCardType idCardType;
    /**
     * 紧急联系人电话
     */
    private String emergencyPhone;
    /**
     * 用户状态
     */
    private UserStatus userStatus;
    /**
     * 上次登录设备
     */
    private String lastLoginDevice;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系人地址
     */
    private String emergencyAddress;
    /**
     * 上次登录地点
     */
    private String lastLoginAddress;
    /**
     * 角色码集合
     */
    private List<String> roleCodeList;
    /**
     * 学历
     */
    private EducationalLevel education;
    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 按钮码集合
     */
    private List<String> buttonCodeList;
    /**
     * 数据范围集合
     */
    private List<DataScope> dataScopeList;
    /**
     * 权限码集合
     */
    private List<String> permissionCodeList;
    /**
     * 移动端按钮码集合
     */
    private List<String> mobileButtonCodeList;
    /**
     * 政治面貌
     */
    private PoliticalAffiliation politicalAffiliation;

    /**
     * 是否可登录，由继承类实现
     */
    public abstract Boolean getEnabled();

    /**
     * 数据范围类
     *
     * @author xuyuxiang
     * @date 2022/8/15 13:57
     **/
    @Getter
    @Setter
    public static class DataScope {

        /**
         * API接口
         */
        private String apiUrl;

        /**
         * 数据范围
         */
        private List<String> dataScope;
    }
}
