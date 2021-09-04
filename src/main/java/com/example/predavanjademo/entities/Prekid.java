package com.example.predavanjademo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prekidi")
public class Prekid {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "")
    private Integer brojPrekida;

    @Column
    private String region;

    @Column
    private String grad;

    @Column
    private Integer brojPotrosaca;

    @Column(name = "tip1")
    private String tip1;

    @Column(name = "tip2")
    private String tip2;

    @Column(name = "tip3")
    private String tip3;

    @Column(name = "tip4")
    private String tip4;

    @Column(name = "eeo")
    private String eeo;

    @Column(name = "kablovski_vod")
    private boolean kablovskiVod;

    @Column(name = "broj_depese")
    private String brojDepese;

    @Column(name = "plan_pocetak")
    private Date planPocetak;

    @Column(name = "plan_kraj")
    private Date planKraj;

    @Column(name = "realizacija_pocetak")
    private Date realizacijaPocetak;

    @Column(name = "realizacija_kraj")
    private Date realizacijaKraj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrojPrekida() {
        return brojPrekida;
    }

    public void setBrojPrekida(Integer brojPrekida) {
        this.brojPrekida = brojPrekida;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Integer getBrojPotrosaca() {
        return brojPotrosaca;
    }

    public void setBrojPotrosaca(Integer brojPotrosaca) {
        this.brojPotrosaca = brojPotrosaca;
    }

    public String getTip1() {
        return tip1;
    }

    public void setTip1(String tip1) {
        this.tip1 = tip1;
    }

    public String getTip2() {
        return tip2;
    }

    public void setTip2(String tip2) {
        this.tip2 = tip2;
    }

    public String getTip3() {
        return tip3;
    }

    public void setTip3(String tip3) {
        this.tip3 = tip3;
    }

    public String getTip4() {
        return tip4;
    }

    public void setTip4(String tip4) {
        this.tip4 = tip4;
    }

    public String getEeo() {
        return eeo;
    }

    public void setEeo(String eeo) {
        this.eeo = eeo;
    }

    public boolean isKablovskiVod() {
        return kablovskiVod;
    }

    public void setKablovskiVod(boolean kablovskiVod) {
        this.kablovskiVod = kablovskiVod;
    }

    public String getBrojDepese() {
        return brojDepese;
    }

    public void setBrojDepese(String brojDepese) {
        this.brojDepese = brojDepese;
    }

    public Date getPlanPocetak() {
        return planPocetak;
    }

    public void setPlanPocetak(Date planPocetak) {
        this.planPocetak = planPocetak;
    }

    public Date getPlanKraj() {
        return planKraj;
    }

    public void setPlanKraj(Date planKraj) {
        this.planKraj = planKraj;
    }

    public Date getRealizacijaPocetak() {
        return realizacijaPocetak;
    }

    public void setRealizacijaPocetak(Date realizacijaPocetak) {
        this.realizacijaPocetak = realizacijaPocetak;
    }

    public Date getRealizacijaKraj() {
        return realizacijaKraj;
    }

    public void setRealizacijaKraj(Date realizacijaKraj) {
        this.realizacijaKraj = realizacijaKraj;
    }





}
