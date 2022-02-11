package com.courseworkload.controller;

import com.courseworkload.model.dto.CourseDto;
import com.courseworkload.model.entity.Course;
import com.courseworkload.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public List<CourseDto> getCourses() {
        return courseService.getCourses();
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public CourseDto getCourseById(@PathVariable long id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public CourseDto createCourse(@RequestBody CourseDto course) {
        return courseService.createCourse(course);
    }

    @RequestMapping(value = "/course", method = RequestMethod.PUT)
    public CourseDto updateProduct( @RequestBody CourseDto course) {
        return courseService.updateCourse(course);
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public CourseDto deleteProduct(@PathVariable long id) {
        return courseService.deleteCourse(id);
    }
}
