package com.courseworkload.service;

import com.courseworkload.model.dto.CourseDto;
import com.courseworkload.model.entity.Course;

import java.util.List;

public interface CourseServiceInterface {

    List<CourseDto> getCourses();

    CourseDto getCourse(long id);

    CourseDto createCourse(CourseDto course);

    CourseDto updateCourse(CourseDto course);

    CourseDto deleteCourse(long id);

}
