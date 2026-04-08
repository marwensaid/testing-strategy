package com.orange.testingservicemockito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Repository standard, pas besoin de méthodes supplémentaires pour ce TD
}