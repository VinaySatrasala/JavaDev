package com.jdbcCSR.jdbc.service;

import com.jdbcCSR.jdbc.model.Student;
import com.jdbcCSR.jdbc.repository.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public StudentService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Student> getAllStudents() {
        String sql = "select * from student";
        List<Student> students = namedParameterJdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    public Student getStudentById(int id) {
        String sql = "select * from student where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        List<Student> res = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        System.out.println(res);
        return res.get(0);
    }

    public Student addStudent(Student student) {
        String sql = "insert into student (id,name) values (:id,:name)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", student.getId());
        map.addValue("name", student.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return student;
    }

    public Student updateStudent(int id, Student student) {
        String sql = "update student set name = :name where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", student.getId());
        map.addValue("name", student.getName());
        namedParameterJdbcTemplate.update(sql, map);
        return student;
    }

    public Student deleteStudent(int id) {
        String sql = "delete from student where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, map);
        return null;
    }
}
