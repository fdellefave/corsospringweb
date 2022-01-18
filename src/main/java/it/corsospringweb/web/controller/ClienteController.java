package it.corsospringweb.web.controller;

import it.corsospringweb.web.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/nuovo")
    public ModelAndView nuovoCliente() {
        return new ModelAndView("nuovoCliente","datiCliente",new Cliente());
    }

    @PostMapping("/aggiungi")
    public ModelAndView aggiungiCliente(@ModelAttribute("datiCliente") Cliente cliente) {
        return new ModelAndView("nuovoCliente","datiCliente", cliente);
    }

}
