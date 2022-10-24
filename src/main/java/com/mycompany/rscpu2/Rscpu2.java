/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rscpu2;

import com.mycompany.rscpu2.Jframes.RscpuMenuJframe;
import com.mycompany.rscpu2.Values.MemoryAddress;
import com.mycompany.rscpu2.Values.Registers;


/**
 *
 * @author John
 */
public class Rscpu2 {
   
    public static void main(String[] args) {
        RscpuMenuJframe gui = new RscpuMenuJframe();
        gui.show();

        Scanner scan = new Scanner();
        MemoryAddress memAdd = new MemoryAddress();
        
        Registers reg = new Registers();
        InstructionSet inst = new InstructionSet();

        //memAdd.memoryAddress(10, 5); //set memory address
        //memAdd.memoryAddress(11, 7);  // set memory address
       // reg.setAc(5);              // set ac to 5
       // reg.setR(2);                 //set r to 2

        //   inst.add(reg.getAc(), reg.getR());    //add ac and 4 then assign the result to ac
        System.out.println(reg.getAc());      // print console the value of ac : 7
        
        
        System.out.println("viewSystems");
        System.out.println(reg.displayRegisters());;
        
        System.out.println("\nMemory Address");
        System.out.println(memAdd.printAddress());
        
        
        
        
        
        
        /*String printText = scan.printTextScan();
          String[] arString = printText.split("\n");
          System.out.println(printText);
          System.out.println("Array below");
          System.out.println(Arrays.toString(arString));
          System.out.println("Array Index 0 :" + arString[0]);
          String[] strCommand = arString[0].split(" ");
          System.out.println("StrCommand 1: " + strCommand[0]);
          System.out.println("StrAddress 1: " + strCommand[2]);
  
            System.out.println(reg.displayRegisters());*/
    }
}