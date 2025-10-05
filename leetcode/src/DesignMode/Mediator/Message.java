package DesignMode.Mediator;

import lombok.Data;

/**
 * @author Administrator
 * @date 2025/9/15 19:47
 * @see
 * @since JDK 17
 */
@Data
public class Message {
    private String message;
    private int targetId;

    public Message(String message, int targetId) {
        this.message = message;
        this.targetId = targetId;
    }

    public String getMessage() {
        return message;
    }

    public int getTargetId() {
        return targetId;
    }
}
