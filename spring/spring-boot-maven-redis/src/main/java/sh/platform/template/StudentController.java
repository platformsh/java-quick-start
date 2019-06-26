package sh.platform.template;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String save(@RequestBody @Valid Student student) {
        repository.save(student);
        return "Saved- " + student.getName();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Student get(@PathVariable("id") String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @GetMapping(produces = "application/json")
    public Iterable<Student> get() {
        return repository.findAll();
    }


    @PutMapping(value = "/{id}", produces = "application/json")
    public Student update(@PathVariable("id") String id, @RequestBody @Valid Student student) {
        repository.save(student);
        return student;
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Student delete(@PathVariable("id") String id) {
        Student student = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.deleteById(id);
        return student;
    }
}
