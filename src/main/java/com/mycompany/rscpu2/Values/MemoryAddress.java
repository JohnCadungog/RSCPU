/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rscpu2.Values;

/**
 *
 * @author John
 */
public class MemoryAddress {

    private static int[] memoryAddress = new int[256];

    // sets memory address of the instruction sets and the datas
    public void memoryAddress(int setLoc, int setMem) {

        memoryAddress[setLoc] = setMem;
        // memoryAddress[255]=10;
        
    }

    public int getMemoryAddress(int locator) {
        int memoryValue = memoryAddress[locator];
        return memoryValue;
    }

    // prints the memory Addresses of the instruction sets and the datas
    public String printAddress() {

        String returnValue = "";

        for (int x = 0; x < 256; x++) {
            returnValue += "\n";
            int memAddress = memoryAddress[x];
            String hex = Integer.toHexString(memAddress);
            if (hex.length()<2){
                hex = "0" + hex;
            }
            String memory = (x + ": " + hex);

            returnValue += memory;

        }
        returnValue += "\n";

        return returnValue;
    }

    // clears all the memory addresses
    public void clearAddress() {
        for (int x = 0; x < 256; x++) {
            memoryAddress[x] = 0;
        }
        Registers reg = new Registers();
        reg.setAc(0);
        reg.setR(0);
        reg.setIr(0);
        reg.setAr(0);
        reg.setZ(0);
        reg.setPc(0);
        
    }

}
