package protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-15 17:13
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocal> {
    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //使用客户端发送10条数据
        String msg = "今天天气冷，吃火锅";

        for (int i = 0; i < 5; i++) {

            byte[] content = msg.getBytes(StandardCharsets.UTF_8);
            int length = content.length;
            MessageProtocal messageProtocal = new MessageProtocal();
            messageProtocal.setContent(content);
            messageProtocal.setLen(length);

            ctx.writeAndFlush(messageProtocal);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocal msg) throws Exception {

        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("客户端接受消息：" + new String(content, StandardCharsets.UTF_8));
        System.out.println("长度:" + len);
        System.out.println("客户端接受消息数量：" + (++count));


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
