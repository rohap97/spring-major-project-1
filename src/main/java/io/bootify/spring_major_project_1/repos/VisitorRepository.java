package io.bootify.spring_major_project_1.repos;

import io.bootify.spring_major_project_1.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
