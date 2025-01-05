package hadoop.mapreduce.coachservice.repository;


import hadoop.mapreduce.coachservice.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}