import edu.duke.StorageResource;
import java.lang.String;
/**
 * Write a description of class Part_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part_1 {
    
    
public int findStopCodon(String dna,
                        int startIndex,
                        String stopCodon){
    
    int currIndex = dna.indexOf(stopCodon,startIndex+3);
    while (currIndex != -1){
        int diff = currIndex - startIndex;
        if (diff % 3 == 0){
            return currIndex;
        }
        else {
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
    }
    return -1; 
    
}

public void testFindCodon(){
    String dna = "aaaaaaaaaTAAaaaaaaaaaTAAaa";
    int dex = findStopCodon(dna,0,"TAA");
    if (dex != 9) System.out.println("error on 9");
    dex = findStopCodon(dna, 9, "TAA");
    if (dex != 21) System.out.println("error on 21");
    dex = findStopCodon(dna, 1, "TAA");
    if (dex != -1) System.out.println("error on 26");
    dex = findStopCodon(dna, 0, "TAG");
    if (dex != -1) System.out.println("error on 26 TAG");
    System.out.println("test finished");
}

public String findGene(String dna, int where){

    int startIndex = dna.indexOf("ATG", where);
    
    if(startIndex == -1){
    return "";
    }
    
    int taaIndex = findStopCodon(dna,startIndex, "TAA");
    int tagIndex = findStopCodon(dna,startIndex, "TAG");
    int tgaIndex = findStopCodon(dna,startIndex, "TGA");
    /*
    int minStopIndexNach = Math.min(taaIndex,tagIndex);
    int minStopIndex = Math.min(minStopIndexNach,tgaIndex);
    */
    int minStopIndex = 0;
    
    if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
        minStopIndex = tgaIndex;
    }
    else {
        minStopIndex = taaIndex;
    }
    
    
    if ((minStopIndex == -1) || (tagIndex != -1 && tagIndex < minStopIndex)){
        minStopIndex = tagIndex;
    }
    
    if (minStopIndex == -1){
        return "";
    }
    /*
    if (minStopIndex == dna.length()){
        return "";
    }
    */
    return dna.substring(startIndex, minStopIndex+3);
    }
     

public void testFindGene(){
    String dna = "ATGCCCGGGAAATAACC";
    String gene = findGene(dna, 1);
    
    if (! gene.equals("ATGCCCGGGAAATAA")){
        System.out.println("Error");
    }
    System.out.println("Test finished");
  
}

public void printAllGenes (String dna){
    int startIndex = 0;
    
    while (true){
    String currentGene = findGene(dna, startIndex);
    
    if (currentGene.isEmpty()){
        break;
    }
    System.out.println(currentGene);
    
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
} 

public void testOn(String dna){
    System.out.println("Testing printAllGenes on" + dna);
    StorageResource genes = getAllGenes(dna);
    
    for (String g: genes.data()){
    System.out.println(g);
    }
}

public void test(){
    testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
}
    
public StorageResource getAllGenes (String dna){
    
    StorageResource geneList = new StorageResource();
    int startIndex = 0;
    
    while (true){
    String currentGene = findGene(dna, startIndex);
    
    if (currentGene.isEmpty()){
        break;
    }
    geneList.add(currentGene);
    
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
    return geneList;
} 

public float cgRatio (String dna){
    String gene = findGene(dna,1);
    int currIndex1 = gene.indexOf("C");
    int currIndex2 = gene.indexOf("G");
    int numberC = 0;
    int numberG = 0;

while ((currIndex1 != -1)|(currIndex2 != -1)){
      
    numberC=numberC+1;
    currIndex1 = gene.indexOf("C", currIndex1 + 1);
    
}

while (currIndex2 != -1){
      
    numberG=numberG+1;
    currIndex2 = gene.indexOf("G", currIndex2 + 1);
    
}
float number = numberC + numberG;

return number/gene.length();         
        
}

public void testRatio(){
    String dna = "ATGCCATAG";
    float ratio = cgRatio (dna);
    System.out.println(ratio);
   
}
}
