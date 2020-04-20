package com.example.demo.controller;

import com.example.demo.persistence.WebBoardRepository;
import com.example.demo.vo.PageMaker;
import com.example.demo.vo.PageVO;
import com.example.demo.domain.WebBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {

    @Autowired
    private WebBoardRepository repo;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageVO") PageVO vo, Model model){
        Pageable page = vo.makePageable(0, "bno");
        Page<WebBoard> result = repo.findAll(repo.makePredicate(vo.getType(), vo.getKeyword()), page);

        log.info("" + page);
        log.info("" + result);

        log.info("Total Page Number: " + result.getTotalPages());

        model.addAttribute("result", new PageMaker(result));
    }

    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") WebBoard vo){
        log.info("register get");
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") WebBoard vo, RedirectAttributes rttr){

        log.info("register post");
        log.info("" + vo);

        repo.save(vo);
        rttr.addFlashAttribute("msg", "success");

        return "redirect:/boards/list";
    }

    @GetMapping("/view")
    public void view(Long bno, @ModelAttribute("pageVO") PageVO vo, Model model){

        log.info("BNO: " + bno);

        repo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
    }
    
    
}