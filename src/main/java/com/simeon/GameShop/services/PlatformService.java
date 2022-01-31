package com.simeon.GameShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simeon.GameShop.models.Platform;
import com.simeon.GameShop.repositories.PlatformRepository;

@Service
public class PlatformService {

	@Autowired
	private PlatformRepository platformRepository;
	
	// Return all platforms
	public List<Platform> getPlatform(){
		return platformRepository.findAll();
	}
	
	// Save platforms
	public void save(Platform platform) {
		platformRepository.save(platform);
	}
		
	// Delete platforms
	public void deletePlatform(int id) {
		platformRepository.deleteById(id);
	}
}
