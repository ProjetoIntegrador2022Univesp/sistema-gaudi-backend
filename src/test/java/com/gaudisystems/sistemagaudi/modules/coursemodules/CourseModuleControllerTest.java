package com.gaudisystems.sistemagaudi.modules.coursemodules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gaudisystems.sistemagaudi.modules.coursemodules.services.CourseModuleServiceImpl;

@WebMvcTest
public class CourseModuleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CourseModuleServiceImpl courseModuleService;

    /* @Test
    void getAllCourseModules() throws Exception {

        List<CourseModule> courseModules = new ArrayList<>();
        courseModules.add(new CourseModule());

        when(courseModuleService.findAll());

        mockMvc.perform(MockMvcRequestBuilders.get("/course-modules").contentType(MediaType.APPLICATION_JSON));

    } */
    
}
