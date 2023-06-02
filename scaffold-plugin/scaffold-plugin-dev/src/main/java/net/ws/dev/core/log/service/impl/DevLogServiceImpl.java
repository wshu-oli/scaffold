package net.ws.dev.core.log.service.impl;

import net.ws.dev.core.log.entity.DevLog;
import net.ws.dev.core.log.mapper.DevLogMapper;
import net.ws.dev.core.log.service.DevLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author Oliver
 * @since 2023-06-02
 */
@Service
public class DevLogServiceImpl extends ServiceImpl<DevLogMapper, DevLog> implements DevLogService {

}
