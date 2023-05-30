package net.ws.app;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {

    /**
     * 主启动函数
     *
     * @author xuyuxiang
     * @date 2022/7/30 21:42
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
        log.info(">>> {}", Application.class.getSimpleName().toUpperCase() + " STARTING SUCCESS");
    }
}
