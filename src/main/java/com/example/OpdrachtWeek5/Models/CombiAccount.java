package com.example.OpdrachtWeek5.Models;

import javax.persistence.*;


@Entity
@Table(name = "combiAccount")
public class CombiAccount {

    @Id
    @GeneratedValue
    @Column(name = "combiAccountId")
    private Long combiAccountId;

    @OneToOne
    @JoinColumn(name = "firstAccount")
    private FirstHalfAccount firstAccount;

    @OneToOne
    @JoinColumn(name = "secondAccount")
    private SecondHalfAccount secondAccount;
}
