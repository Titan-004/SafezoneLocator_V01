package com.SCM.safeZoneLocator.SafeZoneController;

import com.SCM.safeZoneLocator.Entitiy.SafeZone;
import com.SCM.safeZoneLocator.safeZoneService.SafeZoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safe-zones")
public class SFZController {

    private final SafeZoneService sfzService;

    public SFZController(SafeZoneService sfzService) {
        this.sfzService = sfzService;
    }

    @GetMapping
    public List<SafeZone> getAllSafeZones() {
        return sfzService.getAllSafeZones();
    }

    @GetMapping("/type/{type}")
    public List<SafeZone> getSafeZonesByType(@PathVariable String type) {
        return sfzService.getSafeZonesByType(type);
    }

    @PostMapping
    public ResponseEntity<SafeZone> addSafeZone(@RequestBody SafeZone safeZone) {
        System.err.println("Received Safe Zone: " + safeZone.toString());
        SafeZone savedZone = sfzService.addSafeZone(safeZone);
        return ResponseEntity.ok(savedZone);
    }
}

