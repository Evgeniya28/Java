
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        if (dna == dna.toUpperCase()) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }
        else if (dna == dna.toLowerCase()) {          
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
        return "";
        }   
        int endIndex = dna.indexOf(stopCodon,startIndex+3);
        if (endIndex == -1){
        return "";
        }
        String gene = dna.substring(startIndex, endIndex+3);
     if ((endIndex+3-startIndex)%3==0){
         
        if (dna == dna.toUpperCase()) {
            gene = gene.toUpperCase();
        }
        else if (dna == dna.toLowerCase()) {          
            gene = gene.toLowerCase();
        }
        return gene;
    }
    return "";
}

public void testSimpleGene(){
    String dna ="TAATAA";
    String startCodon = "ATG";
    String stopCodon = "TAA";

    
    String gene = findSimpleGene(dna, startCodon, stopCodon);
    System.out.println("Gene: "+ gene);
    
    String dna2 ="ATGAAAAAAA";
    String gene2 = findSimpleGene(dna2, startCodon, stopCodon);
    System.out.println("Gene: "+ gene2);
    
    String dna3 ="ATGAAAAATAA";
    String gene3 = findSimpleGene(dna3, startCodon, stopCodon);
    System.out.println("Gene: "+ gene3);
    
        
    String dna4 ="atgaaaaaataa";
    String gene4 = findSimpleGene(dna4, startCodon, stopCodon);    
    System.out.println("Gene: "+ gene4);
}
//startIndex = dna.toLowerCase().indexOf("atg", startIndex);
}
