package io.bootify.spring_major_project_1.rest;


import io.bootify.spring_major_project_1.model.VisitDTO;
import io.bootify.spring_major_project_1.model.VisitStatus;
import io.bootify.spring_major_project_1.service.ResidentService;
import io.bootify.spring_major_project_1.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/resident", produces = MediaType.APPLICATION_JSON_VALUE)
public class ResidentController {


    @Autowired
    private VisitService visitService;

    @Autowired
    private ResidentService residentService;

    @PutMapping("/visit/{id}/{status}")
    public ResponseEntity<Void> updateVisit(@PathVariable final Long id,
                                            @PathVariable VisitStatus status) {
        visitService.updateStatus(id, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/visits/{status}")
    public ResponseEntity<List<VisitDTO>> getVisit(@PathVariable VisitStatus status, @RequestHeader Long userId){

        return ResponseEntity.ok(residentService.findAllVisitsWithStatus(userId, status));
    }
}
