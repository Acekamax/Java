
package aldeamoprueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  


public class AldeamoPrueba {
    public static void main(String[] args) {
        ConexionDB db= new ConexionDB();
        Connection con= db.getConnection();
        System.out.println("Prueba Tecnica Desarrollo");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dijite un Numero del 1 al 5 por favor:");
        String a = scanner.nextLine();
        System.out.println("Dijite el numero de Iteraciones:");
        String q = scanner.nextLine();
        scanner.close();
        int Q= Integer.parseInt(q);
        boolean isNumeric =  a.matches("[+-]?\\d*(\\.\\d+)?"); 
        if (isNumeric) {
            if (6>Integer.parseInt(a)&&Integer.parseInt(a)>0) {
                String lista=""; 
                lista=db.ejecutarConsulta(con,a);
                String[] lista1=lista.split(","); 
                int[] numeros= new int[lista1.length];
                for (int i = 0; i < lista1.length; i++) {
            
                    try {
                        numeros[i] = Integer.parseInt(lista1[i]);
                    } catch (Exception e) {
                        System.out.println("Unable to parse string to int: " + e.getMessage());
                    }
                }
            ArrayList<Integer> A=new ArrayList();
                for (int i = 0; i < numeros.length; i++) {
                    A.add(numeros[i]);
                }
                if (Q>numeros.length) {
                    System.out.println("el numero de iteraciones es mayor que el numero de datos en La lista No hay con quien comparar.");
                }else{
                AldeamoPrueba primos = new AldeamoPrueba();
                ArrayList<Integer> copiaA= new ArrayList();
                primos.numerosPrimos(A,copiaA,Q);
                }
            }else{
                System.out.println("el dato no esta entre 1 y 5");
            }
        }else{
            System.out.println("el dato no es un valor numerico");
        }
    }

    public static void numerosPrimos( ArrayList<Integer>A, ArrayList<Integer> copiaA,int q){
         ArrayList<Integer> B = new ArrayList();
         ArrayList<Integer> respuesta=new ArrayList();
         ArrayList<Integer> P=new ArrayList(Arrays.asList(2,3,5,11,13,17));
        for (int i = 0; i < q; i++) {
            B.clear();
            for (int j = 0; j < A.size(); j++) {
                if (Integer.parseInt(A.get(j).toString())%P.get(i)==0) {
                B.add(0,A.get(j));
                }else{
                copiaA.add(0,A.get(j));
                }                  
            }   
            A.clear();
            A.addAll(copiaA);
            respuesta.addAll(B);
            System.out.println("q"+(i+1));
            System.out.println("A"+copiaA);
            System.out.println("B"+B);
            System.out.println("respuesta"+respuesta);
            copiaA.clear();
            }
        respuesta.addAll(A);
        System.out.println("respuesta"+respuesta);
        return;
        }
    
}
