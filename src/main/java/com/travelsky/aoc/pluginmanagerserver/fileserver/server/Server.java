package com.travelsky.aoc.pluginmanagerserver.fileserver.server;



import com.travelsky.aoc.pluginmanagerserver.fileserver.common.MarshallingCodeCFactory;
import com.travelsky.aoc.pluginmanagerserver.fileserver.core.FileScan;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Server {

	public static ChannelHandler marshallingEncoderCache;

	@PostConstruct
	public void main() throws Exception {
		int port = 9999;
		/*if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}*/
		FileScan.getDefault().scanningAndWrite("md5.record");
		bind(port);
	}

	private Channel serverChannel;

	private EventLoopGroup bossGroup;

	private EventLoopGroup workerGroup;

    public void bind(int port) throws InterruptedException {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();

		marshallingEncoderCache = MarshallingCodeCFactory.buildMarshallingEncoder();
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
				.option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new LoggingHandler(LogLevel.ERROR))
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
					protected void initChannel(SocketChannel ch) {
						ch.pipeline().addLast("marencoder", marshallingEncoderCache);
						ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
						ch.pipeline().addLast("chunkedWriteHandler", new ChunkedWriteHandler());
						ch.pipeline().addLast("ServerHandler", new ServerHandler());
					}
                });

        serverChannel = b.bind(port).sync().channel();
    }

	/*public void shutdown() throws InterruptedException {
		try {
			serverChannel.close().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}*/
}
