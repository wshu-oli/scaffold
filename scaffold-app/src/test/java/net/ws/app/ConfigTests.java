package net.ws.app;

import net.ws.dev.core.config.entity.DevConfig;
import net.ws.dev.core.config.service.DevConfigService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * @author ws
 * @date 2023年06月02日 14:25
 */
@SpringBootTest(classes = Application.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConfigTests {

    private final DevConfigService service;

    @Test
    public void test() {
        List<DevConfig> list = service.list();
    }
}
