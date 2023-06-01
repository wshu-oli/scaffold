package net.ws.sys.api;

import java.util.List;

import cn.hutool.json.JSONObject;

/**
 * 职位API
 **/
public interface SysPositionApi {

    /**
     * 根据id获取名称
     *
     * @author xuyuxiang
     * @date 2022/8/4 10:13
     **/
    String getNameById(String positionId);

    /**
     * 获取职位选择器
     *
     * @author xuyuxiang
     * @date 2022/7/22 14:47
     **/
    List<JSONObject> positionSelector(String orgId, String searchKey);
}
