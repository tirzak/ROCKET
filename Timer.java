
import java.io.*;

public class ROCKET {
    private String[] myPart;

    ROCKET(int array) {
      myPart= new String[array];//To create an array according to the required sections

    } 

    private   int i=0;
      private double[] time = new double[2];


      //Timer
        public void t(String part,int l) {

        if (i < myPart.length) {
            if (l == 1) {//To differentiate between stop and start
                time[0] = System.nanoTime();//Gets initial time

            }
            
            else { 
                 time[1] = (System.nanoTime() - time[0])/100000000;//Gets the time in seconds

                myPart[i] =part+ ": " + time[1] + "seconds";
                i++;

            }
        }
    }


        //Writes the array elements to a file
        public void write(){
            try {
                FileWriter myWriter = new FileWriter("Test.txt");
                BufferedWriter buffWrite = new BufferedWriter(myWriter);
                PrintWriter print = new PrintWriter(buffWrite);
               
               //Writes the value of the array to the text
                for (int i = 0; i < myPart.length; i++) {
                    if (myPart[i] != null)

                        print.write(myPart[i]);
                    print.write("\n");
                }
                print.close();


            } catch (IOException error) {
                System.out.println(error);
            }
        }

        //To print in the console
     public void get(String part){

            if(part.equalsIgnoreCase("ALL")){
                for (int s=0; s<myPart.length;s++)
                      {
                          System.out.println(myPart[i]);
                }
            }

        for(int q=0;q<myPart.length;q++){ //To print specific sections in the console

            if(myPart[q].contains(part)){
                System.out.println(myPart[q]);
                break;
            }
        }

    }
}
