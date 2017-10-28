package com.yed.classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by emmanuel on 23/10/2017.
 */
public class EpiMessage extends Entitee implements Serializable {

    private static final String codeEpiMessage = "epialert";

    private String numero;
    private String district;
    private String aire;
    private String date;
    private String cas;
    private Integer age;
    private String sexe;
    private String signe;


    private String message;
    private String dateFormat = "dd/MM/yyyy";
    SimpleDateFormat sdformat ;
    private Date dateSystem ;
    private String nom;
    private String prenom;

    private Integer etat;

    private Aire zone;

    public EpiMessage() {
        this.dateSystem = Calendar.getInstance().getTime();
    }

    public EpiMessage(String numero, String district, String aire, String date, String cas, Integer age, String sexe, String signe) {
        this.numero = numero;
        this.district = district;
        this.aire = aire;
        this.date = date;
        this.cas = cas;
        this.age = age;
        this.sexe = sexe;
        this.signe = signe;
        this.dateSystem = Calendar.getInstance().getTime();
    }

    public EpiMessage(String numero, String district, String aire, Calendar date, String cas, Integer age, String sexe, String signe) {
        this.numero = numero;
        this.district = district;
        this.aire = aire;
        this.date = getDate(date);
        this.cas = cas;
        this.age = age;
        this.sexe = sexe;
        this.signe = signe;
        this.dateSystem = Calendar.getInstance().getTime();
    }

    public EpiMessage(String numero, String district, Aire aire, Calendar date, String cas, Integer age, String sexe, String signe) {
        this.numero = numero;
        this.district = district;
        this.zone = aire;
        this.date = getDate(date);
        this.cas = cas;
        this.age = age;
        this.sexe = sexe;
        this.signe = signe;
        this.dateSystem = Calendar.getInstance().getTime();
    }

    public static String getCodeEpiMessage() {
        return codeEpiMessage;
    }

    public String getNumero() {
        return numero;
    }

    public EpiMessage setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public EpiMessage setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getAire() {
        return aire;
    }

    public EpiMessage setAire(String aire) {
        this.aire = aire;
        return this;
    }

    public String getDate() {
        return date;
    }

    public String getDate(Calendar date) {
        sdformat = new SimpleDateFormat(dateFormat);
        return (sdformat.format(date.getTime()));
    }

    public EpiMessage setDate(String date) {
        this.date = date;
        return this;
    }

    public String getCas() {
        return cas;
    }

    public EpiMessage setCas(String cas) {
        this.cas = cas;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public EpiMessage setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public EpiMessage setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public EpiMessage setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getSexe() {
        return sexe;
    }

    public EpiMessage setSexe(String sexe) {
        this.sexe = sexe;
        return this;
    }

    public String getSigne() {
        return signe;
    }

    public EpiMessage setSigne(String signe) {
        this.signe = signe;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public EpiMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public EpiMessage setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }
    
    public Date getDateSystem() {
        return dateSystem;
    }

    public EpiMessage setDateSystem(Date dateSystem) {
        this.dateSystem = dateSystem;
        return this;
    }

    public Integer getEtat() {
        return etat;
    }

    public EpiMessage setEtat(Integer etat) {
        this.etat = etat;
        return this;
    }

    public Aire getZone() {
        return zone;
    }

    public EpiMessage setZone(Aire zone) {
        this.zone = zone;
        return this;
    }

    @Override
    public String toString() {
        return "EpiMessage{" +
                "numero='" + numero + '\'' +
                ", district='" + district + '\'' +
                ", aire='" + aire + '\'' +
                ", date=" + date +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", signe='" + signe + '\'' +
                ", message='" + message + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", dateSystem=" + dateSystem +
                ", etat=" + etat +
                '}';
    }

    public String ConsoliderMessageEpiAlert() {
        sdformat = new SimpleDateFormat(dateFormat);
        return codeEpiMessage + ";<" +
                district + ">;<" +
                aire + ">;<" +
                date + ">;<" +
                age + ">;<" +
                sexe + ">;<" +
                signe + ">;<" +
                sdformat.format(dateSystem) + ">;<" +
                numero +
                ">";
    }

    public String DialogEpiMessageAlert() {
        sdformat = new SimpleDateFormat(dateFormat);
        return codeEpiMessage + ";<" +
                district + ">;<" +
                aire + ">;<" +
                date + ">;<" +
                age + ">;<" +
                sexe + ">;<" +
                signe + ">;<" +
                sdformat.format(dateSystem) + ">;<" +
                numero +
                ">";
    }

    public String getDialogEpiMessageAlert() throws Exception{
        return "<font color=#A4A4A4><bold>Numero : </bold></font>" + numero + "<br>" +
                "<font color=#A4A4A4><bold>District : </bold></font>" + district + "<br>" +
                "<font color=#A4A4A4><bold>Aire : </bold></font>" + aire + "<br>" +
                "<font color=#A4A4A4><bold>Date : </bold></font>" + date + "<br>" +
                "<font color=#A4A4A4><bold>Age : </bold></font>" + age + "<br>" +
                "<font color=#A4A4A4><bold>Sexe : </bold></font>" + sexe + "<br>" +
                "<font color=#A4A4A4><bold>Signe : </bold></font>" + signe + "<br>" ;
    }

}
