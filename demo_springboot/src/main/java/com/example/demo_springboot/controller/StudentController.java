package com.example.demo_springboot.controller;

import com.example.demo_springboot.payload.request.StudentRequest;
import com.example.demo_springboot.payload.response.StudentResponse;
import com.example.demo_springboot.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public StudentResponse create(@RequestBody StudentRequest request) {
        return studentService.create(request);
    }

    @GetMapping("/read")
    public StudentResponse read(
            @RequestParam(name = "id") String id
    ) {
        return studentService.read(id);
    }

    @PutMapping("/update")
    public StudentResponse update(@RequestParam(name = "id") String id,
                                  @RequestBody StudentRequest request
    ) {
        return studentService.update(id, request);
    }

    @DeleteMapping("/delete")
    public Object delete(@RequestParam(name = "id") String id) {
        studentService.delete(id);
        return Collections.emptyMap();
    }
}
