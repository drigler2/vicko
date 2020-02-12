package com.drigler.vicko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drigler.vicko.services.ICategoryService;
import com.drigler.vicko.services.IJokeService;

@Controller
@RequestMapping("/")
//@Slf4j
public class JokeController {

    private final IJokeService jService;
    private final ICategoryService catService;

    @Autowired
    public JokeController(IJokeService jService, ICategoryService catServiec) {

        this.jService = jService;
        this.catService = catServiec;
    }

    public String showJokeOrderedList(Model model) {

        model.addAttribute("jokes", jService.getAllOrderByLikesMinusDislikes());
        return "/";
    }
}
