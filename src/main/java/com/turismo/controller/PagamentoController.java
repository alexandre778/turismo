package com.turismo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagamentoController {

    @GetMapping("/pagamento/sucesso")
    public String pagamentoSucesso() {
        return "pagamento-sucesso"; // nome do template HTML
    }
}
