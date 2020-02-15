package com.drigler.vicko.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drigler.vicko.services.IJokeService;

@Controller
@RequestMapping("/")
//@Slf4j
public class JokeController {

    private final IJokeService jService;

    @Autowired
    public JokeController(IJokeService jService) {

        this.jService = jService;
    }

    @GetMapping
    public String showJokeOrderedList(Model model) {

        model.addAttribute("jokes", jService.getAllOrderByLikesMinusDislikes());

        return "joke_list";
    }

    @PostMapping("like")
    public String like(HttpServletRequest request) {

        try {
            Integer idJoke = Integer.parseInt(request.getParameter("idJoke"));
            jService.like(idJoke);
        }
        catch (NumberFormatException e) {
            return "redirect:/";
        }

        return "redirect:/";
    }

    @PostMapping("dislike")
    public String dislike(HttpServletRequest request) {

        try {
            Integer idJoke = Integer.parseInt(request.getParameter("idJoke"));
            jService.dislike(idJoke);
        }
        catch (NumberFormatException e) {
            return "redirect:/";
        }

        return "redirect:/";
    }
}
