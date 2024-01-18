package com.tomjr.crud.controller;

import com.tomjr.crud.enums.RiscoEnum;
import com.tomjr.crud.enums.StatusEnum;
import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.model.Projeto;
import com.tomjr.crud.service.PessoaService;
import com.tomjr.crud.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/projeto")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @Autowired
    PessoaService pessoaService;


    @GetMapping({"/list"})
    public String listProjeto(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("projetoList", projetoService.getAllProjeto());
        model.addAttribute("message", message);
        return "ListProjeto";
    }

    @GetMapping("/add")
    public String addProjeto(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("message", message);
        List<Pessoa> listGerentes = pessoaService.getAllGerentes();
        model.addAttribute("gerentes", listGerentes);
        model.addAttribute("riscoList", RiscoEnum.getListName());
        model.addAttribute("statusList", StatusEnum.getListName());
        return "AddProjeto";
    }

    @PostMapping("/save")
    public String saveProjeto(Projeto projeto, RedirectAttributes redirectAttributes) {
        try {
            if (projetoService.saveOrUpdateProjeto(projeto)) {
                redirectAttributes.addFlashAttribute("message", "Save Success");
                return "redirect:/projeto/list";
            } else {

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/projeto/add";
    }

    @GetMapping("/edit/{id}")
    public String editProjeto(@PathVariable Long id, Model model) {
        Optional<Projeto> projeto = projetoService.getProjetoById(id);
        List<Pessoa> listGerentes = pessoaService.getAllGerentes();
        model.addAttribute("gerentes", listGerentes);
        model.addAttribute("riscoList", RiscoEnum.getListName());
        model.addAttribute("statusList", StatusEnum.getListName());
        if (projeto.isPresent()) {
            model.addAttribute("projeto", projeto.get());
        } else {
            model.addAttribute("projeto", new Projeto());
        }
        return "EditProjeto";
    }

    @PostMapping("/editSave")
    public String editSaveProjeto(Projeto projeto, RedirectAttributes redirectAttributes) {
        if (projetoService.saveOrUpdateProjeto(projeto)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/projeto/list";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/projeto/edit/" + projeto.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteProjeto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Projeto> projeto = projetoService.getProjetoById(id);
        if (projeto.isPresent()) {
            if (projeto.get().getStatus().equals(StatusEnum.INICIADO.getName()) || projeto.get().getStatus().equals(StatusEnum.EM_ANDAMENTO.getName()) || projeto.get().getStatus().equals(StatusEnum.ENCERRADO.getName())) {
                redirectAttributes.addFlashAttribute("message", "Delete Failure Status");
            } else {
                if (projetoService.deleteProjeto(id)) {
                    redirectAttributes.addFlashAttribute("message", "Delete Success");
                } else {
                    redirectAttributes.addFlashAttribute("message", "Delete Failure");
                }
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/projeto/list";
    }

}
