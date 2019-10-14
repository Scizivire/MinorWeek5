package com.example.OpdrachtWeek5.Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
class FirstHalfAccount extends Account{

    @OneToOne
    private CombiAccount firstParentAccount;
}
