package com.example.rahms.ui.rahms;

public class RAHMS {
    private Double BME280_Hum;
    private Double BME280_Pres;
    private Double BME280_Temp;
    private Double CCS811_CO2;
    private Double CCS811_tVOC;
    private Double Soil_Temp;
    private Double Soil_Moisture;
    private Double LDR;

    public RAHMS() {
    }

    public RAHMS(Double BME280_Hum, Double BME280_Pres, Double BME280_Temp, Double CCS811_CO2, Double CCS811_tVOC, Double soil_Temp, Double soil_Moisture, Double LDR) {
        this.BME280_Hum = BME280_Hum;
        this.BME280_Pres = BME280_Pres;
        this.BME280_Temp = BME280_Temp;
        this.CCS811_CO2 = CCS811_CO2;
        this.CCS811_tVOC = CCS811_tVOC;
        this.Soil_Temp = soil_Temp;
        this.Soil_Moisture = soil_Moisture;
        this.LDR = LDR;
    }

    public Double getBME280_Hum() {
        return BME280_Hum;
    }

    public void setBME280_Hum(Double BME280_Hum) {
        this.BME280_Hum = BME280_Hum;
    }

    public Double getBME280_Pres() {
        return BME280_Pres;
    }

    public void setBME280_Pres(Double BME280_Pres) {
        this.BME280_Pres = BME280_Pres;
    }

    public Double getBME280_Temp() {
        return BME280_Temp;
    }

    public void setBME280_Temp(Double BME280_Temp) {
        this.BME280_Temp = BME280_Temp;
    }

    public Double getCCS811_CO2() {
        return CCS811_CO2;
    }

    public void setCCS811_CO2(Double CCS811_CO2) {
        this.CCS811_CO2 = CCS811_CO2;
    }

    public Double getCCS811_tVOC() {
        return CCS811_tVOC;
    }

    public void setCCS811_tVOC(Double CCS811_tVOC) {
        this.CCS811_tVOC = CCS811_tVOC;
    }

    public Double getSoil_Temp() {
        return Soil_Temp;
    }

    public void setSoil_Temp(Double soil_Temp) {
        Soil_Temp = soil_Temp;
    }

    public Double getSoil_Moisture() {
        return Soil_Moisture;
    }

    public void setSoil_Moisture(Double soil_Moisture) {
        Soil_Moisture = soil_Moisture;
    }

    public Double getLDR() {
        return LDR;
    }

    public void setLDR(Double LDR) {
        this.LDR = LDR;
    }
}
