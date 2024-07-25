package com.group10.StudyGroupOrganizer.controller;

import com.group10.StudyGroupOrganizer.model.Group;
import com.group10.StudyGroupOrganizer.model.User;
import com.group10.StudyGroupOrganizer.repository.GroupRepository;
import com.group10.StudyGroupOrganizer.repository.UserRepository;
import com.group10.StudyGroupOrganizer.service.GroupService;
import com.group10.StudyGroupOrganizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final UserService userService;

    @Autowired
    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllGroups(Model model){
        List<Group> groups = groupService.getAllgroups();
        model.addAttribute("groups", groups);
        return "groups";
    }

    @GetMapping("/{id}")
    public String getGroupById(@PathVariable Long id, Model model){
        Group group = groupService.getGroupsById(id);
        model.addAttribute("group", group);
        return "group-detail";
    }


    @GetMapping("/new")
    public String showGroupForm(Model model){
        model.addAttribute("group", new Group());
        model.addAttribute("users", userService.getAllUser()); // To populate admin dropdown
        return "group-form";
    }

    @PostMapping("/new")
    public String saveGroup(@ModelAttribute("group") Group group, @RequestParam("adminId") Long adminId, Model model){
        User admin = userService.getUserById(adminId);
        if (admin == null) {
            return "redirect:/error"; // Handle this appropriately
        }
        group.setAdmin(admin);
        group.setDateCreated(LocalDateTime.now());
        groupService.saveGroup(group);
        return "redirect:/groups";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model){
        Group group = groupService.getGroupsById(id);
        model.addAttribute("group", group);
        model.addAttribute("users", userService.getAllUser()); // To populate admin dropdown
        return "group-form";
    }

    @PostMapping("/{id}/edit")
    public String updateGroup(@ModelAttribute("group") Group group, @RequestParam("adminId") Long adminId){
        User admin = userService.getUserById(adminId);
        if (admin == null) {
            return "redirect:/error"; // Handle this appropriately
        }
        group.setAdmin(admin);
        groupService.saveGroup(group);
        return "redirect:/group-detail";
    }

    @GetMapping("/{id}/delete")
    public String deleteGroup(@PathVariable Long id){
        groupService.deleteGroup(id);
        return "redirect:/groups";
    }
}
