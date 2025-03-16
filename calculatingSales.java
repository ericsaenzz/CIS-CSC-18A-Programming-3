import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class calculatingSales{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double total = 0.0;
        int productnum = 0;

        //time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM-dd-yyyy , (HH:mm:ss a)");
        String Date_and_time = now.format(formatter);

        boolean userInp = false;

        System.out.println(">> WELCOME to Eric's ECOM Net Sales Calculator\n");
        System.out.println(">-- INVENTORY --<\n> Item (1) , $2.98\n> Item (2) , $4.50\n> Item (3) , $9.98\n> Item (4) , $4.49\n> Item (5) , $6.87\n");
        
        //Error handling using catch
        while(!userInp){
            System.out.println("\nPlease Enter the Product Number (1-5)\n(press (0) to finish): ");
            try{
                productnum = input.nextInt(); 
                userInp = true;
            }catch(InputMismatchException e){
                System.out.println("\n!! ERROR. Please enter a valid number (1 - 5) from the selection !!");
                input.nextLine();
            }
        }

        
        while(productnum!= 0){
            //error handling with catch
            if(productnum >= 1 && productnum <= 5){
                int quant = 0;

                userInp = false;
                while(!userInp){
                    System.out.println("\n>> Enter the Quantity Sold: ");
                    try{
                        quant = input.nextInt();
                        if(quant >= 0){
                            userInp = true;
                        }else{
                            System.out.println("\n!! Error. Please enter only from the Selection !!\n");
                        }
                    }catch(InputMismatchException e){
                        System.out.println("\nERROR. Please Enter a valid integer\n");
                        input.nextLine();
                    }

                }
                //Product 1 $2.98
                //product 2 $4.50
                //product 3, $9.98
                //product 4 $4.49 
                //product 5 $6.87
                switch(productnum){
                    case 1:
                        total += 2.98 * quant;
                        System.out.println("\n> System Updated.");
                        break;
                    case 2:
                        total += 4.50 * quant;
                        System.out.println("\n> System Updated.");
                        break;
                    case 3: 
                        total += 9.98 * quant;
                        System.out.println("\n> System Updated.");
                        break;
                    case 4:
                        total += 4.49 * quant;
                        System.out.println("\n> System Updated.");
                        break;
                    case 5:
                        total += 6.87 * quant;
                        System.out.println("\n> System Updated.");
                        break;
                }
            } else {
                System.out.println("\n!! Error. Invalid Product Number !!\n> Select a number from (1 - 5) <\n");
            }

            userInp = false;
            while(!userInp){
                System.out.println(">> Please Enter another product number from the selection.\nIf you are done press (0) to CALCULATE TOTAL NET: ");
                try{
                        productnum = input.nextInt();
                        userInp = true;

                }catch(InputMismatchException e){
                    System.out.println("\nERROR. Please Enter a valid integer\n");
                    input.nextLine();
                }

            }
        }
        System.out.printf("\n\n>> Total Net Value of all the products sold: $%.2f%n",total);
        System.out.println("\nThank you for using the Net Sales Calculation application.");
        System.out.print("Time of Calculation is: " + Date_and_time);
           
        input.close();
        System.exit(0);
    }
}