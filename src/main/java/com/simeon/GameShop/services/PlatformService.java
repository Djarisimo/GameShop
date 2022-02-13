package com.simeon.GameShop.services;

import com.simeon.GameShop.models.Platform;
import com.simeon.GameShop.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PlatformService {

    @Autowired
    private PlatformRepository platformRepository;

    public List<Platform> getAllPlatforms() {
        return platformRepository.findAll();
    }

    public void addEditPlatform(Platform platform) {
        platformRepository.save(platform);
    }

    public void deletePlatform(int id) {
        platformRepository.deleteById(id);
    }

//	public void updatePlatform(int id, Platform platform) {
//		Optional<Platform> optionalPlatform = platformRepository.findById(id);
//		if (optionalPlatform.isPresent() && platform.getName() != null) {
//			Platform foundPlatform = optionalPlatform.get();
//			foundPlatform.setName(platform.getName());
//			platformRepository.save(foundPlatform);
//		}
//	}
}
