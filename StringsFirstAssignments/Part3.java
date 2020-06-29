
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
 
    public boolean twoOccurence (String stringa, String stringb){
        
        int firstOccur = stringb.indexOf(stringa);
        int secondOccur = stringb.indexOf(stringa, firstOccur + stringa.length());
        
        if ((firstOccur == -1)|(secondOccur == -1)){
        return false;    
        }
            
    return true;
    }
    
    public void Testing(){
        boolean answer = twoOccurence("a","aa");
        boolean answer2 = twoOccurence("a","ab");
        boolean answer3 = twoOccurence("a","cc");
        
        System.out.println("answer = " + answer);
        System.out.println("answer2 = " + answer2);
        System.out.println("answer3 = " + answer3);
        
        String s1 = lastPart("an", "banana");
        String s2 = lastPart("forest", "zoo");
        
        System.out.println("laststring1 = " + s1);
        System.out.println("laststring2 = " + s2);
    }
    
    public String lastPart(String stringa, String stringb){
        
        int firstIndex = stringb.indexOf(stringa);
        
        if (firstIndex == -1){
            
            return stringb;
            
        }
        String lastPart = stringb.substring(firstIndex + stringa.length(), stringa.length());
        return lastPart;
    }
    
    
}

