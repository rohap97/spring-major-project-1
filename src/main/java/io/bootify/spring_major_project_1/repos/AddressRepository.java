package io.bootify.spring_major_project_1.repos;

import io.bootify.spring_major_project_1.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
