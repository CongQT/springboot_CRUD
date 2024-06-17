package com.example.demo_springboot.service.impl;

import com.example.demo_springboot.entity.Student;
import com.example.demo_springboot.payload.request.StudentRequest;
import com.example.demo_springboot.payload.response.StudentResponse;
import com.example.demo_springboot.repository.StudentRepository;
import com.example.demo_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;

    private final ModelMapper modelMapper;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();
        studentRepo.save(student);
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public StudentResponse read(String id) {
        Student student = studentRepo.findById(id).orElseThrow();
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public StudentResponse update(String id, StudentRequest request) {
        Student student = studentRepo.findById(id).orElseThrow();
        modelMapper.map(request, student);
        studentRepo.save(student);
        return modelMapper.map(student, StudentResponse.class);
    }

    @Override
    public void delete(String id) {
        studentRepo.deleteById(id);
    }
}
