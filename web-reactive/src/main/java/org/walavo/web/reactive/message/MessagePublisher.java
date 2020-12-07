package org.walavo.web.reactive.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.walavo.web.reactive.controller.dto.ProductDto;

@Component
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Binding binding;

    public ProductDto sendMessage(ProductDto productDto) {
        rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), productDto);
        return productDto;
    }
}
