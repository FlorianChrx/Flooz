package fr.da2i.flooz.controllers;

import fr.da2i.flooz.model.Group;
import fr.da2i.flooz.model.User;
import fr.da2i.flooz.repositories.GroupRepository;
import fr.da2i.flooz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@CrossOrigin
@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/user/groups")
    public Iterable<Group> getGroups(HttpServletRequest request) {
        return userRepository.findById(request.getUserPrincipal().getName()).get().getGroups();
    }

    @GetMapping(path = "/user/Dgroups")
    public Iterable<Group> getDGroups() {
        return groupRepository.findAll();
    }

    @GetMapping(path = "/user/groups/{id}")
    public Group getGroup(@PathVariable int id) {
        return groupRepository.findById(id).get();
    }

    @PutMapping(path = "/user/groups/add")
    public Map<String, Boolean> addGroup(HttpServletRequest request, @RequestBody Group group) {
        group.setUsers(new ArrayList<>());
        group.getUsers().add(userRepository.findById(request.getUserPrincipal().getName()).get());
        groupRepository.save(group);
        return Collections.singletonMap("success", true);
    }

    @PutMapping(path = "/user/groups/addUser/{group}/{username}")
    public Map<String, Boolean> addUser(HttpServletRequest request, @PathVariable int group, @PathVariable String username) {
        Map bad = Collections.singletonMap("success", false);
        if (!userRepository.existsById(username)) return bad;
        Group modifiedGroup = groupRepository.findById(group).get();
        User user = userRepository.findById(username).get();
        if (modifiedGroup.getUsers().contains(user)) return bad;
        modifiedGroup.getUsers().add(user);
        groupRepository.save(modifiedGroup);
        return Collections.singletonMap("success", true);
    }
}
