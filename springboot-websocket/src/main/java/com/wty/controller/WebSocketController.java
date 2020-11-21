package com.wty.controller;

import com.wty.model.ApiReturnObject;
import com.wty.server.WebSocketServer;
import com.wty.utils.ApiReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * websocket测试接口
 *
 * @author wty
 * @date 2020/8/24 23:09
 */
@Controller
public class WebSocketController {
    /**
     * 页面请求
     *
     * @param cid
     * @return
     */
    @RequestMapping(value = "/socket/{cid}", method = RequestMethod.GET)
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     *
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/socket/push/{cid}", method = RequestMethod.GET)
    public ApiReturnObject pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiReturnUtil.error(cid + "#" + e.getMessage());
        }
        return ApiReturnUtil.success(message);
    }

    @RequestMapping(value = "/websocket", method = RequestMethod.GET)
    public String websocket() {
        return "websocket";
    }
}
