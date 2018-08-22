package cn.zephyr;

import cn.zephyr.entity.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class Xml2Java {
    public static void main(String[] args) {
        try {
            System.err.println(getByString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Student getByString() throws Exception{
        JAXBContext context = JAXBContext.newInstance(Student.class);

        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Student student = new Student();
        marshaller.marshal(student, System.out);
        System.out.println();

        String xml = "<student><id>1</id><name>David</name><age>19</age></student>";
        return (Student) unmarshaller.unmarshal(new StringReader(xml));

    }
}
