package protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-15 18:00
 */
public class MyMessgaeEncoder extends MessageToByteEncoder<MessageProtocal> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocal msg, ByteBuf out) throws Exception {
        System.out.println("MyMessgaeEncoder encode被调用");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());

    }
}
