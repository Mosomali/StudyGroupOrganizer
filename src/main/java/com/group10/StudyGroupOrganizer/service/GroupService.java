package com.group10.StudyGroupOrganizer.service;

import com.group10.StudyGroupOrganizer.model.Group;
import com.group10.StudyGroupOrganizer.model.User;
import com.group10.StudyGroupOrganizer.repository.GroupRepository;
import com.group10.StudyGroupOrganizer.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public List<Group> getAllgroups(){
        return groupRepository.findAll();
    }
    public Group getGroupsById(Long id){
        return groupRepository.findById(id).orElse(null);
    }
    public Group saveGroup(Group group){
        groupRepository.save(group);
        return group;
    }
    public void deleteGroup(Long id){
        groupRepository.deleteById(id);
    }
}
