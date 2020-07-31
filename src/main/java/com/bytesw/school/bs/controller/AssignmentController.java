package com.bytesw.school.bs.controller;

import com.bytesw.school.bs.service.AssignmentService;
import com.bytesw.school.eis.bo.Assignment;
import com.bytesw.school.eis.dto.AssignmentDTO;
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
import java.util.Optional;

@RestController
@RequestMapping(value = "/assignment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AssignmentController {

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

    private AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignment(@PathVariable int id){
        Assignment response = this.assignmentService.getAssignment(id);
        return new ResponseEntity<Assignment>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Assignment>> searchAllAssign(){
        List<Assignment> response = this.assignmentService.searchAllAssign();
        return new ResponseEntity<List<Assignment>>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment){
        Assignment response = this.assignmentService.createAssignment(assignment);
        return new ResponseEntity<Assignment>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment){
        Assignment response = this.assignmentService.updateAssignment(assignment);
        return new ResponseEntity<Assignment>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Assignment> deleteAssignment(@RequestParam int id){
        Assignment response = this.assignmentService.deleteAssignment(id);
        return new ResponseEntity<Assignment>(response, HttpStatus.OK);
    }
}
