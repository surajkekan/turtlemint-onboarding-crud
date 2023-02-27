package com.example.demo.service;

import com.example.demo.model.ProfileDTO;
import com.example.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    public ProfileRepository profileRepository;
    @Autowired
    public HelperService helperService;
    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll();
    }
    public Optional<ProfileDTO> getProfileByRequestId(String requestId){
        return profileRepository.findById(requestId);
    }
    public ProfileDTO addProfile(ProfileDTO profile){
        profile.setRequestId(helperService.getnewId());
        profileRepository.save(profile);
        return profile;
    }
    public Optional<ProfileDTO> updateProfile(String requestId,ProfileDTO profile){
        Optional<ProfileDTO> checkProfile = profileRepository.findById(requestId);
        if(checkProfile.isPresent()){
            ProfileDTO existingProfile=checkProfile.get();
            if(!(profile.getVertical().isEmpty())){
                existingProfile.setVertical(profile.getVertical());
            }
            if(!(profile.getMake().isEmpty())){
                existingProfile.setMake(profile.getMake());
            }
            if(!(profile.getModel().isEmpty())){
                existingProfile.setModel(profile.getModel());
            }
            profileRepository.save(existingProfile);
            return Optional.of(existingProfile);
        }
        return checkProfile;
    }
    public void deleteProfile(String requestId){
        profileRepository.deleteById(requestId);
    }

}
