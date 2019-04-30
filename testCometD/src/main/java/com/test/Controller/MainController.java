package com.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/29
 */
@Controller
@RequestMapping("/data")
public class MainController {

    @RequestMapping("/publish")
    public Model publish() {

        return null;
    }
}
