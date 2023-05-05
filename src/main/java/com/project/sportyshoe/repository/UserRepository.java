package com.project.sportyshoe.repository;

import com.project.sportyshoe.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

}
