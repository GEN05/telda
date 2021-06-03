package com.test.telda.service;

import com.test.telda.domain.Region;
import com.test.telda.exception.RegionException;
import com.test.telda.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository repository;

    @SneakyThrows
    public Region find(Region region) {
        Region answer = repository.find(region);
        if (answer == null) {
            throw new RegionException("No such region");
        }
        return answer;
    }

    @SneakyThrows(RegionException.class)
    public Region findById(long id) {
        Region region = repository.findById(id);
        if (region == null) {
            throw new RegionException("No regions with this id");
        }
        return region;
    }

    @SneakyThrows(RegionException.class)
    public Region findByName(String name) {
        Region region = repository.findByName(name);
        if (region == null) {
            throw new RegionException("No regions with this name");
        }
        return region;
    }

    @SneakyThrows(RegionException.class)
    public Region findByAbbreviatedName(String abbreviatedName) {
        Region region = repository.findByAbbreviatedName(abbreviatedName);
        if (region == null) {
            throw new RegionException("No regions with this abbreviated name");
        }
        return region;
    }

    @SneakyThrows(RegionException.class)
    public List<Region> findAll() {
        List<Region> region = repository.findAll();
        if (region == null) {
            throw new RegionException("No regions");
        }
        return region;
    }

    @SneakyThrows(RegionException.class)
    public void add(Region newRegion) {
        var region = Region.builder()
                .id(newRegion.id)
                .name(newRegion.getName())
                .abbreviatedName(newRegion.getAbbreviatedName())
                .build();
        if (!repository.add(region)) {
            throw new RegionException("Failed to add region");
        }
    }

    @SneakyThrows(RegionException.class)
    public void deleteById(long id) {
        if (repository.findById(id) == null) {
            throw new RegionException("There is no such region");
        }
        if (repository.deleteById(id)) {
            throw new RegionException("Failed to delete region");
        }
    }

    @SneakyThrows(RegionException.class)
    public void deleteAll() {
        if (repository.deleteAll() == 0) {
            throw new RegionException("Failed to delete all region");
        }
    }

    @SneakyThrows(RegionException.class)
    public void update(Region region) {
        if (repository.find(region) == null) {
            throw new RegionException("There is no such region");
        }
        if (repository.update(region)) {
            throw new RegionException("Failed to update data");
        }
    }
}
