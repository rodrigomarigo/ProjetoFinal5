package com.example.projetofinal5.Controller;

import com.example.projetofinal5.Entity.Funcionario;
import com.example.projetofinal5.Service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios(){
        ModelAndView mv = new ModelAndView("templateFuncionarios");

        mv.addObject("funcionario", new Funcionario());
        mv.addObject("funcionarios", funcionarioService.getFuncionarios());

        return mv;
    }

    @PostMapping("/salvarFuncionario")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.salvar(funcionario);

        return "redirect:/funcionarios";
    }

    @GetMapping("detalhesFuncionario/{id}")
    public ModelAndView getFuncionarioById(@PathVariable(name = "id") Integer id) {

        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        ModelAndView mv = new ModelAndView("detalhesFuncionario");
        mv.addObject("funcionario", funcionario);


        // List<Autor> autoresNaoAssociados = autorService.getAutores();
        // autoresNaoAssociados.removeAll(livro.getAutor());
        // mv.addObject("autores", autoresNaoAssociados);
        // List<Editora> editorasNaoAssociadas = editoraService.getEditoras();
        // editorasNaoAssociadas.remove(livro.getEditora());
        // mv.addObject("editoras", editorasNaoAssociadas);

        return mv;
    }
    
}