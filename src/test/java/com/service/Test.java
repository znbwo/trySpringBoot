package com.service;

import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class Test {
    @org.junit.Test
    public void test() {
        List a = new ArrayList();
        a.add(1);

        List b = a;
//        a.clear();
        System.out.println(b);
    }

    @org.junit.Test
    public void test1() {
        List a = new ArrayList();
        List b = new ArrayList();
        a.add(b);
        b.add("1");
        b.clear();
        b.add("2");

        System.out.println(a);
        System.out.println(b);
    }

    @org.junit.Test
    public void test2() {
        List list = new ArrayList();
        while (list.isEmpty()) {
            System.out.println("is empty.");
        }
        list.add(1);

    }
    @org.junit.Test
    synchronized  public  void test3() throws InterruptedException {
        List list = new ArrayList();
//        while (list.isEmpty()) {
//            System.out.println("is empty.");
//            this.wait();
//        }
        if (list.isEmpty()) {
            System.out.println("is empty.");
            this.wait();
        }
    }
    public static void main1(String[] args) {
        System.out.println(new Date().getTime());
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(() -> new ArrayList<Integer>(),
                        (list, item) -> {
                            list.add(item);
                        },
                        (list1, list2) -> {
                            list1.addAll(list2);
                            System.out.print(list2);
                        });


    }

    public static  void main(String[] args) throws InterruptedException {
//        Test test = new Test();
//        test.test3();
        List list = new ArrayList();
        list.get(0);

    }
}
