package com.group10.StudyGroupOrganizer.repository;


import com.group10.StudyGroupOrganizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
