package io.bootify.spring_major_project_1.repos;

import io.bootify.spring_major_project_1.domain.Flat;
import io.bootify.spring_major_project_1.domain.Visit;
import io.bootify.spring_major_project_1.model.VisitStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findAllByFlatAndStatus(Flat flat, VisitStatus status);
}
