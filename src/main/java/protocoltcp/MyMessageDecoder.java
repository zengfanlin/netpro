package protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-15 18:12
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("解码器被调用");
        int length=in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);
        MessageProtocal messageProtocal = new MessageProtocal();
        messageProtocal.setLen(length);
        messageProtocal.setContent(content);
        out.add(messageProtocal);
    }
}
