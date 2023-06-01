package net.ws.sys.core.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import net.ws.db.entity.CommonEntity;
import net.ws.sys.enums.*;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Oliver
 * @since 2023-06-01
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user", autoResultMap = true)
@EqualsAndHashCode(callSuper = true)
public class SysUser extends CommonEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Gender gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 签名
     */
    private String signature;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 通信地址
     */
    private String mailingAddress;

    /**
     * 证件类型
     */
    private IdCardType idCardType;

    /**
     * 证件号码
     */
    private String idCardNumber;

    /**
     * 政治面貌
     */
    private PoliticalAffiliation politicalAffiliation;

    /**
     * 毕业院校
     */
    private String college;

    /**
     * 学历
     */
    private EducationalLevel education;

    /**
     * 学制
     */
    private Integer eduLength;

    /**
     * 学位
     */
    private Degree degree;

    /**
     * 家庭电话
     */
    private String homeTel;

    /**
     * 办公电话
     */
    private String officeTel;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 紧急联系人电话
     */
    private String emergencyPhone;

    /**
     * 员工编号
     */
    private String empNo;

    /**
     * 入职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    /**
     * 机构id
     */
    private Long orgId;

    /**
     * 职位id
     */
    private Long positionId;

    /**
     * 职级
     */
    private String positionLevel;

    /**
     * 主管id
     */
    private Long directorId;

    /**
     * 兼任信息
     */
    private String positionJson;

    /**
     * 上次登录ip
     */
    private Integer lastLoginIp;

    /**
     * 上次登录地点
     */
    private String lastLoginAddress;

    /**
     * 上次登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

    /**
     * 上次登录设备
     */
    private String lastLoginDevice;

    /**
     * 用户状态
     */
    private String status;

}
