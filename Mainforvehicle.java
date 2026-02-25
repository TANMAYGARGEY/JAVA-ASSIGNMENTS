import javax.swing.tree.VariableHeightLayoutCache;
import java.sql.SQLOutput;
import java.time.Year;

public class MainForVehicle
{
    public static void printVehicle(Vehicle v)
    {
        System.out.println("\n===============================Vehicle Details===================");
        System.out.println("Brand Name: " +v.brandName);
        System.out.println("Model Name: " +v.modelName);
        System.out.println("Price: " +v.price);
        System.out.println("mfg Code: " +v.getmfgCode());
        System.out.println("Registration number: "+v.getregNo());
        System.out.println("Year of MFG: "+ v.mfgYear);
        System.out.println("Fuel Type: "+v.fuelType);
        System.out.printf("color: "+v.color);
        System.out.println("\n============================ENF OF VEHICLE DETAILS===============");
    }
    public static void main(String args[])
    {
        Vehicle defV=new Vehicle();
        printVehicle(defV);
        Vehicle v2= new Vehicle("honda","HON123",454545,"HON864");
        //v2.start(15);
        //v2.drive(0,20,120);
        double mileage=v2.calcTripMileage(140,20);
        System.out.println("Trip Mileage : "+mileage);
        //v2.stop();
        Vehicle v3=v2;
        v3.setMfgCode("HON98777654");
        v3.color="Orange";
        printVehicle(v3);
        Vehicle v4=new Vehicle(v2);
        v4.color="Black";
        v4.setMfgCode("V12345678");
        v4.fuelType='D';
        printVehicle(v4);
        Vehicle v5=new Vehicle ("Mercedes"," S Class", Year.of(2001),9807776);
        Vehicle[] myfleet= new Vehicle[]{defV,v2,v3,v4,v5};
        for(Vehicle myV: myfleet)
        {
            printVehicle(myV);
            myV.start(30);
            myV.drive(1,20,100);
            double mileage1= myV.calcTripMileage(300,35);
            System.out.println("Mileage"+mileage1);
        }
        //bname,mdname,fueltype,mileage--tabular form
    }
}
