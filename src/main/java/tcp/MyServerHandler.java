package tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-15 17:25
 */
public class MyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
private int count;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);
        String message=new String(buffer, Charset.forName("utf-8"));
        System.out.println("服务器接收到数据："+message);
        System.out.println("服务器端第几次接受消息："+(++ count));
        //服务器会送数据到客户端
        ByteBuf response = Unpooled.copiedBuffer(UUID.randomUUID().toString(), Charset.forName("utf-8"));
        ctx.writeAndFlush(response);
    }
}
