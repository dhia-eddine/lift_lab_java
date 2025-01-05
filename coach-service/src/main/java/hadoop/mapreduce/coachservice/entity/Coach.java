package hadoop.mapreduce.coachservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String specialty;

    private String picture;

    @Column(nullable = false)
    private boolean active;
}
