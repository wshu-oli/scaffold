package net.ws.dev.api;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONObject;

/**
 * 邮件API接口
 **/
public interface DevEmailApi {

    /* =========本地邮件========= */

    /**
     * 发送纯文本邮件
     *
     * @param tos 收件人邮箱，逗号拼接
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param files 附件列表
     */
    void sendTextEmailLocal(String tos, String subject, String content, List<File> files);

    /**
     * 发送HTML邮件
     *
     * @param tos 收件人邮箱，逗号拼接
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param imageMap – 图片与占位符，占位符格式为cid:$IMAGE_PLACEHOLDER
     * @param files 附件列表
     */
    void sendHtmlEmailLocal(String tos, String subject, String content, Map<String, InputStream> imageMap, List<File> files);

    /* =========阿里云邮件========= */

    /**
     * 发送纯文本邮件（不使用模板，频率限制100 QPS）
     *
     * @param from 管理控制台中配置的发信地址，必传且必须正确
     * @param user 发信人昵称，长度小于15个字符，可不传
     * @param tos 目标地址，多个 email 地址可以用逗号分隔，最多100个地址，必传且必须正确
     * @param subject 邮件主题，必传
     * @param content 邮件 txt 正文，限制28K，必传
     **/
    void sendTextEmailAliyun(String from, String user, String tos, String subject, String content);

    /**
     * 发送HTML邮件（不使用模板，频率限制100 QPS）
     *
     * @param from 管理控制台中配置的发信地址，必传且必须正确
     * @param user 发信人昵称，长度小于15个字符，可不传
     * @param tos 目标地址，多个 email 地址可以用逗号分隔，最多100个地址，必传且必须正确
     * @param subject 邮件主题，必传
     * @param content 邮件 html 正文，限制28K，必传
     **/
    void sendHtmlEmailAliyun(String from, String user, String tos, String subject, String content);

    /**
     * 使用模板发送邮件，国内频率限制是20/min；海外频率限制是10/min。
     *
     * @param from 管理控制台中配置的发信地址，必传且必须正确
     * @param tagName 控制台创建的邮件标签，可不传
     * @param toName 预先创建且上传了收件人的收件人列表名称，必传且必须正确
     * @param templateName 预先创建且通过审核的模板名称，必传且必须正确
     **/
    void sendEmailWithTemplateAliyun(String from, String tagName, String toName, String templateName);

    /* =========腾讯云邮件========= */

    /**
     * 发送纯文本邮件（不使用模板，默认接口请求频率限制：20次/秒。）
     *
     * @param from 管理控制台中配置的发信地址，必传且必须正确
     * @param user 发信人昵称，可不传
     * @param tos 目标地址，多个 email 地址可以用逗号分隔，最多50个地址，必传且必须正确，非群发邮件请多次调用API发送
     * @param subject 邮件主题，必传
     * @param content 邮件 txt 正文，必传，注意：腾讯云api目前要求请求包大小不得超过8 MB。
     * @param attachmentList 需要发送附件时，填写附件相关参数，格式:[{"FileName": "xxxx", "Content": "xxx"}]
     *                       支持的格式与说明见：https://cloud.tencent.com/document/api/1288/51053#Attachment
     **/
    void sendTextEmailTencent(String from, String user, String tos, String subject, String content, List<JSONObject> attachmentList);

    /**
     * 发送HTML邮件（不使用模板，默认接口请求频率限制：20次/秒。）
     *
     * @param from 管理控制台中配置的发信地址，必传且必须正确
     * @param user 发信人昵称，可不传
     * @param tos 目标地址，多个 email 地址可以用逗号分隔，最多50个地址，必传且必须正确，非群发邮件请多次调用API发送
     * @param subject 邮件主题，必传
     * @param content 邮件 txt 正文，必传，注意：腾讯云api目前要求请求包大小不得超过8 MB。
     * @param attachmentList 需要发送附件时，填写附件相关参数，格式:[{"FileName": "xxxx", "Content": "xxx"}]
     *                       支持的格式与说明见：https://cloud.tencent.com/document/api/1288/51053#Attachment
     **/
    void sendHtmlEmailTencent(String from, String user, String tos, String subject, String content, List<JSONObject> attachmentList);

    /**
     * 使用模板发送邮件，默认接口请求频率限制：20次/秒。
     *
     * @param from 管理控制台中配置的发信地址，必传且必须正确
     * @param user 发信人昵称，可不传
     * @param toId 预先创建且上传了收件人的收件人列表id，必传且必须正确
     * @param templateId 预先创建且通过审核的模板Id，必传且必须正确
     * @param templateParam 预先创建且通过审核的模板的参数json，格式{"name":"张三"}，可不传
     * @param subject 邮件主题，必传
     **/
    void sendEmailWithTemplateTencent(String from, String user, String toId, String templateId, String templateParam, String subject, List<JSONObject> attachmentList);
}
