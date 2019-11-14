package com.homecredit.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;


@Entity
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user_menu")
public class UserMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="user_type")
    private String userType;

    @Type(type = "json")
    @Column(columnDefinition = "json",name = "user_properties")
    private String userProperties;

}
