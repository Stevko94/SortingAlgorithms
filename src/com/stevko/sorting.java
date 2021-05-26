package com.stevko;

public class sorting {
    public static void swap(int[] list,int iIndex,int jIndex){
        int temp=list[iIndex];
        list[iIndex]=list[jIndex];
        list[jIndex]=temp;
    }
    public static void swap(String[] list,int iIndex,int jIndex){
        String temp=list[iIndex];
        list[iIndex]=list[jIndex];
        list[jIndex]=temp;
    }
    public static void selcetionSort(int[] listtosort){
        for(int i=0;i<listtosort.length;i++){
            for(int j=i+1;j<listtosort.length;j++){
                if(listtosort[i]>listtosort[j])
                    swap(listtosort,i,j);
                else{
                    break;
                }
            }
        }
    }
    public static void bubleSort(int[] listtosort){
        for(int i=listtosort.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(listtosort[j]>listtosort[j+1])
                    swap(listtosort,j,j+1);
                else{
                    break;
                }
            }
        }
    }
    public static void insertionSort(int[] listtosort){
        for(int i=0;i<listtosort.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(listtosort[j]<listtosort[j-1]){
                    swap(listtosort,i,j);
                }else{
                    break;
                }
            }
        }
    }
    public static void insertionSort(int[] listtosort,int increment){
        for(int i=0;i+increment<listtosort.length-1;i=i+1){
            for(int j=i+increment;j-increment>=0;j=j-increment){
                if(listtosort[j]<listtosort[j-increment]){
                    swap(listtosort,i,j);
                }else{
                    break;
                }
            }
        }
    }
    public static void shellSort(int[] listtosort){
        int increment=listtosort.length/2;
        while(increment>=1){
            insertionSort(listtosort,increment);
            increment=increment/2;
        }
    }
    public static void split(String[] listtosort,String[] listfirstpart,String[] listsecondpart){
        int secondpartstartindex=listfirstpart.length;
        for(int index=0;index<listtosort.length;index++){
            if(index<secondpartstartindex){
            listfirstpart[index]=listtosort[index];
            }else{
                listsecondpart[index-secondpartstartindex]=listtosort[index];
            }
        }
    }
    public static void merge(String[] listtosort,String[] listfirstpart,String[] listsecondpart){

        int index=0;
        int firsthalf=0;
        int secondhalf=0;
        while(firsthalf<listfirstpart.length&secondhalf<listfirstpart.length){
            if(listfirstpart[firsthalf].compareTo(listsecondpart[secondhalf])<0){
                listtosort[index]=listfirstpart[firsthalf];
                firsthalf++;
            }else if(secondhalf<listsecondpart.length){
                listtosort[index]=listsecondpart[secondhalf];
                secondhalf++;
            }
            index++;
        }
    }
    public static void mergeSort(String[] listtosort){
        if(listtosort.length==1)
            return;
        int midindex =listtosort.length/2+ listtosort.length%2;
        String[] listfirsthalf=new String[midindex];
        String[] listsecondhalf=new String[listtosort.length-midindex];
        split(listtosort,listfirsthalf,listsecondhalf);
        mergeSort(listfirsthalf);
        mergeSort(listsecondhalf);
        merge(listtosort,listfirsthalf,listsecondhalf);
    }
    public static int partition(String[] listtosort,int low,int high){
        String pivot =listtosort[low];
        int l=low;
        int h=high;
        while(l<h){
            while(listtosort[l].compareTo(pivot)<=0&&l<h){
                l++;
            }
            while(listtosort[h].compareTo(pivot)>0){
                h--;
            }
            if(l<h)
                swap(listtosort,l,h);
        }
        swap(listtosort,low,high);
    return h;
    }
    public static void quickSort(String[] listtosort,int low,int high){
        if(low>=high)
            return;
        int pivotIndex= partition(listtosort,low,high);
        quickSort(listtosort,low,pivotIndex-1);
        quickSort(listtosort,pivotIndex+1,high);
    }
}
