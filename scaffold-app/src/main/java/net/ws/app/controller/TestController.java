package net.ws.app.controller;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ws
 * @date 2023年05月30日 17:30
 */
@Slf4j
@RestController
public class TestController {

    @RequestMapping("/log/test")
    public String log() {
        log.info("ad");
        log.debug("ad");
        log.error("ad");
        log.warn("ad");
        return "success";
    }
}
