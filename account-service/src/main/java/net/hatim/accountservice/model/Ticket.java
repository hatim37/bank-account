package net.hatim.accountservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Ticket {

    private Long id;
    private String name;
    private Integer place;
}
