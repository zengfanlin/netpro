package protocoltcp;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-15 17:50
 */
public class MessageProtocal {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
