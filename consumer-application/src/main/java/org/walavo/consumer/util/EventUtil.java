package org.walavo.consumer.util;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.ImmediateAcknowledgeAmqpException;

import java.util.Map;
import java.util.Objects;

public class EventUtil {

    public static Long getCountAttempt(Map<?, ?> death) {
        return (Long) death.get("count");
    }

    public static void validateAttempt(Long death) {
        if (isMaxAttempt(death)) {
            throw new ImmediateAcknowledgeAmqpException("Failed after 4 attempts");
        }
        throw new AmqpRejectAndDontRequeueException("failed");
    }

    private static boolean isMaxAttempt(Long death) {
        return Objects.nonNull(death) && death.equals(3L);
    }
}
