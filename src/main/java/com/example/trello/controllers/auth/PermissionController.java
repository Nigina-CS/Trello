package com.example.trello.controllers.auth;

import com.example.trello.controllers.AbstractController;
import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.permission.PermissionCreateDto;
import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.services.permission.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("permission/*")
public class PermissionController extends AbstractController<PermissionService> {

    public PermissionController(PermissionService service) {
        super(service);
    }

    @GetMapping("create/")
    public String createPage() {
        return "auth/permission/create";
    }

    @PostMapping("create/")
    public String create(@ModelAttribute PermissionCreateDto permissionCreateDto) {
        service.create(permissionCreateDto);
        return "redirect:/auth/permission";
    }

    @GetMapping("all/")
    public String all(Model model) {
        List<PermissionDto> all = service.getAll(new GenericCriteria());
        model.addAttribute("permissions", all);
        return "auth/permission/all";
    }

    @GetMapping("user_permission/{id}/")
    public String userPermission(@PathVariable Long id, Model model) {
        List<PermissionDto> permissions = service.getAllByUserId(id);
        model.addAttribute("permissions", permissions);
        return "auth/permission/user_permission";
    }

}
