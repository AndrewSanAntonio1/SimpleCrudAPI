package com.project.crudapp.Repository;

import com.project.crudapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
