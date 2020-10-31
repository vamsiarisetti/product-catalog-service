package com.org.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String product;

    private String isbn;

    private boolean isAvailable;

    private LocalDateTime last_update;
}
