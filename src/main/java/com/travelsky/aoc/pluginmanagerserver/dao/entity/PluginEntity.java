package com.travelsky.aoc.pluginmanagerserver.dao.entity;

import com.travelsky.aoc.pluginmanagerserver.data.PluginDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "plugin", schema = "plugin_manage", catalog = "")
public class PluginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "plugin_version")
    private Integer pluginVersion;
    @Basic
    @Column(name = "path")
    private String path;
    @Basic
    @Column(name = "airport")
    private String airport;
    @Basic
    @Column(name = "data_source")
    private String dataSource;
    @Basic
    @Column(name = "max_consumer")
    private Byte maxConsumer;
    @Basic
    @Column(name = "create_at")
    private Long createAt;

    public PluginDto toData(){
        PluginDto pluginDto = new PluginDto();
        pluginDto.setName(name);
        pluginDto.setPluginVersion(pluginVersion);
        pluginDto.setPath(path);
        pluginDto.setAirport(airport);
        pluginDto.setMaxConsumer(maxConsumer);
        pluginDto.setCreateAt(createAt);
        pluginDto.setDataSource(dataSource);
        pluginDto.setId(id);
        return pluginDto;
    }
}
