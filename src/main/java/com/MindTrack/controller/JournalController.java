package com.MindTrack.controller;

import com.MindTrack.model.Journal;
import com.MindTrack.repository.JournalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JournalController {

    @Autowired
    private JournalRepository journalRepository;

    @GetMapping("/journal")
    public String viewJournal(Model model){

        List<Journal> journals = journalRepository.findAll();

        model.addAttribute("journals", journals);

        return "journal";
    }

    @PostMapping("/journal/save")
    public String saveJournal(Journal journal){

        journalRepository.save(journal);

        return "redirect:/journal";
    }

    @PostMapping("/journal/update")
    public String updateJournal(Journal journal){

        journalRepository.save(journal);

        return "redirect:/journal";
    }

    @GetMapping("/journal/delete/{id}")
    public String deleteJournal(@PathVariable String id){

        journalRepository.deleteById(id);

        return "redirect:/journal";
    }
}