package com.example.trello.controllers;

import com.example.trello.dto.comment.CommentCreateDto;
import com.example.trello.dto.comment.CommentUpdateDto;
import com.example.trello.services.comment.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/comment/*")
public class CommentController extends AbstractController<CommentService> {
    public CommentController(CommentService service) {
        super(service);
    }


    @GetMapping(value = "/create")
    public String createPage() {
        return "comment/create";
    }

    @PostMapping("create/")
    public String create(@ModelAttribute CommentCreateDto commentCreateDto) {
        service.create(commentCreateDto);
        return "/comment/list";
    }

    @GetMapping("delete/{id}/")
    public String deletePage(Model model,@PathVariable(name = "id") Long id) {
        model.addAttribute("comment",service.get(id));
        return "/comment/delete";
    }

    @PostMapping("delete/{id}/")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect: comment/list";
    }

    @GetMapping("update/{id}/")
    public String updatePage(Model model,@PathVariable(name = "id") Long id) {
        model.addAttribute("comment",service.get(id));
        return "/comment/update";
    }

    @PostMapping("update/{id}/")
    public String update(@ModelAttribute CommentUpdateDto commentUpdateDto) {
        service.update(commentUpdateDto);
        return "redirect: comment/list/";
    }

    @GetMapping("get/{id}/")
    public String list(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("comments",service.getAllById(id));
        return "/comment/list";
    }

}
