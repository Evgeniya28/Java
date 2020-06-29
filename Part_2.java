
/**
 * Write a description of class Part_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part_2 {

public int howMany(String stringa,
                   String stringb){
int currIndex = stringb.indexOf(stringa);
int number = 0; 

while(currIndex != -1){
    String current_text = stringb.substring(currIndex, currIndex + stringa.length());
    if (current_text.isEmpty()){
        break;
    }
    number=number+1;
    currIndex = stringb.indexOf(stringa, currIndex + stringa.length());
    
}
return number;
}

public void testHowMany(){
String stringb = "жежежеженяффф";
String stringa = "женя";
int number = howMany(stringa, stringb);
System.out.println(number);
}                   
    
}
