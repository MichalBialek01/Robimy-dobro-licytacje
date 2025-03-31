package pwr.edu.pl.robimylicytacje.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LISTER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "city")
    private String city;

}
