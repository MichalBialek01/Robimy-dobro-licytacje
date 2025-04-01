package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.pl.robimylicytacje.infrastructure.database.entity.ModeratorEntity;

public interface ModeratorJpaRepository extends JpaRepository<Long, ModeratorEntity> {
}
