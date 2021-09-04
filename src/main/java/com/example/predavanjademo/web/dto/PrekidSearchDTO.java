package com.example.predavanjademo.web.dto;
import java.util.Date;

public class PrekidSearchDTO {

    private Integer id;

    private Integer brojPrekida;

    private String region;

    private String grad;

    private Integer brojPotrosaca;

    private String tip1;

    private String tip2;

    private String tip3;

    private String tip4;

    private String eeo;

    private boolean kablovskiVod;

    private String brojDepese;

    private Date planPocetak;

    private Date planKraj;

    private Date realizacijaPocetak;

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

