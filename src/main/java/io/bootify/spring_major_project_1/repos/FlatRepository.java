package io.bootify.spring_major_project_1.repos;

import io.bootify.spring_major_project_1.domain.Flat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlatRepository extends JpaRepository<Flat, Long> {
}
