package com.wty.controller;

import com.wty.controller.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/8/27 15:47
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/queryAll")
    public String queryAll() {
        return cacheService.queryAll();
    }

    @GetMapping("/save")
    public String save(String newStr) {
        return cacheService.save(newStr);
    }

    @GetMapping("/update")
    public String update() {
        return cacheService.update();
    }

    @GetMapping("deleteOne")
    public void deleteOne(String str) {
        cacheService.deleteOne(str);
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        cacheService.deleteAll();
    }

    @GetMapping("/deleteAllBefore")
    public void deleteAllBefore() {
        cacheService.deleteAllBefore();
    }

    @GetMapping("/allOperation")
    public void allOperation() {
        cacheService.allOperation();
    }
}
