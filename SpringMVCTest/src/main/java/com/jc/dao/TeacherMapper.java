package com.jc.dao;

import com.jc.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    public List<Teacher> FindAll();
    public void AddTea(Teacher teacher);
}
