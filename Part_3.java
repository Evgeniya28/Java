
/**
 * Write a description of class Part_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part_3 {

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
    printAllGenes(dna);
}

public void test(){
    testOn("AATGCTAACTAGCTGACTAAT");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
}

public int CountGenes(String dna){

    int startIndex = 0;
    int count = 0;
    
    while (true){
    String currentGene = findGene(dna, startIndex);
    
    if (currentGene.isEmpty()){
        break;
    }
    count = count + 1;
    
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    }
    return count;
}

public void testCountGenes(){
String dna1 = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
String dna2 = "";
String dna3 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
int count1 = CountGenes(dna1);
int count2 = CountGenes(dna2);
int count3 = CountGenes(dna3);
System.out.println(count1);
System.out.println(count2);
System.out.println(count3);
}
}
