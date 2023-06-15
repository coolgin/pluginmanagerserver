package com.travelsky.aoc.pluginmanagerserver.service;

import com.travelsky.aoc.pluginmanagerserver.dao.entity.PluginEntity;
import com.travelsky.aoc.pluginmanagerserver.dao.repository.PluginRepository;
import com.travelsky.aoc.pluginmanagerserver.data.PluginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PluginService {

    @Autowired
    private PluginRepository pluginRepository;

    public List<PluginDto> findAll() {
        List<PluginEntity> entities = pluginRepository.findAll();
        return entities.stream().map(PluginEntity::toData).collect(Collectors.toList());
    }
}
