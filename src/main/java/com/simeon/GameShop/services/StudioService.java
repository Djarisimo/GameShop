package com.simeon.GameShop.services;

import com.simeon.GameShop.models.Studio;
import com.simeon.GameShop.repositories.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

	@Autowired
	private StudioRepository studioRepository;

	public List<Studio> getAllStudios() {
		return studioRepository.findAll();
	}

	public void addEditStudio(Studio studio) {
		studioRepository.save(studio);
	}

//	public void updateStudio(int id, Studio studio) {
//		Optional<Studio> optionalStudio = studioRepository.findById(id);
//		if (optionalStudio.isPresent() && studio.getName() != null) {
//			Studio foundStudio = optionalStudio.get();
//			foundStudio.setName(studio.getName());
//			studioRepository.save(foundStudio);
//		}
//	}

	public void deleteStudio(int id) {
		studioRepository.deleteById(id);
	}

}
