package com.travelsky.aoc.pluginmanagerserver.data;

import lombok.Data;

@Data
public class PluginDto {
    private int id;
    private String name;
    private Integer pluginVersion;
    private String path;
    private String airport;
    private String dataSource;
    private Byte maxConsumer;
    private Long createAt;
}
