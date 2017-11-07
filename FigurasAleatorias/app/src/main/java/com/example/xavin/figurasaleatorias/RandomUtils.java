package com.example.xavin.figurasaleatorias;

import java.util.Random;

/**
 * Created by xavin on 07/11/2017.
 */

public class RandomUtils {
    private static Random r = new Random();

    //Devuelve un entero aleatorio en el intervalo [0, range-]
    public static int randomInt(int range){
        return(r.nextInt(range));
    }

    //Devuelve un indice aleatorio en el intervalo [0 array.lenght-1]
    public static int randomIndex(Object[] array) {
        return(randomInt(array.length));
    }

    //Devuelve un elemento aleatorio perteneciente a un array
    public static <T> T randomElement(T[] array){
        return (array[randomIndex(array)]);
    }

    //Devuelve un numero float aleatorio, en el intervalo [0, n]
    public static float randomFloat(int n) {
        return((float)Math.random()*n);
    }
}