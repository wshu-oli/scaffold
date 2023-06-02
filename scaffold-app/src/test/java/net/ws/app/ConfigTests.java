package net.ws.app;

import net.ws.Application;
import net.ws.dev.core.config.entity.DevConfig;
import net.ws.dev.core.config.service.DevConfigService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;

import java.util.List;

/**
 * @author ws
 * @date 2023年06月02日 14:25
 */
@SpringBootTest(classes = Application.class)
public class ConfigTests {

    @Resource
    private DevConfigService service;

    @Test
    public void test() {
        List<DevConfig> list = service.list();
        System.out.println("list = " + list.size());
    }
}
