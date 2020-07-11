package com.bytesw.school.bs.controller;

import com.bytesw.school.bs.service.StudentService;
import com.bytesw.school.eis.bo.Student;
import com.bytesw.school.eis.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
public class StudentController {

    @Bean
    public WebMvcConfigurer CORSConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

            }

            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

            }

            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

            }

            @Override
            public void addFormatters(FormatterRegistry formatterRegistry) {

            }

            @Override
            public void addInterceptors(InterceptorRegistry interceptorRegistry) {

            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
                        .maxAge(-1)   // add maxAge
                        .allowCredentials(false);
            }


            @Override
            public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {

            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

            }

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

            }

            @Override
            public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

            }

            @Override
            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

            }

            @Override
            public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

            }

            @Override
            public Validator getValidator() {
                return null;
            }

            @Override
            public MessageCodesResolver getMessageCodesResolver() {
                return null;
            }
        };
    }

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> response = this.studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int id){
        StudentDTO response = this.studentService.getStudent(id);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody Student student){
        StudentDTO response = this.studentService.saveStudent(student);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody Student student){
        StudentDTO response = this.studentService.updateStudent(student);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable int id){
        StudentDTO response = this.studentService.deleteStudent(id);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    //Update grade by id
    @PutMapping("/id/{id}/grade/{grade}")
    public ResponseEntity<StudentDTO> updateGrade(@PathVariable int id, @PathVariable int grade){
        this.studentService.updateGrade(id, grade);
        StudentDTO response = this.studentService.getStudent(id);
        return new ResponseEntity<StudentDTO>(response, HttpStatus.OK);
    }

    //Update grade by section
    @PutMapping("/section/{section}/grade/{grade}")
    public ResponseEntity<List<Student>> updateGradeBySec(@PathVariable String section, @PathVariable int grade){
        this.studentService.updateGradeBySec(section, grade);
        List<Student> response = this.studentService.byGrade(grade);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Delete students by grade
    @DeleteMapping("/delByGrade/{grade}")
    public ResponseEntity<List<Student>> delByGrade(@PathVariable int grade){
        List<Student> response = this.studentService.byGrade(grade);
        this.studentService.delByGrade(grade);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Students by grade
    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Student>> byGrade(@PathVariable int grade){
        List<Student> response = this.studentService.byGrade(grade);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Students by grade and section
    @GetMapping("/{grade}/{section}")
    public ResponseEntity<List<Student>> byGradeAndSection(@PathVariable int grade, @PathVariable String section){
        List<Student> response = this.studentService.byGradeAndSection(grade, section);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Students by age, grade and section
    @GetMapping("/age/{age}/grade/{grade}/section/{section}")
    public ResponseEntity<List<Student>> byThreeParams(@PathVariable int age, @PathVariable int grade, @PathVariable String section){
        List<Student> response = this.studentService.byThreeParams(age,grade, section);
        return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
    }

    //Search By Name
    @GetMapping("/byName/{firstname}")
    public ResponseEntity<Student> searchByName(@PathVariable String firstname){
        Student response = this.studentService.searchByName(firstname);
        return new ResponseEntity<Student>(response, HttpStatus.OK);
    }
}
