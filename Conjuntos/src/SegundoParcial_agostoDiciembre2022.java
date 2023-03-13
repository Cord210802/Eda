

import java.util.Iterator;


/**
 *
 * @author Juan Pablo Cordero Mayorga
 * cu 205597
 */



public class SegundoParcial_agostoDiciembre2022 {
    
    public static boolean esPanvocalica(String palabra){
        ConjuntoA vocales = new ConjuntoA();
        boolean res = esPanvocalica(palabra, 0, vocales);
        
        return res;
    }
    
    private static boolean esPanvocalica(String palabra, int i, ConjuntoA vocales){
        String letra;
        
        if (palabra != null && i<palabra.length()){
            letra = palabra.substring(i, i + 1).toLowerCase();
            if (letra.equals("a") || letra.equals("e") || letra.equals("i")
                    || letra.equals("o") || letra.equals("u")){
                if (!vocales.agrega(letra)){
                    return false;
                }
            }
            return esPanvocalica(palabra, i + 1, vocales);
        }
        else{
            if (vocales.contiene("a") && vocales.contiene("e") && vocales.contiene("i") && vocales.contiene("o")
                    && vocales.contiene("u")){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    private static boolean esPanvocalica(String palabra, int j, boolean a, boolean e, boolean i, boolean o, boolean u){
        String letra;
        
        if (palabra != null && j<palabra.length()){
            letra = palabra.substring(j, j + 1).toLowerCase();
            switch (letra){
                case "a": 
                    if (a){
                        return false;
                    }
                    a = true;
                    break;
                case "e": 
                    if (e){
                        return false;
                    }
                    e = true;
                    break;
                case "i": 
                    if (i){
                        return false;
                    }
                    i = true;
                    break;
                case "o": 
                    if (o){
                        return false;
                    }
                    o = true;
                    break;
                case "u": 
                    if (u){
                        return false;
                    }
                    u = true;
                    break;
            }
            return esPanvocalica(palabra, j + 1, a, e, i, o , u);
        }
        else{
            if (a && e && i && o && u){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    public static boolean esPanvocalicaEficiente(String palabra){
        boolean res = esPanvocalica(palabra, 0, false, false, false, false, false);
        
        return res;
    }
    public static boolean conjuntoPropio(ConjuntoADT c1, ConjuntoADT c2){
        boolean res = true;
        Iterator it;
        
        if (c1 != null && c2 != null){
            it = c2.iterator();
            while(it.hasNext() && res){
                if (!c1.contiene(it.next())){
                    res = false;
                }
            }  
        }
        else{
            res = false;
        }
        return res;
    }
        
    public static void main(String[] args) {
        //Pruebas primera pregunta
        String palabra1 = "Aceituno";
        String palabra2 = "ADENOVIRUS";
        String palabra3 = "peliagudo";
        String palabra4 = "";
        String palabra5 = "delicioso";
        String palabra6 = "SUPERIOR";
        String palabra7 = null;
        String palabra8 = "Quijotesca";
        //Casos donde si es y terminan en vocal
        System.out.println("Pruebas del conjunto: si es y termina en vocal");
        System.out.println(esPanvocalica(palabra1));
        System.out.println(esPanvocalica(palabra3));
        System.out.println(esPanvocalica(palabra8));
        System.out.println("Pruebas del eficiente: si es y termina en vocal");
        System.out.println(esPanvocalicaEficiente(palabra1));
        System.out.println(esPanvocalicaEficiente(palabra3));
        System.out.println(esPanvocalicaEficiente(palabra8));
        //Casos donde si es y termina en consonante
        System.out.println("Pruebas del conjunto: si es y termian en consonante");
        System.out.println(esPanvocalica(palabra2));
        System.out.println("Pruebas del eficiente: si es y termina en consonante");
        System.out.println(esPanvocalicaEficiente(palabra2));
        //Caso donde la palabra no tienen ningun caracter
        System.out.println("Pruebas del conjunto: no tienen ningun caracter");
        System.out.println(esPanvocalica(palabra4));
        System.out.println("Pruebas del eficiente: no tienen ningun caracter");
        System.out.println(esPanvocalicaEficiente(palabra4));
        //Casos donde no es 
        System.out.println("Pruebas del conjunto: casos donde no es");
        System.out.println(esPanvocalica(palabra5));
        System.out.println(esPanvocalica(palabra6));
        System.out.println("Pruebas del eficiente: casos donde no es");
        System.out.println(esPanvocalicaEficiente(palabra5));
        System.out.println(esPanvocalicaEficiente(palabra6));
        //Caso en el que te dan una palabra null
        System.out.println("Pruebas del conjunto: nulo");
        System.out.println(esPanvocalica(palabra7));
        System.out.println("Pruebas del eficiente: nulo");
        System.out.println(esPanvocalicaEficiente(palabra7));
        System.out.println("Empiezan pruebas segunda pregunta");
        System.out.println("");
        //Pruebas segunda pregunta 
        ConjuntoADT c1 = new ConjuntoA();
        ConjuntoADT c2 = new ConjuntoA();
        //Caso donde ambos conjuntos son iguales
        System.out.println("Caso donde ambos conjuntos son iguales");
        c1.agrega("Te");
        c1.agrega("Queremos");
        c1.agrega("Silvia");
        c1.agrega(10);
        c2.agrega("Te");
        c2.agrega("Queremos");
        c2.agrega("Silvia");
        c2.agrega(10);
        System.out.println(conjuntoPropio(c1, c2));
        //Caso donde c1 contiene todos los elementos de c2
        System.out.println("Casos donde c1 contiene todos los elementos de c2");
        ConjuntoADT c1Contiene = new ConjuntoA();
        ConjuntoADT c2Contiene = new ConjuntoA();
        c1Contiene.agrega(1);
        c1Contiene.agrega(2);
        c1Contiene.agrega("Silvia MVP");
        c2Contiene.agrega("Silvia MVP");
        c2Contiene.agrega(2);
        System.out.println(conjuntoPropio(c1Contiene, c2Contiene));
        //Caso donde los conjuntos son nulos
        System.out.println("Caso donde los conjuntos son null");
        ConjuntoADT c1Null = null;
        ConjuntoADT c2Null = null;
        System.out.println(conjuntoPropio(c1Null, c2Null));
        //Caso donde los conjuntos estan vacios
        System.out.println("Caso de conjuntos vacios");
        ConjuntoADT c1Vacio = new ConjuntoA();
        ConjuntoADT c2Vacio = new ConjuntoA();
        System.out.println(conjuntoPropio(c1Vacio, c2Vacio));
        //Caso donde  c1 no contiene todos los elementos de c2
        System.out.println("Caso donde c1 no tiene todos los elementos de c2");
        ConjuntoADT c1Chico = new ConjuntoA();
        ConjuntoADT c2Grande = new ConjuntoA();
        c1Chico.agrega("ED es la mejor materia");
        c2Grande.agrega("Todo mundo lo sabe");
        c2Grande.agrega("ED es la mejor materia");
        System.out.println(conjuntoPropio(c1Chico, c2Grande));
        System.out.println("Caso donde tienen elementos diferentes");
        //Caso donde tienen elementos diferentes
        ConjuntoADT c1Diferente = new ConjuntoA();
        ConjuntoADT c2Diferente = new ConjuntoA();
        c1Diferente.agrega("Silvia para precidente");
        c2Diferente.agrega(2024);
        System.out.println(conjuntoPropio(c1Diferente, c2Diferente));
    }
}
