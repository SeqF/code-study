import com.study.mapper.StudentMapper;
import com.study.mapper.TeacherMapper;
import com.study.pojo.Student;
import com.study.pojo.Teacher;
import com.study.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    public static void main(String[] args) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacherById(1);

        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getStudent(){

        SqlSession sqlSession=MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent();

        for(Student stu:studentList){
            System.out.println(stu);
        }

        sqlSession.close();
    }

    @Test
    public void getStudent2(){

        SqlSession sqlSession=MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = mapper.getStudent2();

        for(Student stu:studentList){
            System.out.println(stu);
        }

        sqlSession.close();
    }



}
