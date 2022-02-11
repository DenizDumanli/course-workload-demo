package com.courseworkload.service;

import com.courseworkload.model.dto.CourseDto;
import com.courseworkload.model.entity.Course;
import com.courseworkload.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService implements CourseServiceInterface {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<CourseDto> getCourses() {
        return courseRepository.findAll().stream().map(Course::toCourseDto).collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourse(long id) {
        Optional<Course> course = courseRepository.findById(id);

        return course.get().toCourseDto();
    }

    @Override
    public CourseDto createCourse(CourseDto course) {

        Course createdCourse = courseRepository.save(course.toCourse());
        return createdCourse.toCourseDto();
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        Optional<Course> course = courseRepository.findById(courseDto.getId());
        if (course.isPresent()) {
            Course updatedCourse = courseRepository.save(courseDto.toCourse());
            return updatedCourse.toCourseDto();
        } else {
            return null;
        }
    }

    @Override
    public CourseDto deleteCourse(long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            Course tobedeletedCourse = course.get();
            courseRepository.delete(tobedeletedCourse);
            return tobedeletedCourse.toCourseDto();
        } else
            return null;
    }
}
