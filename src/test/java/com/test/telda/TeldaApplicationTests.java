package com.test.telda;

import com.test.telda.generator.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TeldaApplicationTests {
    private final Generator generator = new Generator(new Random(System.currentTimeMillis()));

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/region/id/77")).andExpect(status().isOk()).andExpect(content().string("Region(id=77, name=moscow, abbreviatedName=MSK)"));
    }

    @Test
    void findByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/region/name/moscow")).andExpect(status().isOk()).andExpect(content().string("Region(id=77, name=moscow, abbreviatedName=MSK)"));
    }

    @Test
    void findByAbbreviatedName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/region/abbreviatedName/MSK")).andExpect(status().isOk()).andExpect(content().string("Region(id=77, name=moscow, abbreviatedName=MSK)"));
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/region/all"));
    }

    @Test
    void add() throws Exception {
        short id = generator.generateId();
        String name = generator.generateName();
        String abbreviatedName = generator.generateAbbreviatedName();
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/region/add?id=" + id + "&name=" + name + "&abbreviatedName=" + abbreviatedName));
    }

    @Test
    void deleteById() throws Exception {
        short id = generator.generateId();
        String name = generator.generateName();
        String abbreviatedName = generator.generateAbbreviatedName();
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/region/add?id=" + id + "&name=" + name + "&abbreviatedName=" + abbreviatedName));
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/region/delete?id=" + id));
    }
}
