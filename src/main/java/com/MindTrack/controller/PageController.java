package com.MindTrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.MindTrack.repository.MoodRepository;
import com.MindTrack.model.Mood;

import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private MoodRepository moodRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session){

        String email = (String) session.getAttribute("userEmail");

        if(email == null){
            return "redirect:/login";
        }

        List<Mood> moods = moodRepository.findByUserEmail(email);

        String suggestion = "";

        if(!moods.isEmpty()){

            Mood latestMood = moods.get(moods.size() - 1);
            String mood = latestMood.getMood();

            if(mood.equals("Happy"))
                suggestion = "Great! Keep doing things that make you happy.";

            else if(mood.equals("Calm"))
                suggestion = "You seem calm. Consider journaling to maintain clarity.";

            else if(mood.equals("Neutral"))
                suggestion = "Try a small activity like walking or listening to music.";

            else if(mood.equals("Sad"))
                suggestion = "Writing in your journal or talking to a friend may help.";

            else if(mood.equals("Stressed"))
                suggestion = "Try a short breathing exercise or take a break.";
        }

        /* -------- Weekly Mood Insight -------- */

        double averageMood = 0;

        if(moods.size() > 0){

            int total = 0;
            int count = 0;

            for(int i = moods.size() - 1; i >= 0 && count < 7; i--){

                total += moods.get(i).getMoodScore();
                count++;
            }

            averageMood = (double) total / count;
        }

        model.addAttribute("averageMood", averageMood);

        /* -------- Habit Suggestion Based on Average Mood -------- */

        String habitSuggestion = "";

        if(averageMood <= 2)
            habitSuggestion = "Try a short breathing exercise or talk to someone you trust.";

        else if(averageMood <= 3)
            habitSuggestion = "Consider journaling or taking a short walk.";

        else
            habitSuggestion = "Keep maintaining healthy habits like exercise and good sleep.";

        model.addAttribute("habitSuggestion", habitSuggestion);

        /* -------- Chart Data -------- */

        List<String> dates = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();

        int count = 0;

        for(int i = moods.size() - 1; i >= 0 && count < 7; i--){

            Mood m = moods.get(i);

            dates.add(0, m.getDate());
            scores.add(0, m.getMoodScore());

            count++;
        }

        model.addAttribute("dates", dates);
        model.addAttribute("scores", scores);

        /* ---------------------------- */

        model.addAttribute("moods", moods);
        model.addAttribute("suggestion", suggestion);

        return "dashboard";
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/breathing")
    public String breathingPage(){
        return "breathing";
    }
}
