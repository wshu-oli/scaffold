package net.ws.sys.api;

import java.util.List;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.json.JSONObject;

/**
 * 组织API
 **/
public interface SysOrgApi {

    /**
     * 根据id获取名称
     *
     * @author xuyuxiang
     * @date 2022/8/4 10:12
     **/
    String getNameById(String orgId);

    /**
     * 根据组织id获取部门主管id
     *
     * @author xuyuxiang
     * @date 2022/6/6 14:50
     **/
    String getSupervisorIdByOrgId(String orgId);

    /**
     * 获取组织树选择器
     *
     * @author xuyuxiang
     * @date 2022/7/22 14:46
     **/
    List<Tree<String>> orgTreeSelector();

    /**
     * 获取组织列表选择器
     *
     * @author xuyuxiang
     * @date 2022/7/22 14:45
     **/
    List<JSONObject> orgListSelector(String parentId);
}
