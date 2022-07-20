package discovery.api;


import discovery.repo.StudentRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Student CRUD operations", description = "This Controller will do some Student CRUD operations")
@RestController
public class DemoApi {

    @Value("${discovery.account.demo}")
    private String course;

    @Autowired
    private StudentRepo studentRepo;

    private List<Student> students = new ArrayList<>();

    @Operation(description = "This api will check if the application is running", summary = "/ping", tags = "/ping")
    @GetMapping("/ping")
    public String ping() {
        return "We are learning " + course;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student saveedStudent =  studentRepo.save(student);
        return new ResponseEntity<Student>(saveedStudent, HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Integer id, @RequestBody Student student) {

        return new ResponseEntity<Student>(student, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Integer id) {

        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = (List<Student>) studentRepo.findAll();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @Operation(
            summary = "Finds a student",
            description = "Finds a person by their Id.",
            tags = { "People" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Student.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getAStudent(@PathVariable("studentId") Integer id) {
        Student foundStudent = studentRepo.findById(id).orElse(Student.builder().build());
        return new ResponseEntity<Student>(foundStudent, HttpStatus.OK);
    }
}
