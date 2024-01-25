package host.uol.repositorie;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "jogadores")
public class Jogadores implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;


    @Column
    private String email;

    @Column
    private String telefone;


    @Column
    private String codinome;

    @Column
    private String grupo;

}
