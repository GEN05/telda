package com.test.telda.repository;

import com.test.telda.domain.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionRepository {
    @Select("Select * FROM region WHERE (id = #{id}, name = #{name}, abbreviatedName = #{abbreviatedName})")
    Region find(Region region);

    @Select("SELECT * FROM region WHERE id = #{id}")
    Region findById(long id);

    @Select("SELECT * FROM region WHERE name = #{name}")
    Region findByName(String name);

    @Select("Select * FROM region WHERE abbreviatedName = #{abbreviatedName}")
    Region findByAbbreviatedName(String abbreviatedName);

    @Select("Select * FROM region")
    List<Region> findAll();

    @Insert("INSERT INTO region(id,name,abbreviatedName) values(#{id},#{name},#{abbreviatedName})")
    boolean add(Region region);

    @Delete("DELETE FROM region WHERE id = #{id}")
    boolean deleteById(long id);

    @Delete("DELETE FROM region WHERE TRUE")
    boolean deleteAll();

    @Update("update region set region.id = #{reg.id}, region.name = #{reg.name}, region.abbreviatedName = #{reg.abbreviatedName} where region.id = #{regId}")
    boolean update(Region reg, long regId);
}
