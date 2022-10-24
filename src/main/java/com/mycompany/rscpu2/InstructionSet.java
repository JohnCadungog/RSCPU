/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rscpu2;

import com.mycompany.rscpu2.Values.MemoryAddress;
import com.mycompany.rscpu2.Values.Registers;

/**
 *
 * @author John
 */
public class InstructionSet {

    MemoryAddress memAdd = new MemoryAddress();
    Registers reg = new Registers();

    //AC = AC + R      : Adds AC and R, stores data in AC
    public void add(int ac, int r, int startAddress) {
        int opCodeValue = 8;                                //instruction code value
        memAdd.memoryAddress(startAddress, opCodeValue);    //
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode, 0);
        int nextAddressCode = startAddress+2;
        
        ac = ac + r;
        reg.setAc(ac);
        if (ac < 1){
            reg.setFlag(1);
            
        }else{
            reg.setFlag(0);
        }
        
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
       
    }

    // AC = AC - R 
    public void sub(int ac, int r, int startAddress) {
        int opCodeValue = 9;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        int temp;
        temp = ac - r;
        if (temp<0){
            temp = 256+temp;
        }
        ac = temp;
        reg.setAc(ac);
        
        if (ac < 1 ){
            reg.setFlag(1);
            
        }else{
            reg.setFlag(0);
        }
        
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);

    }
    
    public void exp(int ac, int r, int startAddress){
        int opCodeValue=11;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        
        ac = (int) Math.pow(ac,r);
        reg.setAc(ac);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    
    public void not(int z, int startAddress){
        int opCodeValue=10;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        if(z==1){
            reg.setZ(0);
        }
        else {
            reg.setZ(1);
        }
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    
    public void jump (int startAddress){
        int opCodeValue= 32;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
        
        
    }
    public void jpos(int startAddress){
        int opCodeValue= 33;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    public void jneg(int startAddress){
        int opCodeValue= 34;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    
    public void mult(int ac, int r, int startAddress){
        int opCodeValue=12;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        
        ac = ac*r;
        reg.setAc(ac);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    public void incr(int ac, int startAddress){
        int opCodeValue=63;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        
        ac = ac+1;
        reg.setAc(ac);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
        
    }
    

    // AC = [m]        :Gets data from memory location and stores it in AC  :
     public void load(int address, int startAddress) {
        int ac;
        int opCodeValue = 1;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress + 1;
        memAdd.memoryAddress(addressCode, address);
        int memAddress = memAdd.getMemoryAddress(address);
      
        ac = memAddress;

        reg.setAc(ac);
        int nextAddressCode = startAddress + 2;
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);

    }

    // [m] = AC      :Data from the AC is stored onto a specified memory location
    public void save(int address, int startAddress) {
        int opCodeValue=2;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress + 1;
        memAdd.memoryAddress(addressCode, address);
        int ac = reg.getAc();
        memAdd.memoryAddress(address, ac);
        int nextAddressCode = startAddress + 2;
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }

    // AC = R        :Copies data from the general purpose register (R) to the AC
    public void toAc(int r, int startAddress) {
        int opCodeValue = 4;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        int ac = r;
        reg.setAc(ac);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }

    // R=AC         :Copies data from the AC to R
    public void tor(int ac, int startAddress) {
          int opCodeValue = 5;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(addressCode,0);
        int nextAddressCode = startAddress+2;
        int registers = ac;
        reg.setR(registers);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    
    public void rset (int startAddress){
        int opCodeValue = 12;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(startAddress, 0);
        int nextAddressCode = (startAddress+2);
        reg.setFlag(0);
        reg.setAc(0);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
        
    }
     public void comp(int startAddress){
       
        int opCodeValue = 16;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(startAddress, 0);
        int nextAddressCode = (startAddress + 2);
       
        if (reg.getR() > reg.getAc() ){
            reg.setFlag(1);
        }
        
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
        
    }
     public void equa(int startAddress){
         int opCodeValue = 17;
        memAdd.memoryAddress(startAddress, opCodeValue);
        int addressCode = startAddress+1;
        memAdd.memoryAddress(startAddress, 0);
        int nextAddressCode = (startAddress + 2);
        
        if ( reg.getR() != reg.getAc()){
            reg.setFlag(1);
        }
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
     }
    

    // value initialization 
    // db 27
    // inserts 27 in a memoryAddress
    public void db(int memoryLocation, int value) {
        int nextAddressCode = memoryLocation + 1;
        memAdd.memoryAddress(memoryLocation, value);
        reg.setStartAddress(nextAddressCode);
        reg.setAr(nextAddressCode);
        reg.setIr(nextAddressCode);
    }
    
    public void org(int startAddress){
        reg.setStartAddress(startAddress);
        reg.setAr(startAddress);
        reg.setIr(startAddress);
    }
    
   
    

}
