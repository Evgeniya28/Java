
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
        return "";
    }
        int endIndex = dna.indexOf("TAA",startIndex+3);
        if (endIndex == -1){
        return "";
    }
        String gene = dna.substring(startIndex, endIndex+3);
     if ((endIndex+3-startIndex)%3==0){
         return gene;
    }
    return "";
}

public void testSimpleGene(){
    String dna ="TAATAA";
    String gene = findSimpleGene(dna);
    System.out.println("Gene: "+ gene);
    
    String dna2 ="ATGAAAAAAA";
    String gene2 = findSimpleGene(dna2);
    System.out.println("Gene: "+ gene2);
    
    String dna3 ="ATGAAAAATAA";
    String gene3 = findSimpleGene(dna3);
    System.out.println("Gene: "+ gene3);
    
    String dna4 ="AAATGCCCTAACTAGATTAAGAAACC";
    String gene4 = findSimpleGene(dna4);
    System.out.println("Gene: "+ gene4);
}
}
