public class Heap <T extends Comparable<T>>{
    T [] arr;
    int cont;

    public Heap() {
        this.arr = (T[]) new Comparable[10];
        this.cont = 0;
    }

    public T findMin(){
        T res = null;
        if (cont >0){
            res = arr[1];
        }
        return res;
    }

    public void inserta(T dato){
        Integer num;
        if(arr.length == cont+1){
            expande();
        }
        cont++;
        arr[cont] = dato;
        num = cont;
        while(num > 1 && arr[num].compareTo(arr[num>>1])<0){
            swap(num);
            num = num>>1;
        }
    }

    public void swap(int num){
        T dato = arr[num];
        T papa = arr[num>>1];
        arr[num] = papa;
        arr[num>>1] = dato;
    }

    public void swap(int num, int num2){
        T dato = arr[num];
        T papa = arr[num2];
        arr[num] = papa;
        arr[num2] = dato;
    }
    public void expande(){
        T[] masGrande = (T[]) new Comparable [arr.length * 2];

        for(int i = 0; i <= cont; i++){
            masGrande[i] = arr[i];
        }
        arr = masGrande;
    }

    public String toString(){
        StringBuilder cad = new StringBuilder();
        for (int i = 1; i<= cont; i++){
            cad.append(arr[i] +  " ");
        }
        return cad.toString();
    }

    public boolean estaVacio(){
        return cont < 1;
    }
    public T elimina(){
        T res;
        int papa = 1;
        int hi;
        int hd;
        int min;
        boolean termine = false;
        if(estaVacio()){
            throw new RuntimeException();
        }
        else{
            res = arr[1];
            arr[1] = arr[cont];
            arr[cont] = null;
            cont--;
            hi = papa<<1;
            hd = (papa<<1) +1;
            while(!termine){
                if(papa*2>cont){
                    termine = true;
                }
                else{
                    if((papa * 2)+1 > cont){
                        min = papa*2;
                    }
                    else{
                        if(arr[papa * 2].compareTo(arr[papa * 2 +1])<0){
                            min = papa*2;
                        }
                        else{
                            min = papa*2 +1;
                        }
                    }
                    if(arr[papa].compareTo(arr[min])>0){
                        swap(papa, min);
                    }
                    else{
                        termine = true;
                    }
                    papa = min;
                }
            }
        }
        return res;
    }
}
