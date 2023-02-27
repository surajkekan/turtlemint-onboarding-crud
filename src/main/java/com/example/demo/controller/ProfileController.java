package com.example.demo.controller;

import com.example.demo.model.ProfileDTO;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/turtle")
public class ProfileController {
    @Autowired
    public ProfileService profileService;

    @GetMapping("/profiles")
    public ResponseEntity<?> getAllProfiles()  {
        try{
            List<ProfileDTO> profiles =profileService.getAllProfiles();
            return new ResponseEntity<>(profiles, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @RequestMapping(value = "/profile", params = "requestId")
    public ResponseEntity<?> getProfile( @RequestParam String requestId) {
        try{
            Optional<ProfileDTO> profile = profileService.getProfileByRequestId(requestId);
            if(!profile.isPresent()) {
                Map<String, String> response = new HashMap<String, String>() {{
                    put("Data", "Profile not found");
                }};
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @PostMapping("/profile")
    public ResponseEntity<?> addProfile(@RequestBody ProfileDTO profile) {
        try{
            ProfileDTO response = profileService.addProfile(profile);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PutMapping(value = "/profile", params = "requestId")
    public ResponseEntity<?> updateProfile(@RequestBody ProfileDTO profile, @RequestParam String requestId){
        try{
            Optional<ProfileDTO> response = profileService.updateProfile(requestId,profile);
            if(response.isPresent()){
                return new ResponseEntity<>(response.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>("requestId not found", HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @DeleteMapping(value = "/profile", params = "requestId")
    public ResponseEntity<?> deleteProfile(@RequestParam String requestId) {
        try{
            profileService.deleteProfile(requestId);
            return new ResponseEntity<>("Profile Deleted Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
