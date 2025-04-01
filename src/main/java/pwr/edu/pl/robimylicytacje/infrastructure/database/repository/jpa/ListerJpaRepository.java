package pwr.edu.pl.robimylicytacje.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.pl.robimylicytacje.infrastructure.database.entity.ListerEntity;

public interface ListerJpaRepository extends JpaRepository<Long, ListerEntity> {
}
