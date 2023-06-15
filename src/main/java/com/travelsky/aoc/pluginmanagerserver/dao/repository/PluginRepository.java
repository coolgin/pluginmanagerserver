package com.travelsky.aoc.pluginmanagerserver.dao.repository;

import com.travelsky.aoc.pluginmanagerserver.dao.entity.PluginEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PluginRepository extends PagingAndSortingRepository<PluginEntity, Long> {

    List<PluginEntity> findAll();
}