import java.util.Arrays;
/**
 *
 * @author Amantha - https://www.linkedin.com/in/amanthaa/
 */
public class PalindromeDates {
    
    static final int STARTINGYEAR=0000;
    static final int ENDINGYEAR=9999;
    
    public static void main(String[] args) {
        
        
        
        int year,month, date;
        int dateArray[];
        boolean flag;
        
		System.out.println("    Date   -->       Array Format\n");
		
        for(year=STARTINGYEAR;year<=ENDINGYEAR;year++){
            for(month=01;month<=12;month++){
                for(date=1;date<=31;date++){
                    
                    if(checkValidDate(year,date,month)){
                        dateArray=createDateArray(date, month, year);
                        flag = checkPalindrome(dateArray);
                        if(flag){
                            System.out.print(year+"."+month+"."+date+"  -->  ");
                            System.out.println(Arrays.toString(dateArray));
                        }
                    }
                }
            }   
        }   
    }
    
    public static int [] createDateArray(int date,int month, int year){ //Inserting the whole date to an array
        
        int dateArray[] = new int[8];
        
        dateArray[0] = year/1000;
        year=year%1000;
        dateArray[1]=year/100;
        year=year%100;
        dateArray[2]=year/10;
        dateArray[3]=year%10;
        
        dateArray[4]=month/10;
        dateArray[5]=month%10;
        
        dateArray[6]=date/10;
        dateArray[7]=date%10;
        
        return dateArray;  
    }
    
    public static boolean checkPalindrome(int dateArray[]){
        
        for(int i=0;i<=3;i++){
            if(dateArray[i]==dateArray[7-i]) {
            }else{
                return false;
            }
        }
        return true;   
    }
    
    public static boolean checkValidDate(int year,int month,int date){
        
        if(month==2 && date==30)
            return false;
        
        if((month==2 || month==4 || month==6 || month==9 || month==11)&&(date==31)){
            return false;
        }
        
        if((month==2)&&(date==29))
            return(checkLeapYear(year));
        
        return true;
    }
    
    public static boolean checkLeapYear(int year){
        
        if(year % 4 == 0){
            if( year % 100 == 0){
                if ( year % 400 == 0)
                    return true;
                else
                    return false;
            }
            else
                return true;
        }
        else {
            return false;
        }
    }
}