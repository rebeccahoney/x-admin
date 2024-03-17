package com.lantu.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rebecca
 * @since 2023-10-15
 */
@TableName("x_book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private String book_name;
    private String type;
    private Integer id;

    public String getBookName() {
        return book_name;
    }

    public void setBookName(String book_name) {
        this.book_name = book_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){ this.type = type;}
    @Override
    public String toString() {
        return "Book{" +
        "bookName = " + book_name + ", id = " + id + ", type = " + type +
        "}";
    }
}
