package net.ws.sys.api;

import java.util.List;

import cn.hutool.json.JSONObject;

/**
 * 角色API
 **/
public interface SysRoleApi {

    /**
     * 判断组织下是否存在角色
     */
    boolean orgHasRole(List<String> orgIdList);

    /**
     * 获取角色选择器
     **/
    List<JSONObject> roleSelector(String orgId, String category, String searchKey);

    /**
     * 代码生成菜单按钮授权
     **/
    void grantForGenMenuAndButton(String menuId);
}
