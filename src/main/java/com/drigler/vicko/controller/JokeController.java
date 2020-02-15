package com.drigler.vicko.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drigler.vicko.factory.JokeFactory;
import com.drigler.vicko.models.forms.JokeForm;
import com.drigler.vicko.models.jokes.Category;
import com.drigler.vicko.models.jokes.Joke;
import com.drigler.vicko.services.ICategoryService;
import com.drigler.vicko.services.IJokeService;

@Controller
@RequestMapping("/")
//@Slf4j
public class JokeController {

    private final IJokeService jService;
    private final ICategoryService catService;

    @Autowired
    public JokeController(IJokeService jService, ICategoryService catService) {

        this.jService = jService;
        this.catService = catService;
    }

    @GetMapping
    public String showJokeOrderedList(Model model) {

        model.addAttribute("jokes", jService.getAllOrderByLikesMinusDislikes());

        return "joke_list";
    }

    @PostMapping("like")
    public String like(HttpServletRequest request) {

        Integer idJoke = null;
        try {
            idJoke = Integer.parseInt(request.getParameter("idJoke"));
        }
        catch (NumberFormatException e) {
            return "redirect:/";
        }

        jService.like(idJoke);
        return "redirect:/";
    }

    @PostMapping("dislike")
    public String dislike(HttpServletRequest request) {

        Integer idJoke = null;
        try {
            idJoke = Integer.parseInt(request.getParameter("idJoke"));
        }
        catch (NumberFormatException e) {
            return "redirect:/";
        }

        jService.dislike(idJoke);
        return "redirect:/";
    }

    @GetMapping("new")
    public String newJokeEdit(JokeForm jokeForm) {

        return "new_joke";
    }

    @PostMapping("new")
    public String newJokeSave(@Valid JokeForm jokeForm, BindingResult result) {

        if (result.hasErrors()) {
            return "new_joke";
        }

        Joke joke = JokeFactory.newJokeFromForm(jokeForm);
        jService.saveJoke(joke);

        return "redirect:/new";
    }

    @ModelAttribute("categoryList")
    public List<Category> populateCategories() {

        return catService.getAll();
    }

}
