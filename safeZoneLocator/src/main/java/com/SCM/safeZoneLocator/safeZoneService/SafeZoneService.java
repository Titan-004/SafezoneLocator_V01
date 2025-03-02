package com.SCM.safeZoneLocator.safeZoneService;

import com.SCM.safeZoneLocator.Entitiy.SafeZone;
import com.SCM.safeZoneLocator.SafeZoneRepo.SafeZoneRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafeZoneService {
    private final SafeZoneRepo sfzRepo;

    public SafeZoneService(SafeZoneRepo sfzRepo) {
        this.sfzRepo = sfzRepo;
    }

    public List<SafeZone> getAllSafeZones() {
        return sfzRepo.findAll();
    }

    public List<SafeZone> getSafeZonesByType(String type) {
        return sfzRepo.findByType(type);
    }

    public SafeZone addSafeZone(SafeZone safeZone) {
        return sfzRepo.save(safeZone);
    }
}

