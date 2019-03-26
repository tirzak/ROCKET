
import java.io.*;
/**
The code has one constructor to help create an array which stores all the results. Size of the array is to be declared during the object 
creation. Method t must be invoked before the part of the code and at the end of the code to measure execution time.
Method write writes the elements of the myPart array to predefined file. 

To use this
ROCKET variableName= new ROCKET(arraySize);

variableName.t("Segment Name", 1) //To start
code here
.
.
variableName.t("Segment Name", 2) //To stop
*/

public class ROCKET {
    private String[] myPart;

    ROCKET(int array) {
      myPart= new String[array];//To create an array according to the required sections

    } 

    private int i=0;
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
                FileWriter myWriter = new FileWriter("Test.csv");//File name
                BufferedWriter buffWrite = new BufferedWriter(myWriter);
                PrintWriter print = new PrintWriter(buffWrite);
               
               //Writes the value of the array to the file
                for (int ww = 0; ww < myPart.length; ww++) {
                    if (myPart[ww] != null)
                        print.write(myPart[ww]);
                    
                    print.write("\n");
                }
                print.close();                            
            } 
            //For errors
           catch (IOException e) {
            System.out.println("ERROR!");
        }
        }

        //To print in the console
     public void get(String part){

            if(part.equalsIgnoreCase("ALL")){
                for (int s=0; s<myPart.length;s++)
                      {
                          System.out.println(myPart[s]);
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
