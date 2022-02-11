package com.courseworkload.model.entity;

import com.courseworkload.model.dto.CourseDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_name", nullable = false)
    private String course_name;


    public CourseDto toCourseDto(){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(this.getId());
        courseDto.setCourse_name(this.getCourse_name());
        return courseDto;
    }

}
