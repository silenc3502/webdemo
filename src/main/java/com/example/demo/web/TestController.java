package com.example.demo.web;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private BoardServiceImpl service;

    @GetMapping("/boardRegister")
    public void boardRegisterForm(Board board, Model model) throws Exception {
        logger.info("boardRegister");
    }

    @PostMapping("/boardRegister")
    public String boardRegister(Board board, Model model) throws Exception {
        logger.info("register");

        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "success";
    }

    @GetMapping("/list")
    public void boardList(Model model) throws Exception {
        logger.info("list");

        model.addAttribute("list", service.list());
    }

    @GetMapping("/read")
    public void read(int boardNo, Model model) throws Exception {
        logger.info("read");

        model.addAttribute(service.read(boardNo));
    }

    @PostMapping("/remove")
    public String remove(int boardNo, Model model) throws Exception {
        logger.info("remove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "success";
    }

    @GetMapping("/modify")
    public void modifyForm(int boardNo, Model model) throws Exception {
        logger.info("modifyForm");

        model.addAttribute(service.read(boardNo));
    }

    @PostMapping("/modify")
    public String modify(Board board, Model model) throws Exception {
        logger.info("modify");

        service.modify(board);

        model.addAttribute("msg", "수정이 완료되었습니다.");

        return "success";
    }
}
