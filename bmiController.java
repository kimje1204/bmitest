package com.example.bmi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class bmiController {
    @GetMapping("/")
    public  String bmi() {
        return "index" ;
    }

    @GetMapping("/bmi_calc")
    public String bmi_calc(
            @RequestParam("height") int height,
            @RequestParam ("weight") int weight,
            Model model
    ) {
        double bmi = weight / Math.pow((double)height/100.0,2) ;
        String bmiR=String.format("%.1f",bmi);

        if(bmi<20.0) {
            bmiR = "멸치";
        } else if (bmi<=24) {
            bmiR ="정상";
        } else if (bmi<=29) {
            bmiR ="과체중";
        } else if ( bmi>=30) {
            bmiR = "돼지";
        }


        model.addAttribute("height" ,height);
        model.addAttribute("weight" ,weight);
        model.addAttribute("bmiR" ,bmiR);
        return "index";
    }







}
