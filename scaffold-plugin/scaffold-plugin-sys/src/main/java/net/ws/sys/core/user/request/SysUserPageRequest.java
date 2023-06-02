package net.ws.sys.core.user.request;

import net.ws.auth.core.enums.UserStatus;
import net.ws.sys.enums.CommonSortOrderEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户查询参数
 **/
@Getter
@Setter
public class SysUserPageRequest {

    /** 每页条数 */
    private Integer size;
    /** 所属组织 */
    private Long orgId;
    /** 当前页 */
    private Integer current;
    /** 排序字段 */
    private String sortField;
    /** 排序方式 */
    private CommonSortOrderEnum sortOrder;
    /** 账号、姓名关键词 */
    private String searchKey;
    /** 用户状态 */
    private UserStatus userStatus;
}
