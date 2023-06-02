package net.ws.sys.core.user.request;

import net.ws.auth.core.enums.*;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户查询参数
 **/
@Getter
@Setter
public class SysUserAddRequest {

    /**
     * 组织id
     */
    @NotBlank(message = "orgId不能为空")
    private Long orgId;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 姓名
     */
    @NotBlank(message = "name不能为空")
    private String name;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 员工编号
     */
    private String empNo;
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
    @NotBlank(message = "account不能为空")
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
     * 职位id
     */
    @NotBlank(message = "positionId不能为空")
    private Long positionId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 出生日期
     */
    private LocalDate birthday;
    /**
     * 签名
     */
    private String signature;
    /**
     * 学历
     */
    private EducationalLevel education;
    /**
     * 学制
     */
    private Integer eduLength;
    /**
     * 办公电话
     */
    private String officeTel;
    /**
     * 入职日期
     */
    private LocalDate entryDate;
    /**
     * 排序码
     */
    private Integer sortCode;
    /**
     * 主管id
     */
    private Long directorId;
    /**
     * 证件类型
     */
    private IdCardType idCardType;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 家庭住址
     */
    private String homeAddress;
    /**
     * 证件号码
     */
    private String idCardNumber;
    /**
     * 文化程度
     */
    private String cultureLevel;
    /**
     * 兼任信息
     */
    private String positionJson;
    /**
     * 职级
     */
    private String positionLevel;
    /**
     * 通信地址
     */
    private String mailingAddress;
    /**
     * 紧急联系人电话
     */
    private String emergencyPhone;
    /**
     * 政治面貌
     */
    private PoliticalAffiliation politicalAffiliation;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系人地址
     */
    private String emergencyAddress;
}
