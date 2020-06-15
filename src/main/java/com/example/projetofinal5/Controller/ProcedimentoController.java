package com.example.projetofinal5.Controller;

import com.example.projetofinal5.Entity.Procedimento;
import com.example.projetofinal5.Service.ProcedimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcedimentoController {
    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping("/procedimentos")
    public ModelAndView getProcedimentos(){
        ModelAndView mv = new ModelAndView("templateProcedimentos");

        mv.addObject("procedimento", new Procedimento());
        mv.addObject("procedimentos", procedimentoService.getProcedimentos());

        return mv;

    }

    @PostMapping("/salvarProcedimento")
    public String salvar(@ModelAttribute Procedimento procedimento){
        procedimentoService.salvar(procedimento);

        return "redirect:/procedimentos";
    }

    @GetMapping("/detalhesProcedimento/{id}")
    public ModelAndView getProcedimentoDetalhes(@PathVariable(name = "id") Integer id){
        Procedimento procedimento = procedimentoService.getProcedimentoById(id);
        ModelAndView mv = new ModelAndView("detalhesProcedimento");
        mv.addObject("procedimento", procedimento);
        
        return mv;
    }
}