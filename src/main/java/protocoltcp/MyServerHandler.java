package protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-15 17:25
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocal> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocal msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("服务器接收到数据：" + new String(content, StandardCharsets.UTF_8));
        System.out.println("长度:" + len);
        System.out.println("服务器端第几次接受消息：" + (++count));
        //服务器会送数据到客户端
        String response =UUID.randomUUID().toString();
        int responselen = response.getBytes("utf-8").length;
        MessageProtocal protocal = new MessageProtocal();
        protocal.setContent(response.getBytes());
        protocal.setLen(responselen);

        ctx.writeAndFlush(protocal);
    }
}
