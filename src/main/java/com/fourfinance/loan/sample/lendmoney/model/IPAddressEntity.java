package com.fourfinance.loan.sample.lendmoney.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor/*
@Table(name = "IPAddressCountCheck")
@Access(value= AccessType.FIELD)*/
public class IPAddressEntity {

    //@Column(name = "IPAddress")
    String ipAddress;

    //@Column(name = "Count")
    int count;

    String userName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IPAddressEntity)) return false;
        IPAddressEntity that = (IPAddressEntity) o;
        return count == that.count && ipAddress.equals(that.ipAddress) && userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, count, userName);
    }
}
