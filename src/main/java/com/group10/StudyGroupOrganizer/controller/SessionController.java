package com.group10.StudyGroupOrganizer.controller;

import com.group10.StudyGroupOrganizer.model.Session;
import com.group10.StudyGroupOrganizer.service.GroupService;
import com.group10.StudyGroupOrganizer.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;
    private final GroupService groupService;

    @Autowired
    public SessionController(SessionService sessionService, GroupService groupService) {
        this.sessionService = sessionService;
        this.groupService = groupService;
    }

    @GetMapping
    public String getAllSessions(Model model) {
        List<Session> sessions = sessionService.getAllSessions();
        model.addAttribute("sessions", sessions);
        return "session-list";  // Thymeleaf template for listing sessions
    }

    @GetMapping("/new")
    public String showSessionForm(Model model) {
        model.addAttribute("studySession", new Session());
        model.addAttribute("groups", groupService.getAllgroups());
        return "session-form";  // Thymeleaf template for creating a new session
    }

    @PostMapping("/new")
    public String saveSession(@ModelAttribute("studySession") Session session) {
        sessionService.saveSession(session);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        sessionService.getSessionById(id).ifPresent(session -> model.addAttribute("studySession", session));
        model.addAttribute("groups", groupService.getAllgroups());
        return "session-form";  // Thymeleaf template for editing a session
    }

    @PostMapping("/{id}/edit")
    public String updateSession(@PathVariable Long id, @ModelAttribute("studySession") Session session) {
        session.setId(id);
        sessionService.saveSession(session);
        return "redirect:/sessions";
    }

    @GetMapping("/{id}/delete")
    public String deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return "redirect:/sessions";
    }
}
