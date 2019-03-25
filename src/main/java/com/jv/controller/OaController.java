package com.jv.controller;

import org.springframework.ui.Model;

public interface OaController {

    /**
     * 没有对应处理的请求URL.如果需要重写。
     * 如果子controller需要定制自己的页面，重写该方法。
     * @param model
     * @return
     */
    public String unHandlerUrl(Model model);
}
