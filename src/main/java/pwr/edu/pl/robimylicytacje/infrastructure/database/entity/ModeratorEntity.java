package pwr.edu.pl.robimylicytacje.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MODERATOR")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeratorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

}
