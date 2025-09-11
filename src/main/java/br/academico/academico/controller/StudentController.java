package br.academico.academico.controller;

import br.academico.academico.dto.StudentDTO;
import br.academico.academico.model.Student;
import br.academico.academico.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(this.studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id){
        return new ResponseEntity<>(this.studentService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Student> postStudent(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(this.studentService.createStudent(studentDTO), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(this.studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id){
        return new ResponseEntity<>(this.studentService.deleteStudent(id), HttpStatus.OK);
    }
}
