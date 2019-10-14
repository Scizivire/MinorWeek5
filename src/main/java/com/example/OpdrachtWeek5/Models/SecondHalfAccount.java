package com.example.OpdrachtWeek5.Models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("2")
class SecondHalfAccount extends Account {

    @OneToOne
    private CombiAccount secondParentAccount;
}