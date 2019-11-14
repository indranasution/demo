package com.homecredit.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
@Table(name="users_group")
public class UsersGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name="user_type")
    private String userType;

    @Type(type = "json")
    @Column(columnDefinition = "json",name = "user_type_properties")
    private String userTypeProperties;
}
