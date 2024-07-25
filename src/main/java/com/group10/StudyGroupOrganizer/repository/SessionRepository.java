package com.group10.StudyGroupOrganizer.repository;

import com.group10.StudyGroupOrganizer.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
}
