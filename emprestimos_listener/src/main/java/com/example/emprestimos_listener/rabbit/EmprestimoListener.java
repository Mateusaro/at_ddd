package com.example.emprestimos_listener.rabbit;

import com.example.emprestimos_listener.model.Emprestimo;
import com.example.emprestimos_listener.service.EmprestimoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoListener {

    @Autowired
    private EmprestimoService emprestimoService;

    @RabbitListener(queues = "emprestimosQueue")
    public void receberEmprestimo(Emprestimo emprestimo) {
        System.out.println("Emprestimo recebido da fila: " + emprestimo);
        emprestimoService.salvarEmprestimo(emprestimo);
    }
}
