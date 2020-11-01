package com.embracelabs.adm.controller;

import com.embracelabs.adm.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/port")
@RestController
public class AdmController {
    @Autowired
    AdmService admService;

    @GetMapping("")
    public Map<String,Object> select(Map<String,Object> param) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map = admService.findPortList(param);
        return map;
    }
}
