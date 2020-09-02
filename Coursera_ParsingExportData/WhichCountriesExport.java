
/**
 * 1. Tester that will create your CSVParser and call each of the methods below in parts 2, 3, 4, and 5
 * 
 * 2. This method named countryInfo returns a string of information about the country or returns “NOT FOUND” 
 * if there is no information about the country. The format of the string returned is the country, followed by “: “, 
 * followed by a list of the countries’ exports, followed by “: “, followed by the countries export value.
 * 
 * 3. This method named listExportersTwoProducts prints the names of all the countries that have 
 * both exportItem1 and exportItem2 as export items.
 * 
 * 4. The method named numberOfExporters returns the number of countries that export exportItem. 
 * 
 * 5. The method named bigExporters prints the names of countries and their Value amount for all countries 
 * whose Value (dollars) string is longer than the amount string. 
 * 
 * 
 * By Evgeniya Kuksina 
 * version 1 (26.08.2020)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {

    public void tester (){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        parser = fr.getCSVParser();
        
        
        //System.out.println(countryInfo (parser, "Nauru"));
        bigExporters (parser, "$999,999,999,999");
    }
    
    public String countryInfo (CSVParser parser, String country){
        
        String info = "";
        
        for (CSVRecord record: parser){
            
            String c = record.get("Country");
            
            if (c.contains(country)){
            info = record.get("Country") + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            break;
            }
            else info = "Not found"; 
            }
            return info;
                     
    }
    
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
        
                        
        for (CSVRecord record: parser){
            
            String export = record.get("Exports");
                        if ((export.contains(exportItem1))&&(export.contains(exportItem2))){
                System.out.println(record.get("Country"));
            }
            
        }
        
    }
    
    public int numberOfExporters (CSVParser parser, String exportItem){
        
        int number = 0;
    
        for (CSVRecord record: parser){
        
            String export = record.get("Exports");
            if (export.contains(exportItem)){
            number++; 
            }
            
        }
        
        return number;
        
    }
    
    public void bigExporters (CSVParser parser, String amount){
    
        for (CSVRecord record: parser){
        
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
            
            System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
            
            }
            
        }
        
    }
    
    
   
    
}
