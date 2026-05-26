package csd230.s26.lab1.repositories;

import csd230.s26.lab1.entities.ClutchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClutchRepository extends JpaRepository<ClutchEntity, Long> {
}
