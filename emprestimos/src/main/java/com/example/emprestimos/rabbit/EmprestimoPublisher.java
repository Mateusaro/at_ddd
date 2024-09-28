package com.example.emprestimos.rabbit;

import com.example.emprestimos.model.Emprestimo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    private static final String QUEUE_NAME = "emprestimosQueue";

    public void enviarEmprestimo(Emprestimo emprestimo) {
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.convertAndSend(QUEUE_NAME, emprestimo);
        System.out.println("Emprestimo enviado para a fila: " + emprestimo);
    }
}
