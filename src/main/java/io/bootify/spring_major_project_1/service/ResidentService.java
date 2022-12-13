package io.bootify.spring_major_project_1.service;

import io.bootify.spring_major_project_1.domain.Flat;
import io.bootify.spring_major_project_1.domain.User;
import io.bootify.spring_major_project_1.domain.Visit;
import io.bootify.spring_major_project_1.model.VisitDTO;
import io.bootify.spring_major_project_1.model.VisitStatus;
import io.bootify.spring_major_project_1.repos.FlatRepository;
import io.bootify.spring_major_project_1.repos.UserRepository;
import io.bootify.spring_major_project_1.repos.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitRepository visitRepository;


    @Autowired
    private VisitService visitService;

    public List<VisitDTO> findAllVisitsWithStatus(Long userId, VisitStatus visitStatus) {

        User user = userRepository.findById(userId).get();
        Flat flat = user.getFlat();

        List<Visit> visitList = visitRepository.findAllByFlatAndStatus(flat, visitStatus);

        return visitList
                .stream()
                .map(visit -> visitService.mapToDTO(visit, new VisitDTO()))
                .collect(Collectors.toList());
    }

}
