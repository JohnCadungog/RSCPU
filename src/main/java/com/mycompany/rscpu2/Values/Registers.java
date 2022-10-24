/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rscpu2.Values;

/**
 *
 * @author John
 */
public class Registers {

    private static int ac;
    private static int r;
    private static int ir;
    private static int ar;
    private static int pc;
    private static int tr;
    private static int flag;
    private static int startAddress;
    private static int z;
    private static int jumpAddress;
    private static String label;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getIr() {
        return ir;
    }

    public void setIr(int ir) {
        this.ir = ir;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public int getStartAddress() {
        return startAddress;
    }

    //display registers in rscpu view systems
    public String displayRegisters() {
        String displayReg = ("R: " + Integer.toHexString(r) + "\n" + "AC: " + Integer.toHexString(ac) + "\n" + "IR: " + Integer.toHexString(ir) + "\n" + "AR: " + Integer.toHexString(ar) + "\n" + "PC: " + Integer.toHexString(pc) + "\n" + "TR: " + Integer.toHexString(tr) +"\n"+ "Flag:" + Integer.toHexString(flag)+ "\n" + "Z:"+Integer.toHexString(z));
        return displayReg;
    }

    /**
     * @return the jumpAddress
     */
    public static int getJumpAddress() {
        return jumpAddress;
    }

    /**
     * @param aJumpAddress the jumpAddress to set
     */
    public static void setJumpAddress(int aJumpAddress) {
        jumpAddress = aJumpAddress;
    }

    /**
     * @return the label
     */
    public static String getLabel() {
        return label;
    }

    /**
     * @param aLabel the label to set
     */
    public static void setLabel(String aLabel) {
        label = aLabel;
    }

}
