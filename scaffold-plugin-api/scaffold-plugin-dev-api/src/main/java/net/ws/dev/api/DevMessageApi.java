package net.ws.dev.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import cn.hutool.json.JSONObject;

/**
 * 站内信API接口
 **/
public interface DevMessageApi {

    /**
     * 发送站内信，默认：分类系统通知
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     **/
    void sendMessage(List<String> receiverIdList, String subject);

    /**
     * 发送站内信指定分类
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     **/
    void sendMessage(List<String> receiverIdList, String category, String subject);

    /**
     * 发送站内信带内容，默认：分类系统通知
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     * @param content 站内信内容
     **/
    void sendMessageWithContent(List<String> receiverIdList, String subject, String content);

    /**
     * 发送站内信带内容，指定分类
     *
     * @param receiverIdList 接收的用户id集合
     * @param subject 主题
     * @param content 站内信内容
     **/
    void sendMessageWithContent(List<String> receiverIdList, String category, String subject, String content);

    /**
     * 获取未读站内信列表
     */
    List<JSONObject> list(List<String> receiverIdList, Integer limit);

    /**
     * 获取站内信分页
     */
    Page<JSONObject> page(List<String> receiverIdList, String category);

    /**
     * 获取站内信详情
     *
     * @param id 站内信id
     */
    JSONObject detail(String id);

}
