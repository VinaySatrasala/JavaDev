package com.UST.jdbcExam.controller;

import com.UST.jdbcExam.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StudentController(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        String sql = "select * from student";
        List<Student> list = jdbcTemplate.query(sql,new StudentRowMapper());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        String sql = "select * from student where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        List<Student> student= jdbcTemplate.query(sql, params, new StudentRowMapper());
        return ResponseEntity.ok(student.get(0));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        String sql = "INSERT INTO student (id,name) values (:id,:name)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", student.getId());
        params.addValue("name", student.getName());
        int update = jdbcTemplate.update(sql, params);
        if (update == 1) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.ok(null);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        String sql = "update student set name = :name where id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", student.getId());
        params.addValue("name", student.getName());
        int update = jdbcTemplate.update(sql, params);
        if (update == 1) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.ok(null);
    }
}
