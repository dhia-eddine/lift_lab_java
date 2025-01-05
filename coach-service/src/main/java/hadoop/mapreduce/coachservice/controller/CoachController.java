package hadoop.mapreduce.coachservice.controller;


import hadoop.mapreduce.coachservice.dto.CreateCoachDto;
import hadoop.mapreduce.coachservice.dto.UpdateCoachDto;
import hadoop.mapreduce.coachservice.entity.Coach;
import hadoop.mapreduce.coachservice.service.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping
    public ResponseEntity<Coach> addCoach(@Valid @RequestBody CreateCoachDto createCoachDto) {
        Coach coach = coachService.addCoach(createCoachDto);
        return ResponseEntity.ok(coach);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> displayOneCoach(@PathVariable Long id) {
        Coach coach = coachService.displayOneCoach(id);
        return ResponseEntity.ok(coach);
    }

    @GetMapping
    public ResponseEntity<List<Coach>> displayAllCoaches() {
        List<Coach> coaches = coachService.displayAllCoaches();
        return ResponseEntity.ok(coaches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @Valid @RequestBody UpdateCoachDto updateCoachDto) {
        Coach coach = coachService.updateCoach(id, updateCoachDto);
        return ResponseEntity.ok(coach);
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Coach> activateCoach(@PathVariable Long id) {
        Coach coach = coachService.toggleCoachStatus(id);
        return ResponseEntity.ok(coach);
    }

    @GetMapping("/active/count")
    public ResponseEntity<Long> countActiveCoaches() {
        Long count = coachService.countActiveCoaches();
        return ResponseEntity.ok(count);
    }
}