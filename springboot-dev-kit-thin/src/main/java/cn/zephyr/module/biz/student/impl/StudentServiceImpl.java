package cn.zephyr.module.biz.student.impl;

import cn.zephyr.common.result.PageResultBean;
import cn.zephyr.framework.dao.BaseService;
import cn.zephyr.framework.dao.Page;
import cn.zephyr.module.biz.student.StudentService;
import cn.zephyr.module.entity.Student;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Title: SpringBoot-BasicModules
 * @Package: cn.zephyr.module.biz.impl
 * @Description:
 * @author: Lai
 * @date 2018/8/6 18:55
 */
@Service
public class StudentServiceImpl extends BaseService<Student,Integer> implements StudentService {

    @Override
    public Student getById(Integer id) {
        return this.dao.executeSelectOneMethod(id,"selectByPrimaryKey",Student.class);
    }

    @Override
    public PageResultBean<Student> getList4Page(Student student, Page page) {
        List<Student> studentList = dao.executeListMethod(student, "queryList", page, "queryListCount", Student.class);
        return PageResultBean.querySucc(page.getTotalRows(),studentList);
    }

    private void genStudentData(){
        List<Student> students = new ArrayList<>();
        String sArray = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎";
        for (int i = 0; i < 20; i++) {
            Student s = new Student();
            Integer rad = new Random().nextInt(sArray.length()-1);
            s.setName(sArray.substring(rad,rad+1)+String.valueOf(getRandomChar())+String.valueOf(getRandomChar()));
            s.setAge(7+new Random().nextInt(2));
            s.setGrade("三");
            s.setClazz("三年二班");
            s.setGender(new Random().nextInt(1)==0?"F":"M");
            s.setCreateTime(new Date());
            s.setUpdateTime(s.getCreateTime());
            students.add(s);
        }
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("students",students);
        dao.executeInsertMethod(dataMap,"batchInsert");
    }

    public char getRandomChar() {
        String str = "";
        int hightPos;
        int lowPos;

        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return str.charAt(0);
    }
}
