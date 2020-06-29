import edu.duke.URLResource;
/**
 * Write a description of class Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    
     public void youtubeFinder(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.words()){
            String address = s.toLowerCase();
            int indexYoutube = address.indexOf("youtube.com");
            if (indexYoutube != -1){
                int indexAddressStart = address.lastIndexOf("\"", indexYoutube);
                int indexAddressEnd = address.indexOf("\"", indexAddressStart + 1);
                System.out.println(s.substring(indexAddressStart + 1, indexAddressEnd));
            }
        }
    }
     
}
