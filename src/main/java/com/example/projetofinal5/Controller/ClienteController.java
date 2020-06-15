package com.example.projetofinal5.Controller;

import com.example.projetofinal5.Entity.Cliente;
import com.example.projetofinal5.Service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("templateClientes");

        mv.addObject("cliente", new Cliente());
        mv.addObject("clientes", clienteService.getClientes());

        return mv;
    }

    @PostMapping("/salvarCliente")
    public String salvar(@ModelAttribute Cliente cliente){
        clienteService.salvar(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/detalhesCliente/{id}")
    public ModelAndView getClienteDetalhes(@PathVariable(name = "id") Integer id) {

        Cliente cliente = clienteService.getClienteById(id);
        ModelAndView mv = new ModelAndView("detalhesCliente");
        mv.addObject("cliente", cliente);


        // List<Autor> autoresNaoAssociados = autorService.getAutores();
        // autoresNaoAssociados.removeAll(livro.getAutor());
        // mv.addObject("autores", autoresNaoAssociados);
        // List<Editora> editorasNaoAssociadas = editoraService.getEditoras();
        // editorasNaoAssociadas.remove(livro.getEditora());
        // mv.addObject("editoras", editorasNaoAssociadas);

        return mv;
    }
}