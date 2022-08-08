package com.fourfinance.loan.sample.lendmoney.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "IPAddressCheck")
@Access(value= AccessType.FIELD)
public class IPAddressEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "IPAddress")
    String ipAddress;

    @Column(name = "TaxPayerId")
    String taxPayerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTaxPayerId() {
        return taxPayerId;
    }

    public void setTaxPayerId(String taxPayerId) {
        this.taxPayerId = taxPayerId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IPAddressEntity)) return false;
        IPAddressEntity that = (IPAddressEntity) o;
        return ipAddress.equals(that.ipAddress) && taxPayerId.equals(that.taxPayerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, taxPayerId);
    }
}
