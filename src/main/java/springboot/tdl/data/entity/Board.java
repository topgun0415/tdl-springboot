package springboot.tdl.data.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private String title;

    @Column(nullable = false, length = 20)
    private String content;

    @Temporal(TemporalType.DATE)
    private LocalDate registration_date;

    @Temporal(TemporalType.DATE)
    private LocalDate renewal_date;

    private Boolean isAccomplished;

}
