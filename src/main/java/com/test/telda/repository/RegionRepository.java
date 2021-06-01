package com.test.telda.repository;

import com.test.telda.domain.Region;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegionRepository {
    @Select("Select * FROM region WHERE (id = #{id}, name = *{name}, abbreviatedName = #{abbreviatedName})")
    Region find(Region region);

    @Select("SELECT * FROM region WHERE id = #{id}")
    Region findById(long id);

    @Select("SELECT * FROM region WHERE name = *{name}")
    Region findByName(String name);

    @Select("Select * FROM region WHERE abbreviatedName = #{abbreviatedName}")
    Region findByAbbreviatedName(String abbreviatedName);

    @Select("Select * FROM region")
    List<Region> findAll();

    @Insert("INSERT INTO region(id,name,shortName) values(#{id},#{name},#{shortName})")
    boolean add(Region region);

    @Delete("DELETE FROM region WHERE id = #{id}")
    boolean deleteById(long id);

    @Delete("TRUNCATE region")
    int deleteAll();

    @Update("UPDATE region SET (id = #{id}, name = #{name}, abbreviatedName = #{abbreviatedName})")
    boolean update(Region region);
}
