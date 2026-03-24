import javaLearn.reflect.ReflectTest;
import javaLearn.reflect.Student;
import javaLearn.reflect.Test;
import leetCode.Test.*;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.test_869();
        int[] array = {0,3,2,8,13,50,1,2,2,8,0,9,3,11,2,3,5,2};
        int num = 12;
        calculate(array, num);
    }

    private void test_869() {
        leetCode._869_ReorderedPowerOf2.Test t = new leetCode._869_ReorderedPowerOf2.Test();
        t.test();
    }

    private void test_5() {
        leetCode._5_LongestPalindrome.Test t = new leetCode._5_LongestPalindrome.Test();
        t.test();
    }

    private void test_120() {
        leetCode._120_MinimumTotal.Test t = new leetCode._120_MinimumTotal.Test();
        t.test();
    }

    private void test_740() {
        leetCode._740_DeleteAndEarn.Test t = new leetCode._740_DeleteAndEarn.Test();
        t.test();
    }

    private void test_561() {
        leetCode._561_LongestPalindromeSubseq.Test t = new leetCode._561_LongestPalindromeSubseq.Test();
        t.test();
    }

    // 创建一个引用队列
    ReferenceQueue<Object> queue = new ReferenceQueue<>();

    private void test() {
        // 创建一个对象
        Object obj = new Object();
        // 创建一个弱引用，并指向这个对象，并且将引用队列传递给弱引用
        WeakReference<Object> reference = new WeakReference(obj, queue);
        // 打印出这个弱引用，为了跟gc之后queue里面的对比证明是同一个
        System.out.println("这个弱引用是:" + reference);
        // gc一次看看(什么都没)
        System.gc();
        // 打印队列(应该是空)
        printlnQueue("before");

        // 先设置obj为null，obj可以被回收了
        obj = null;
        // 再进行gc，此时obj应该被回收了，那么queue里面应该有这个弱引用了
        System.gc();
        // 再打印队列
        printlnQueue("after");
    }

    private void printlnQueue(String tag) {
        System.out.print(tag);
        Object obj;
        // 循环打印引用队列
        while ((obj = queue.poll()) != null) {
            System.out.println(": " + obj);
        }
        System.out.println();
    }
    private void test_3337() {
        leetCode._3337_LengthAfterTransformations.Test t = new leetCode._3337_LengthAfterTransformations.Test();
        t.test();
    }

    private void test_3335() {
        leetCode._3335_LengthAfterTransformations.Test t = new leetCode._3335_LengthAfterTransformations.Test();
        t.test();
    }

    private void test_790() {
        leetCode._790_NumTilings.Test t = new leetCode._790_NumTilings.Test();
        t.test();
    }

    private void test_2302() {
        leetCode._2302_CountSubarrays.Test t = new leetCode._2302_CountSubarrays.Test();
        t.test();
    }

    private void test_reflect_exercise() {
        Test t = new Test();
        t.test();
        t.testExercise();
        ReflectTest t1 = new ReflectTest();
        t1.testClass();
        t1.testFields();
    }

    private void test_2712() {
        leetCode.DynamicPlanning._2712_MinimumCost.Test t = new leetCode.DynamicPlanning._2712_MinimumCost.Test();
        t.test();
    }

    private void test_2255() {
        leetCode._2255_CountPrefixes.Test t = new leetCode._2255_CountPrefixes.Test();
        t.test();
    }

    private void test_1278() {
        leetCode._1278_PalindromePartition.Test t = new leetCode._1278_PalindromePartition.Test();
        t.test();
    }

    private void test_131() {
        Test t = new Test();
        t.test();
    }

    private void test_2711() {
        leetCode._2711_DifferenceOfDistinctValues.Test t = new leetCode._2711_DifferenceOfDistinctValues.Test();
        t.test();
    }

    private void test_1863() {
        leetCode._1863_SubsetXORSum.Test t = new leetCode._1863_SubsetXORSum.Test();
        t.test();
    }

    private void test_1123() {
        leetCode._1123_LcaDeepestLeaves.Test t = new leetCode._1123_LcaDeepestLeaves.Test();
        t.test();
    }

    private void test_3396() {
        leetCode._3396_MinimumOperations.Test t = new leetCode._3396_MinimumOperations.Test();
        t.test();
    }

    private void test_368() {
        leetCode._368_LargestDivisibleSubset.Test t = new leetCode._368_LargestDivisibleSubset.Test();
        t.test();
    }

    private void test_1922() {
        leetCode._1922_CountGoodNumbers.Test t = new leetCode._1922_CountGoodNumbers.Test();
        t.test();
    }

    private void test_2364() {
        leetCode._2364_CountBadPairs.Test t = new leetCode._2364_CountBadPairs.Test();
        t.test();
    }

    private void test_1534() {
        leetCode._1534_CountGoodTriplets.Test t = new leetCode._1534_CountGoodTriplets.Test();
        t.test();
    }

    private void test_2176() {
        leetCode._2176_CountPairs.Test t = new leetCode._2176_CountPairs.Test();
        t.test();
    }

    private void test_2962() {
        leetCode._2962_CountSubarrays.Test t = new leetCode._2962_CountSubarrays.Test();
        t.test();
    }

    public boolean test(int a) {
        int b = 1;
        int c = 3;
        int d = 4;
        int temp = b ^ c;
        System.out.println("b ^ c = " + temp);
        temp ^= d;
        System.out.println("b ^ c ^ d = " + temp);
        temp ^= d;
        System.out.println("b ^ c ^ d ^ d = b ^ c = " + temp);
        temp ^= c;
        System.out.println("b ^ c ^ d ^ d ^ c = b = " + temp);
        temp ^= b;
        System.out.println("b ^ c ^ d ^ d ^ c ^ b = 0 = " + temp);

        A a1 = new B(1);
        Province country = new Province();
        country.setNameCountry("China");
        country.setNameProvince("guangdong");
        FruitOut out = new FruitOut(country);
        System.out.println(((Province)out.getFruit()).getNameProvince());
        FruitIn in = new FruitIn(country);
        in.setFruit(country);

        Map<Integer, Integer> map = new HashMap<>();

        return true;
    }

    private static void calculate(int[] array, int num) {
        int n = array.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < n) {
            while (end < n) {
                sum += array[end];
                end ++;
                if (sum >= num) {
                    break;
                }
            }
            if (sum == num) {
                break;
            }
            if (end == n) {
                break;
            }
            while (start < end) {
                sum -= array[start];
                start ++;
                if (sum <= num) {
                    break;
                }
            }
            if (sum == num) {
                break;
            }
        }
        for (int i = start; i < end; i ++) {
            System.out.print(array[i] + " ");
        }
    }
}
