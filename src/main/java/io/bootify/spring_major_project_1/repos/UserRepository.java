package io.bootify.spring_major_project_1.repos;

import io.bootify.spring_major_project_1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
