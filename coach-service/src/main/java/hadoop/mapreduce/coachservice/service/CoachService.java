package hadoop.mapreduce.coachservice.service;


import hadoop.mapreduce.coachservice.dto.CreateCoachDto;
import hadoop.mapreduce.coachservice.dto.UpdateCoachDto;
import hadoop.mapreduce.coachservice.entity.Coach;
import hadoop.mapreduce.coachservice.repository.CoachRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CoachService {
    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Transactional
    public Coach addCoach(CreateCoachDto createCoachDto) {
        Coach coach = new Coach();
        coach.setName(createCoachDto.getName());
        coach.setEmail(createCoachDto.getEmail());
        coach.setMobile(createCoachDto.getMobile());
        coach.setSpecialty(createCoachDto.getSpecialty());
        coach.setActive(createCoachDto.isActive());
        return coachRepository.save(coach);
    }

    public Coach displayOneCoach(Long id) {
        return coachRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Coach not found with id: " + id));
    }

    public List<Coach> displayAllCoaches() {
        return coachRepository.findAll();
    }

    @Transactional
    public Coach updateCoach(Long id, UpdateCoachDto updateCoachDto) {
        Coach coach = displayOneCoach(id);
        coach.setName(updateCoachDto.getName());
        coach.setEmail(updateCoachDto.getEmail());
        coach.setMobile(updateCoachDto.getMobile());
        coach.setSpecialty(updateCoachDto.getSpecialty());
        coach.setActive(updateCoachDto.isActive());
        return coachRepository.save(coach);
    }

    @Transactional
    public Coach toggleCoachStatus(Long id) {
        Coach coach = displayOneCoach(id);
        coach.setActive(!coach.isActive());
        return coachRepository.save(coach);
    }

    public Long countActiveCoaches() {
        return coachRepository.count();
    }
}