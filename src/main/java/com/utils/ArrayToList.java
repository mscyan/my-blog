package com.utils;

public class ArrayToList {

    public static String printArray(Object[] args){
        if(args == null || args.length == 0){
            return "[No Args]";
        }
        String list = "[ ";
        for(int i=0;i<args.length;i++){
            list += (args[i] + ", ");
        }
        list+= " ]";
        return list;
    }
}
