/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rscpu2;

import com.mycompany.rscpu2.Values.Registers;
import java.util.Arrays;

/**
 *
 * @author John
 */
public class Scanner {
    
    InstructionSet inst;
    Registers reg;
    
    public Scanner() {
        this.inst = new InstructionSet();
        this.reg = new Registers();
    }

    //gets the text, transforms it to arrays and then checks if it mathces to the compiler's grammar
    public void getTextScan(String text) {
        String scannedText = text;
      
        String[] arrText = scannedText.split("\n");
        
        int arrayLast = arrText.length - 1; //number of the last array
        
       
        for (int x = 0 ; x <= arrayLast; x++) {
            
            String textArr = arrText[x];
            
            int index = textArr.indexOf(" "); //finds if there is spaces :-1 if there is no spaces
            
            // condition for instructionsets that needs address
            
            if(textArr.indexOf(":")>1){
                String Label = textArr;
                reg.setJumpAddress(x+1);
                
            }
            if (index > 0) {//if there is a space

                String[] strCommand = arrText[x].split(" "); //splits the scanned text(assembly language) into arrays when it has space
                
                String command = strCommand[0];
                int address = Integer.parseInt(strCommand[1]); // array strcommand to integer

                if (command.equalsIgnoreCase("load")) {
                    inst.load(address, reg.getStartAddress());     //address variable here is a memory address
                    System.out.println("nisud siya sa load hahahhahaha");
                }
                if (command.equalsIgnoreCase("save")) {
                    inst.save(address, reg.getStartAddress());
                    System.out.println("nisud siya sa save hahahhahaha");                    
                }
                
                if (command.equalsIgnoreCase("org")) {
                    reg.setStartAddress(address);
                    System.out.println("nisud siya sa org");
                }
                
                if (command.equalsIgnoreCase("db")) {
                    inst.db(reg.getStartAddress(), address);
                }
                if (command.equalsIgnoreCase("jump")){
                    x = address + 1;
                    inst.jump(reg.getStartAddress());
                }
                if (command.equalsIgnoreCase("jpos")){
                    if(reg.getZ()==1){
                        x = address + 1;
                    }
                    inst.jpos(reg.getStartAddress());
                }
                if(command.equalsIgnoreCase("jneg")){
                    if(reg.getZ()==0){
                        x = address +1;
                    }
                    inst.jneg(reg.getStartAddress());
                }
                    
                
                
                if(command.equalsIgnoreCase("end")){
                    
                }
               
            }
            // single operands
            if (textArr.equalsIgnoreCase("add")) {
                int ac = reg.getAc();
                int r = reg.getR();
                inst.add(reg.getAc(), reg.getR(), reg.getStartAddress());
                System.out.println("nisud siya sa add hahahhahaha");                
                
            }
            if (textArr.equalsIgnoreCase("sub")) {
                inst.sub(reg.getAc(), reg.getR(), reg.getStartAddress());
            }
            
            if(textArr.equalsIgnoreCase("exp")){
                inst.exp(reg.getAc(), reg.getR(), reg.getStartAddress());
            }
            if(textArr.equalsIgnoreCase("mult")){
                inst.mult(reg.getAc(), reg.getR(), reg.getStartAddress());
            }
            
            if (textArr.equalsIgnoreCase("toac")) {
                
                inst.toAc(reg.getR(), reg.getStartAddress());
            }
            if (textArr.equalsIgnoreCase("tor")) {
                inst.tor(reg.getAc(), reg.getStartAddress());
                System.out.println("nisud siya sa tor hahahhahaha");                
                
            }
            if (textArr.equalsIgnoreCase("comp")) {
                inst.comp(reg.getStartAddress());
            }
            
            if (textArr.equalsIgnoreCase("rset")) {
                inst.rset(reg.getStartAddress());
            }
            
            if (textArr.equalsIgnoreCase("equa")) {
                inst.equa(reg.getStartAddress());
            }
            if (textArr.equalsIgnoreCase("incr")){
                inst.incr(reg.getAc(), reg.getStartAddress());
            }
            if (textArr.equalsIgnoreCase("not")){
                inst.not(reg.getZ(), reg.getStartAddress());
            }
            
        }
        
    }
    
}
