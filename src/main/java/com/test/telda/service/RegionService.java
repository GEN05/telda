package com.test.telda.service;

import com.test.telda.domain.Region;
import com.test.telda.exception.RegionException;
import com.test.telda.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository repository;

    @Cacheable(value = "region")
    public Region findById(long id) throws RegionException {
        Region region = repository.findById(id);
        if (region == null) {
            throw new RegionException("No regions with this id");
        }
        return region;
    }

    @Cacheable(value = "region")
    public Region findByName(String name) throws RegionException {
        Region region = repository.findByName(name);
        if (region == null) {
            throw new RegionException("No regions with this name");
        }
        return region;
    }

    @Cacheable(value = "region")
    public Region findByAbbreviatedName(String abbreviatedName) throws RegionException {
        Region region = repository.findByAbbreviatedName(abbreviatedName);
        if (region == null) {
            throw new RegionException("No regions with this abbreviated name");
        }
        return region;
    }

    @Cacheable(value = "region")
    public List<Region> findAll() throws RegionException {
        List<Region> region = repository.findAll();
        if (region == null || region.isEmpty()) {
            throw new RegionException("No regions");
        }
        return region;
    }

    @CacheEvict(value = "region")
    public void add(Region newRegion) throws RegionException {
        var region = Region.builder()
                .id(newRegion.id)
                .name(newRegion.getName())
                .abbreviatedName(newRegion.getAbbreviatedName())
                .build();
        if (!repository.add(region)) {
            throw new RegionException("Failed to add region");
        }
    }

    @CacheEvict(value = "region")
    public void deleteById(long id) throws RegionException {
        if (repository.findById(id) == null) {
            throw new RegionException("There is no such region");
        }
        if (!repository.deleteById(id)) {
            throw new RegionException("Failed to delete region");
        }
    }

    @CacheEvict(value = "region", allEntries = true)
    public void deleteAll() throws RegionException {
        if (!repository.deleteAll()) {
            throw new RegionException("Failed to delete all region");
        }
    }

    @CacheEvict(value = "region")
    public void update(Region region, long regId) throws RegionException {
        if (repository.findById(regId) == null) {
            throw new RegionException("There is no such region");
        }
        if (!repository.update(region, regId)) {
            throw new RegionException("Failed to update data");
        }
    }
}
