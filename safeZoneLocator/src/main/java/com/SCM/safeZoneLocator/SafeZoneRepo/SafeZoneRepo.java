package com.SCM.safeZoneLocator.SafeZoneRepo;

import com.SCM.safeZoneLocator.Entitiy.SafeZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SafeZoneRepo extends JpaRepository<SafeZone, Long> {
    List<SafeZone> findByType(String type);
}
