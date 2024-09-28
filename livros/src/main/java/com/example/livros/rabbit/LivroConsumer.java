package com.example.livros.rabbit;

import com.example.livros.model.Livro;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LivroConsumer {

    @RabbitListener(queues = "livroQueue")
    public void receberLivroDaFila(Livro livro) {
        System.out.println("Livro recebido: " + livro.getTitulo());
    }
}
