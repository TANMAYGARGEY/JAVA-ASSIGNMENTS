import java.time.Year;
import java.util.*;
public class Vehicle {
    public String brandName;
    public String modelName;
    public double price;
    public String color;
    private String mfgCde;
    private String regNo;
    public Year mfgYear;
    public char fuelType;

    //gETTER ADN SETTER METHIODS
    public void setMfgCode(String mCode) {
        mfgCde = mCode;
    }
    public String getmfgCode()
    {
        return mfgCde;
    }
    public void setregNo(String regNo) {
        regNo = regNo;
    }
    public String getregNo()
    {
        return regNo;
    }
    //Default constructor
    public Vehicle()
    {
        brandName="Hyundai";
        modelName="i10";
        color="Silver";
        price=500000.99;
        mfgCde="hyn1234";
        regNo="HYN98765";
        mfgYear=Year.of(2020);
        fuelType='d';
    }
    //paratimized construct
    public Vehicle(String brandName, String modelName, double price, String mfgCde)
    {
        this.brandName=brandName;
        this.modelName=modelName;
        this.price=price;
        this.mfgCde=mfgCde;
    }
    public Vehicle(String bName, String mName, Year yom,double p)
    {
        brandName=bName;
        modelName=mName;
        mfgYear=yom;
        price=p;
    }
    //copy contructor
    public Vehicle(Vehicle v)
    {
        brandName=v.brandName;
        modelName=v.modelName;
        color=v.color;
        price=v.price;
        mfgCde=v.mfgCde;
        regNo=v.regNo;
        mfgYear=v.mfgYear;
        fuelType=v.fuelType;
    }
    public void start(int initSp)
    {
        System.out.println("I.ve started with an initial speed of "+initSp);
    }
    public void stop()
    {
        System.out.println("that was a nice ride!");
    }
    public void drive(int initGear, int initSp, int tgtSp)
    {
        if(initGear!=1)
            System.out.println("I always start with moving at first gear");
        if(initSp<20)
            System.out.println("this is ithe ideal speed to start with.");
        else
            System.out.println("Be careful!");
        if((tgtSp>200))
            System.out.println("Look out for cops!");
        else
            System.out.println("You are within the ideal speed range");
    }
    public double calcTripMileage(double noOfKms, double fuelUsed)
    {
        return noOfKms/fuelUsed;
    }


}

