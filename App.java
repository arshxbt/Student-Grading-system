import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner keyboardInput = new Scanner(System.in);
        
        System.out.println("How many courses does this student take? ");
        int courses = keyboardInput.nextInt();

        double [] gradePer = new double[courses];
        
        
        int pace = 1;
        for(int i = 0; i < gradePer.length; i++){
            System.out.println("Enter Grade " + pace + ":");
            gradePer[i] = keyboardInput.nextInt();
            pace++;
        }
        double average = analyzeGrades(gradePer);
        String finalStatus = "";

        if (average >= 90){
            finalStatus = "Status: Honors";
        }
        if (average >= 50 && average <= 89){
            finalStatus = "Status: Pass";
        }
        if (average < 50){
            finalStatus = "Status: Fail";
        }
        System.out.println(finalStatus);
        
        System.out.println("Do you want to check if the student got a specific grade ? y/n");
        String ques = "";
        boolean found = true, searchAgain = false;
        
        do { 
            ques = keyboardInput.next();
            
        if (ques.equals("y")){
            int index = 0;
            System.out.println("Enter grade to find: ");
            double searchGrade = keyboardInput.nextDouble();
            for(int k = 0; k < gradePer.length; k++){
            if (searchGrade == gradePer[k]){
                    found = true;
                    index = k;    
                }
            }
            if (found){
                    System.out.println("Grade found at index " + index + "!");
            }
            else {
                System.out.println("Grade not found.");
            }
        }
        else if (!ques.equals("y") && !ques.equals("n"))  {
            System.out.println("Kindly enter y for yes");
        }
        else if (!ques.equals("n")){
            searchAgain = true;
        }
        } while (!ques.equals("y") && searchAgain);
    }
    public static double analyzeGrades(double [] input){
            double sum =0 ;
            for (double score : input){
                sum += score;
            }
            return sum / input.length;
    }
}
