package net.ws.dev.core.config.service.impl;

import net.ws.dev.core.config.entity.DevConfig;
import net.ws.dev.core.config.mapper.DevConfigMapper;
import net.ws.dev.core.config.service.DevConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 配置 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2023-06-02
 */
@Service
public class DevConfigServiceImpl extends ServiceImpl<DevConfigMapper, DevConfig> implements DevConfigService {

}
