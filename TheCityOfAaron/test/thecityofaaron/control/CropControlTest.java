/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thecityofaaron.control;

import org.junit.Test;
import static org.junit.Assert.*;
import thecityofaaron.model.CropData;


/**
 *
 * @author Familia Galindo
 */
public class CropControlTest {
    
    public CropControlTest() {
    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
        
        // Test 1 for sell land
        System.out.println("sellLand Test1");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        int toSell = 10;
        int landCost = 15;
        int expResult = 2790;
        int result = CropControl.sellLand(landCost, toSell, theCrops);
        assertEquals(expResult, result);

    }

    /**
     * Test of setOffering method, of class CropControl.
     * Roger Pollard
     */
    
    
    @Test
    public void testSetOffering() {
        // Test Case 1
        System.out.println("setOffering Test Valid");
        int offering = 10;
        int expResult = 10;
        int result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
        
        System.out.println("setOffering Test Invalid");
        offering = -10;
        expResult = -1;
        result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
        
        System.out.println("setOffering Test Invalid");
        offering = 200;
        expResult = -1;
        result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
        
        System.out.println("setOffering Test Boundary");
        offering = 0;
        expResult = 0;
        result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
        
        System.out.println("setOffering Test Boundary");
        offering = 100;
        expResult = 100;
        result = CropControl.setOffering(offering);
        assertEquals(expResult, result);
    }
    /**
     * Test of setOffering method, of class CropControl.
     * @author Joe G
     */
    @Test
    public void testPlantCrop() {
     // Test Case 1
     System.out.println("PlantCrop Test 1");
     CropData theCrops = new CropData();
     theCrops.setWheatInStore(500);
     theCrops.setAcresOwned(1000);
     int ToPlant = 400;
     int expResult = 300;
     int result = CropControl.plantCrop(ToPlant, theCrops);
     assertEquals(expResult, result);
    
     // Test Case 2
     System.out.println("PlantCrop Test 2");
     theCrops.setWheatInStore(500);
     theCrops.setAcresOwned(1000);
     ToPlant = 1100;
     expResult = -1;
     result  = CropControl.plantCrop(ToPlant, theCrops);
     assertEquals(expResult,result);
    
     //Test Case 3
     System.out.println("PlantCrop Test 3");
     theCrops.setWheatInStore(500);
     theCrops.setAcresOwned(1000);
     ToPlant = 1200;
     expResult = -1;
     result  = CropControl.plantCrop(ToPlant, theCrops);
     assertEquals(expResult,result);
     //Test Case 4
     System.out.println("PlantCrop Test 4");
     theCrops.setWheatInStore(500);
     theCrops.setAcresOwned(1000);
     ToPlant = 0;
     expResult = 500;
     result  = CropControl.plantCrop(ToPlant, theCrops);
     assertEquals(expResult,result);
     //Test Case 5
     System.out.println("PlantCrop Test 5");
     theCrops.setWheatInStore(500);
     theCrops.setAcresOwned(1000);
     ToPlant = 1000;
     expResult = 0;
     result  = CropControl.plantCrop(ToPlant, theCrops);
     assertEquals(expResult,result);
    }
}
