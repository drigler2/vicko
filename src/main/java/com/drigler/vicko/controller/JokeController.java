package com.drigler.vicko.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showJokeOrderedList(Model model, @RequestParam("page") Optional<Integer> page,
        @RequestParam("size") Optional<Integer> size) {

        Integer currPage = page.orElse(0);
        Integer pageSize = size.orElse(10);

        Page<Joke> jokes =
            jService.getAllOrderByLikesMinusDislikes(PageRequest.of(currPage, pageSize));
        model.addAttribute("jokes", jokes);

        Integer totalPages = jokes.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers =
                IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());

            model.addAttribute("pageNumbers", pageNumbers);
            model.addAttribute("currPage", currPage);

        }

        return "joke_list";
    }

    @PostMapping("like")
    public String like(@RequestParam("idJoke") String idJokeInput,
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("size") Optional<Integer> size) {

        Integer currPage = page.orElse(0);
        Integer pageSize = size.orElse(10);

        Integer idJoke = null;
        try {
            idJoke = Integer.parseInt(idJokeInput);
        }
        catch (NumberFormatException e) {
            return "redirect:/";
        }

        jService.like(idJoke);

        return "redirect:/" + "?page=" + currPage + "&size=" + pageSize;
    }

    @PostMapping("dislike")
    public String dislike(@RequestParam("idJoke") String idJokeInput,
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("size") Optional<Integer> size) {

        Integer currPage = page.orElse(0);
        Integer pageSize = size.orElse(10);

        Integer idJoke = null;
        try {
            idJoke = Integer.parseInt(idJokeInput);
        }
        catch (NumberFormatException e) {
            return "redirect:/";
        }

        jService.dislike(idJoke);

        return "redirect:/" + "?page=" + currPage + "&size=" + pageSize;
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
