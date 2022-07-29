package com.ake.netty.action.ch1;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {

    public static void main(String[] args) {
        start();
    }

    private static void start(){

        Bootstrap bootstrap = new Bootstrap();

        EventLoopGroup group = new NioEventLoopGroup();
        bootstrap.channel(NioSocketChannel.class)
                .group(group)
                .remoteAddress(new InetSocketAddress("localhost", 9000))
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) {
                        channel.pipeline().addLast(new EchoClientHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.connect().sync();
            // 等待同步关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}
