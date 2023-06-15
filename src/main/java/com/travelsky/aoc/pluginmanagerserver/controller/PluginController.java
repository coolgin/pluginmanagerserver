package com.travelsky.aoc.pluginmanagerserver.controller;

import com.travelsky.aoc.pluginmanagerserver.data.PluginDto;
import com.travelsky.aoc.pluginmanagerserver.service.PluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class PluginController {

    @Autowired
    private PluginService pluginService;

    @RequestMapping(value = "plugins", method = RequestMethod.GET)
    @ResponseBody
    public List<PluginDto> findAll(){
        return pluginService.findAll();
    }

}
