package com.example.trello.controllers;

import com.example.trello.dto.task.TaskCreateDto;
import com.example.trello.dto.task.TaskUpdateDto;
import com.example.trello.services.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService>  {

    @Autowired
    public TaskController(TaskService service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "task/create";
    }

    @RequestMapping(value = "create/",method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCreateDto dto) {
        service.create(dto);
        return "redirect:/task/list";
    }

    @RequestMapping(value = "update/{id}/",method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project",service.get(id));
        return "task/update";
    }

    @RequestMapping(value = "update/{id}/",method = RequestMethod.POST)
    public String update(TaskUpdateDto dto) {
        service.update(dto);
        return "redirect:/task/list";
    }

    @RequestMapping(value = "delete/{id}/",method = RequestMethod.GET)
    public String deletePage(Model model,@PathVariable(name ="id") Long id) {
        model.addAttribute("project",service.get(id));
        return "task/delete";
    }

    @RequestMapping(value = "delete/{id}/",method = RequestMethod.POST)
    public String delete(@PathVariable(name ="id") Long id) {
        service.delete(id);
        return "redirect:/task/list";
    }

    @RequestMapping(value = "list/{id}/",method = RequestMethod.POST)
    public String list(@PathVariable(name ="id") Long id) {
        service.getAllByTaskId(id);
        return "redirect:/task/list";
    }

    public String getByColumnId(@PathVariable(name = "id") Long id) {
        return "";
    }

}
