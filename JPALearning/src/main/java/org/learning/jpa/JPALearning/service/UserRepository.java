package org.learning.jpa.JPALearning.service;

import org.learning.jpa.JPALearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
