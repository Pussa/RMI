import java.lang.reflect.Array;
import java.rmi.Remote;
import java.sql.*;
import java.util.*;
import java.rmi.RemoteException;

public class Cities  implements AdditionInterface {


    String pr_ct;
    String[] citiess;
    List<String> worker;

    public Cities(String[] citiess){
        this.citiess = citiess;
        worker = Arrays.asList(citiess);
        this.pr_ct ="";
    }



    public String Work(String city) {
        city = city.toLowerCase();
        if (pr_ct.equals("")) {
            for (String s : worker) {
                if (s.equals(city)) {
                    pr_ct = pr_ct + city;
                    return "VERNO";
                }

            }
            return "GORODA NET";
        } else {
            if ((pr_ct.charAt(pr_ct.length() - 1) == city.charAt(0)) & (!pr_ct.contains(city))) {
                for (String s : worker) {
                    if (s.equals(city)) {
                        pr_ct = pr_ct + city;
                        return "VERNO";
                    }
                }
                return "GORODA NET";
            }
            return "PODBERITE DRUGOI GOROD";
        }



    }
}


