package cn.zephyr;

import cn.zephyr.entity.Book;
import cn.zephyr.entity.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Xml2Java {
    public static void main(String[] args) {
        try {
            System.err.println(quickStart());
//            System.err.println(xml2Java());
//            System.err.println(java2Xml("student.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.基本使用，将xml内容装配到Java实体
     *  涉及注解：@XmlRootElement
     *  先是 marshall 成 xml文件,再是把 xml 文件 unmarshal 成 java object。
     * @return
     * @throws Exception
     */
    public static Student quickStart() throws Exception{
        JAXBContext context = JAXBContext.newInstance(Student.class);

        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Student student = new Student();
        marshaller.marshal(student, System.out);
        System.out.println();

        // 模拟xml文件内容，实际的使用的时候可以流读取
        String xml = "<student><id>1</id><name>David</name><age>19</age></student>";
        return (Student) unmarshaller.unmarshal(new StringReader(xml));
    }

    /**
     * 从xml文件中读取数据（包括List）到Java对象
     * 涉及注解：@XmlRootElement、@XmlElementWrapper
     * @return
     * @throws Exception
     */
    public static Book xml2Java() throws Exception{
        JAXBContext context = JAXBContext.newInstance(Book.class);

        Marshaller marshaller = context.createMarshaller();
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Book book = new Book();
        marshaller.marshal(book, System.out);
        String xml = fileReader("book.xml");
        return (Book)unmarshaller.unmarshal(new StringReader(xml));
    }

    /**
     * 将Java对象写入到xml文件
     * 涉及注解：
     * @return
     * @throws Exception
     */
    public static Boolean java2Xml(String fileName) throws Exception{
        Student student = new Student(112233L,"haha",21);
        File file = new File(System.getProperty("user.dir")+"/java-xml2java/src/main/resource/"+fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(student , file);
        return true;
    }


    private static String fileReader(String fileName) throws IOException {
        BufferedReader in=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/java-xml2java/src/main/resource/"+fileName));
        String line=in.readLine();
        String xml="";
        while (line!=null)
        {
            xml += line;
            line=in.readLine();
        }
        in.close();
        return xml;
    }

}
