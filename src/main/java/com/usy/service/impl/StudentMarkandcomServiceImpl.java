package com.usy.service.impl;

import com.usy.mapper.StudentMarkandcomMapper;
import com.usy.pojo.StudentMarkandcom;
import com.usy.service.StudentMarkandcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentMarkandcomService")
public class StudentMarkandcomServiceImpl implements StudentMarkandcomService {
    @Autowired
    private StudentMarkandcomMapper studentMarkandcomMapper;
    @Override
    public boolean add(StudentMarkandcom studentMarkandcom) {
        int row=studentMarkandcomMapper.add(studentMarkandcom);
        return row == 1 ? true : false;
    }

}
