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
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {

    @Autowired
    private WebBoardRepository repo;

    @GetMapping("/list")
    public void list(PageVO vo, Model model){
        Pageable page = vo.makePageable(0, "bno");
        Page<WebBoard> result = repo.findAll(repo.makePredicate(null, null), page);

        log.info("" + page);
        log.info("" + result);

        log.info("Total Page Number: " + result.getTotalPages());

        model.addAttribute("result", new PageMaker(result));
    }
}