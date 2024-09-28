package com.example.livros.rabbit;

import com.example.livros.dto.LivroUsuarioDTO;
import com.example.livros.model.Livro;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    public void enviarLivroParaFila(Livro livro) {
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.convertAndSend("livroQueue", livro);
    }
}
