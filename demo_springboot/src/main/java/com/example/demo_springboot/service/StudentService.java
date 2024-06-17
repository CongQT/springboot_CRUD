package com.example.demo_springboot.service;

import com.example.demo_springboot.payload.request.StudentRequest;
import com.example.demo_springboot.payload.response.StudentResponse;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    StudentResponse read(String id);

    StudentResponse update(String id, StudentRequest request);

    void delete(String id);
}
