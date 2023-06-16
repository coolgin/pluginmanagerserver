package com.travelsky.aoc.pluginmanagerserver.fileserver.server;

import com.travelsky.aoc.data.Request;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ClientSession {

    private Request request;

    private ChannelHandlerContext channel;

}
