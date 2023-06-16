package com.travelsky.aoc.pluginmanagerserver.controller;

import com.travelsky.aoc.data.PluginUpdate;
import com.travelsky.aoc.pluginmanagerserver.data.PluginDto;
import com.travelsky.aoc.pluginmanagerserver.fileserver.ClientManager;
import com.travelsky.aoc.pluginmanagerserver.fileserver.server.ClientSession;
import com.travelsky.aoc.pluginmanagerserver.service.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class AdminController {


    @RequestMapping(value = "send", method = RequestMethod.GET)
    @ResponseBody
    public String send(@RequestParam String ip,
                       @RequestParam String service) {
        ClientSession clientSession = ClientManager.get(ip, service);
        if (clientSession != null) {
            System.err.println(clientSession);
            PluginUpdate pluginUpdate = new PluginUpdate();
            pluginUpdate.setName("my-plugin-1.0.0.jar");
            pluginUpdate.setVersion(2);
            clientSession.getChannel().writeAndFlush(pluginUpdate);
        }
        return "";
    }

}
