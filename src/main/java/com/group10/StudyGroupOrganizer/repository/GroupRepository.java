package com.group10.StudyGroupOrganizer.repository;

import com.group10.StudyGroupOrganizer.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
