package com.tomjr.crud.controller;

import com.tomjr.crud.dto.PessoaDTO;
import com.tomjr.crud.mapper.PessoaMapper;
import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.service.impl.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@Controller
@RequestMapping(value = "/pessoa")
@ApiIgnore
public class PessoaController {

    PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping({"/list"})
    public String listPessoa(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("pessoaList", PessoaMapper.convertEntityListToDtoList(pessoaService.getAllPessoa()));
        model.addAttribute("message", message);
        return "ListPessoa";
    }

    @GetMapping("/add")
    public String addPessoa(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("pessoa", new PessoaDTO());
        model.addAttribute("message", message);
        return "AddPessoa";
    }

    @PostMapping("/save")
    public String savePessoa(PessoaDTO pessoa, RedirectAttributes redirectAttributes) {

        try {
            Optional<Pessoa> pessoaCpf = pessoaService.getPessoaByCpf(pessoa.getCpf());
            if (pessoaCpf.isPresent()) {
                redirectAttributes.addFlashAttribute("message", "Exists Cpf");
                return "redirect:/pessoa/add";
            }
            if (pessoaService.saveOrUpdatePessoa(PessoaMapper.convertDtoToEntity(pessoa))) {
                redirectAttributes.addFlashAttribute("message", "Save Success");
                return "redirect:/pessoa/list";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/pessoa/add";
    }

    @GetMapping("/edit/{id}")
    public String editPessoa(@PathVariable Long id, Model model) {
        Optional<Pessoa> pessoa = pessoaService.getPessoaById(id);
        if (pessoa.isPresent()) {
            model.addAttribute("pessoa", pessoa.get());
        } else {
            model.addAttribute("pessoa", new Pessoa());
        }
        return "EditPessoa";
    }

    @PostMapping("/editSave")
    public String editSavePessoa(PessoaDTO pessoa, RedirectAttributes redirectAttributes) {
        if (pessoaService.saveOrUpdatePessoa(PessoaMapper.convertDtoToEntity(pessoa))) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/pessoa/list";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/pessoa/edit/" + pessoa.getId();
    }

    @GetMapping("/delete/{id}")
    public String deletePessoa(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (pessoaService.deletePessoa(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/pessoa/list";
    }

}
