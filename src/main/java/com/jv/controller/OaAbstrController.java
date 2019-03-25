package com.jv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OaAbstrController implements OaController {

    @Override
    @RequestMapping("/*")
    public String unHandlerUrl(Model model) {
        return "common/unknowUrl";
    }
}
