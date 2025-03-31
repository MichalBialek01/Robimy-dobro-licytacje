package pwr.edu.pl.robimylicytacje.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PARTICIPANT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "city")
    private String city;


}
