package org.walavo.consumer.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProductChannel {

    String PRODUCT = "product";

    @Input(PRODUCT)
    SubscribableChannel productChannel();
}
