package com.courseworkload.model.dto;

import com.courseworkload.model.entity.Course;
import lombok.Data;

@Data
public class CourseDto {

    private long id;
    private String course_name;

    public Course toCourse(){
        Course course = new Course();
        course.setId(this.getId());
        course.setCourse_name(this.getCourse_name());
        return course;
    }

}
