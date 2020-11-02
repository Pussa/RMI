import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class Client {

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        System.out.println("VVEDITE CHISLO IGROKOV");
        int players =  scan.nextInt();
        int i =0;
        System.out.println("VVEDITE GOROD\nPLAYER" + i);
        scan.nextLine();
        String city = String.valueOf(scan.nextLine());
        String host = (args.length < 1) ? null : args[0];
        int j =60;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                scan.nextLine();

            }
        };


        Timer timer = new Timer();
        while (!city.equals("")){
            try {
                Registry registry = LocateRegistry.getRegistry(host);
                AdditionInterface stub = (AdditionInterface)
                        registry.lookup("Addition");

               //Timer timer = new Timer();


                i++;
                if (i==players+1) i=0;
                String response = String.valueOf(stub.Work(city));
                System.out.println("response: " + response);
                if (!response.equals("VERNO")){
                    i--;

                    System.out.println("POPROBUITE SNOVA\nPLAYER" + i);
                    while (j>0){
                        scan.nextLine();
                        j--;
                    }
                    timer.schedule(scan.nextLine(),1000);
                    //task.run();
                    city = scan.toString();
                }else{
                    System.out.println("VVEDITE GOROD\nPLAYER" + i);
                   // timer.schedule(task,5000);
                    //task.run();
                    while (j>0){
                        scan.nextLine();
                        j--;
                    }
                    city = scan.toString();
                }



            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }

        }
        timer.cancel();
        task.cancel();

        System.out.println("PLAYER"+i+" PROIGRAL");
        scan.close();
    }
}







