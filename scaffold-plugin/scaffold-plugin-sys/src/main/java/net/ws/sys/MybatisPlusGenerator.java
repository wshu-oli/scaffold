package net.ws.sys;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * mybatis-plus代码自动生成器
 *
 * @author Oliver
 * @date 2023年03月18日 13:24
 */
public class MybatisPlusGenerator {
    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/snowy?useUnicode=true&characterEncoding=UTF-8&useSSL=false" +
            "&serverTimezone=Asia/Shanghai", "root", "z314159.");

    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("Oliver") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            //.enableSwagger() // 开启 swagger 模式
                            // 指定输出目录
                            //直接右键复制项目根目录的绝对路径
                            .outputDir("/Users/zxj/Documents/workspace/backend/Oliver/scaffold/scaffold-plugin/scaffold-plugin-sys/src/main/java");
                })
                .packageConfig(builder -> {
                    builder.parent("net.ws.sys.core") // 设置父包名
                            .moduleName("user")
                            // 设置mapperXml生成路径
                            //直接右键复制项目mapper文件夹的绝对路径
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/zxj/Documents/workspace/backend/Oliver/scaffold/scaffold-plugin/scaffold-plugin-sys/src/main/java/net/ws/sys/core/user/mapper/xml"));
                })
                .strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude("sys_user")
                            .addTablePrefix("tb_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板(需要导包)，默认的是Velocity引擎模板
                .execute();
    }
}
