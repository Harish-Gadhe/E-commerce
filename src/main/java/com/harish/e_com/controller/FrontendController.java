package com.harish.e_com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping(value = {
            "/", 
            "/add_product",
            "/product",
            "/product/**",
            "/cart"
    })
    public String forwardReactRoutes() {
        return "forward:/index.html";
    }
}
