package com.SCM.safeZoneLocator.SafeZoneController;

import com.SCM.safeZoneLocator.Entitiy.SafeZone;
import com.SCM.safeZoneLocator.safeZoneService.SafeZoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SafeZoneThymeleafController {
    private final SafeZoneService sfzService;

    public SafeZoneThymeleafController(SafeZoneService sfzService) {
        this.sfzService = sfzService;
    }

    @GetMapping("/")
    public String viewSafeZones(Model model) {
        model.addAttribute("safeZones", sfzService.getAllSafeZones());
        return "safezone";
    }

    @GetMapping("/add-safezone")
    public String addSafeZoneForm() {
        return "add-safezone";
    }

    @PostMapping("/save-safezone")
    public String saveSafeZone(@ModelAttribute SafeZone safeZone) {
        sfzService.addSafeZone(safeZone);
        return "redirect:/";
    }
}
