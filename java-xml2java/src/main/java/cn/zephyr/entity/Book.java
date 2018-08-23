package cn.zephyr.entity;

import cn.zephyr.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class Book {
    private Long id;
    private String name;
    private Double price;
    private Date publicationDate;

    private List<String> language;

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Book setPrice(Double price) {
        this.price = price;
        return this;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getPublicationDate() {
        return publicationDate;
    }

    public Book setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    @XmlElementWrapper(name="languages")
    public List<String> getLanguage() {
        return language;
    }

    public Book setLanguage(List<String> language) {
        this.language = language;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publicationDate=" + publicationDate +
                ", language=" + language +
                '}';
    }
}
