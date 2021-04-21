package com.zzjm;

import com.zzjm.Service.StudentService;
import com.zzjm.dao.StudentDao;
import com.zzjm.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        String config="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        String names []=applicationContext.getBeanDefinitionNames();
        for (String na:names){
            System.out.println("对象的名称"+na+":"+applicationContext.getBean(na));
        }
    }
    @Test
    public void insertStudent(){
        String config="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
       StudentDao studentDao=(StudentDao) applicationContext.getBean("studentDao");
        Student student=new Student();
        student.setId(1002);
        student.setName("张三");
        student.setEmail("zs@163.com");
        student.setAge(22);
        int num=studentDao.insertStudent(student);
        System.out.println("插入记录"+num);
    }
    @Test
    public void addStudent(){
        String config="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
       StudentService studentService= (StudentService) applicationContext.getBean("StudentService");
        Student student=new Student();
        student.setId(1004);
        student.setName("lisi");
        student.setEmail("lisi@163.com");
        student.setAge(23);
        int num=studentService.addStudent(student);
        System.out.println("插入记录"+num);
    }
    @Test
    public void selelctStudent(){
        String config="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);
        StudentService studentService= (StudentService) applicationContext.getBean("StudentService");
       List<Student> list=studentService.queryStudents();
       for (Student student:list){
           System.out.println(student);
       }
    }
}
