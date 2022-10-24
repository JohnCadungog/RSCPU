/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rscpu2;

/**
 *
 * @author John
 */
public class ErrorChecking {
    
    private static boolean isError;
    private static String errorMessage;

    /**
     * @return the isError
     */
    public static boolean getIsError() {
        return isError;
    }

    /**
     * @param aIsError the isError to set
     */
    public static void setIsError(boolean aIsError) {
        isError = aIsError;
    }

    /**
     * @return the errorMessage
     */
    public static String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param aErrorMessage the errorMessage to set
     */
    public static void setErrorMessage(String aErrorMessage) {
        errorMessage = aErrorMessage;
    }
    
}
