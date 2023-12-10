package com.TimeSeries.api.repository;

import com.TimeSeries.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String username);


    Iterable<User> findAllByIdIn(List<String> userSet);
}
