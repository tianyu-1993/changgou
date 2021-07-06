package com.changgou.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Test {

    public static void main(String[] args){
        List<Integer> numList = new ArrayList<>();
        List<Integer> backList = new ArrayList<>();
        Random random = new Random();
        int max = 35;
        int min = 1;
        for(int i=0;i<5;i++) {
            int randomNumber = random.nextInt(max) % (max - min + 1) + min;
            numList.add(randomNumber);
        }
        int a = 12;
        int b  =1;
        for(int j=0;j<2;j++){
            int randomNumber = random.nextInt(a) % (a - b + 1) + b;
            backList.add(randomNumber);
        }
        System.out.println(numList.toString() + backList.toString());
    }
}
