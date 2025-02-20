package springboot.tdl.data.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Board> boards = new ArrayList<>();

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 15)
    private String name;

}
