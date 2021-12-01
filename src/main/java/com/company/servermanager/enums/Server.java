package com.company.servermanager.enums;

import com.company.servermanager.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Ip Address cannot be empty or null")
    private String ipAddress;

    private String name;

    private String memory;

    private String type;

    private String imageUrl;

    private Status status;

}
