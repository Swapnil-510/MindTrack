package com.MindTrack.controller;

import com.MindTrack.model.Mood;
import com.MindTrack.repository.MoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @PostMapping("/mood/save")
    public String saveMood(Mood mood, HttpSession session){

        String email = (String) session.getAttribute("userEmail");

        if(email == null){
            return "redirect:/login";
        }

        mood.setUserEmail(email);

        mood.setDate(LocalDate.now().toString());

        if(mood.getMood().equals("Happy"))
            mood.setMoodScore(5);

        else if(mood.getMood().equals("Calm"))
            mood.setMoodScore(4);

        else if(mood.getMood().equals("Neutral"))
            mood.setMoodScore(3);

        else if(mood.getMood().equals("Sad"))
            mood.setMoodScore(2);

        else if(mood.getMood().equals("Stressed"))
            mood.setMoodScore(1);

        moodRepository.save(mood);

        return "redirect:/dashboard";
    }

    @PostMapping("/mood/delete")
    public String deleteMood(String id){

        moodRepository.deleteById(id);

        return "redirect:/dashboard";
    }
}