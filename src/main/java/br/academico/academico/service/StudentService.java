package br.academico.academico.service;

import br.academico.academico.dto.StudentDTO;
import br.academico.academico.exception.StudentNotFoundException;
import br.academico.academico.model.Student;
import br.academico.academico.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student getById(Long id){
        Optional<Student> studentOpt = this.studentRepository.findById(id);
        if(studentOpt.isEmpty()){
            throw new StudentNotFoundException("Estudante não foi encontrado");
        }

        return studentOpt.get();
    }

    public Student createStudent(StudentDTO dto){
        Student student = new Student();
        student.setAddress(dto.getAddress());
        student.setCpf(dto.getCpf());
        student.setName(dto.getName());

        return this.studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        Optional<Student> studentOpt = this.studentRepository.findById(student.getId());
        if(studentOpt.isEmpty()){
            throw new StudentNotFoundException("Estudante não foi encontrado para atualização");
        }

        return this.studentRepository.save(student);
    }

    public Student deleteStudent(Long id){
        Optional<Student> studentOpt = this.studentRepository.findById(id);
        if(studentOpt.isEmpty()){
            throw new StudentNotFoundException("Estudante não foi encontrado para exclusão");
        }

        this.studentRepository.deleteById(id);

        return studentOpt.get();
    }
}
