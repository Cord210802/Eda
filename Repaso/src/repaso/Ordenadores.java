/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

import java.util.Random;

public class Ordenadores <T extends Comparable<T>>{
    
    int contq;
    int contm;
    public Ordenadores() {
        contq = 0;
        contm = 0;
    }
    
    public <T> void rnd(T arr[], int n){
        T temp [] = (T[]) new Comparable[n];
        int cont = 0;
        Random random = new Random();
        
        while(cont != n){
            int randomNum = random.nextInt(0, n+1);
            while(temp[randomNum%n]!= null){
                randomNum++;
            }
            temp[randomNum%n] = arr[cont];
            cont++;
        }
        for (int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
    }
    public <T> void swap(T arr[], int i, int j){
        T dato = arr[i];
        
        arr[i] = arr[j];
        arr[j] = dato;
    }
    
    public <T extends Comparable <T>> int odrdena(T arr[], int n, int cont){
        for (int i = 0; i < n; i++){
            int minimo = i;
            for (int j = i; j<n; j++){
                cont ++;
                if (arr[j].compareTo(arr[minimo]) < 0){
                    minimo = j;
                }
            }
            swap(arr, i, minimo);
        }
        return cont;
    }
    
    public <T extends Comparable <T>> int odrdenaAlReves(T arr[], int n, int cont){
        for (int i = 0; i < n; i++){
            int minimo = i;
            for (int j = i; j<n; j++){
                cont ++;
                if ((arr[j].compareTo(arr[minimo])*-1) < 0){
                    minimo = j;
                }
            }
            swap(arr, i, minimo);
        }
        return cont;
    }
    
    public <T extends Comparable <T>> int insertionSort(T arr[], int n, int cont){
        int j;
        for (int i = 1; i<n; i++){
            j = i;
            cont++;
            while(j>=1 && arr[j].compareTo(arr[j-1]) < 0){
                swap(arr, j, j-1);
                j--;
                cont++;
            }
            cont++;
        }
        return cont;
    }
    
    public <T extends Comparable <T>> int bubbleSort(T arr[], int n, int cont){
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n -i - 1; j++){
                cont++;
                if (arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr, j , j+1);
                }
            }
        }
        return cont;
    }
    
    //Funcion particion le digo de donde a donde va, pone los mas chicos de ese arreglo a la izquierda
    public <T extends Comparable<T>> int pivote(T arr[], int min, int max){
        int i = min + 1; 
        int j = max;
        int pos = min;
        int min1 = min;
        
        while (i<=j){
            this.contq++;
            if (arr[i].compareTo(arr[min1]) >= 0){
                swap(arr, i, j);
                j--;
            }
            else{
                swap(arr, i, min1);
                i++;
                pos ++;
                min1++;
            }
            System.out.println(toString(arr, max + 1));
            System.out.println(pos);
        }
        return pos;
    }

    public String toString(T [] arr, int n) {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i<n; i++){
            cad.append(arr[i]+ " ");
        }
        return cad.toString();
    }

    private <T extends Comparable<T>> void quickSort(T arr[], int min, int max){
        if (min >= max){
            return;
        }
        else{
            int piv = this.pivote(arr, min, max);
            quickSort(arr, min, piv-1);
            quickSort(arr, piv+1, max);
        }
    }

    public <T extends Comparable<T>> void quickSort(T arr[], int n){
        quickSort(arr, 0, n-1);
        System.out.println("Contador quick sort: " + contq);
        this.contq = 0;
    }
    
    public static <T> String toString(T[] arr, int max){
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i< max; i++){
            cad.append(arr[i] + " ");
        }
        return cad.toString();
    }
    
    public <T extends Comparable<T>> void mez(T arr [], int inicio, int fin, int mitad){
        int i = inicio;
        int j = mitad + 1;
        int cont = 0;
        T temp [] = (T[]) new Comparable [fin-inicio + 1];
        int cont1 = 0;
        
        while (i<= mitad && j <= fin){
            this.contm++;
            if (arr[i].compareTo(arr[j])<=0){
                temp[cont] = arr[i];
                i++;
                cont++;
            }
            else{
                temp[cont] = arr[j];
                j++;
                cont++;
            }
        }
        if (i > mitad && j <= fin){
            for (int x = j; x<=fin; x++){
                temp[cont] = arr[x];
                cont++;
            }
        }
        else{
            if (i<= mitad && j>fin){
                for (int y = i; y<= mitad; y++){
                    temp[cont] = arr[y];
                    cont++;
                }
            }
        }
        for (int p = inicio; p <= fin; p++){
            arr[p] = temp[cont1];
            cont1++;
        }
    }
    
    public <T extends Comparable <T>> void mergeSort(T arr[], int inicio, int fin){
        if (fin-inicio >= 1){
            int mitad = (fin+inicio)/2;
            mergeSort(arr, inicio, mitad);
            mergeSort(arr, mitad+1, fin);
            mez(arr, inicio, fin, mitad);
        }
    }
    
    public <T extends Comparable <T>> void mergeSort(T arr[], int n){
        mergeSort(arr, 0, n-1);
        System.out.println("Contador merge: " + contm);
        this.contm = 0;
    }
}
