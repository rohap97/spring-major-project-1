package io.bootify.spring_major_project_1.service;

import io.bootify.spring_major_project_1.domain.Flat;
import io.bootify.spring_major_project_1.model.FlatDTO;
import io.bootify.spring_major_project_1.repos.FlatRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class FlatService {

    private final FlatRepository flatRepository;

    public FlatService(final FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public List<FlatDTO> findAll() {
        return flatRepository.findAll(Sort.by("id"))
                .stream()
                .map(flat -> mapToDTO(flat, new FlatDTO()))
                .collect(Collectors.toList());
    }

    public FlatDTO get(final Long id) {
        return flatRepository.findById(id)
                .map(flat -> mapToDTO(flat, new FlatDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final FlatDTO flatDTO) {
        final Flat flat = new Flat();
        mapToEntity(flatDTO, flat);
        return flatRepository.save(flat).getId();
    }

    public void update(final Long id, final FlatDTO flatDTO) {
        final Flat flat = flatRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(flatDTO, flat);
        flatRepository.save(flat);
    }

    public void delete(final Long id) {
        flatRepository.deleteById(id);
    }

    private FlatDTO mapToDTO(final Flat flat, final FlatDTO flatDTO) {
        flatDTO.setId(flat.getId());
        flatDTO.setNumber(flat.getNumber());
        return flatDTO;
    }

    private Flat mapToEntity(final FlatDTO flatDTO, final Flat flat) {
        flat.setNumber(flatDTO.getNumber());
        return flat;
    }

}
