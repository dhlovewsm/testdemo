package com.dh.junit;

import org.junit.*;


public class StringUtilTest {

    /**
     * 常见注解：
     * @Test: 被其修饰的方法测能成功测试方法
     * @Before: 用来修饰一个实例方法，该方法在每一个测试方法执行之前执行一次(@BeforeEach)
     * @After: 被修饰的方法在每个测试方法执行之后执行一次(@AfterEach)
     * @BeforeClass: 修饰静态方法，在所有测试方法之前执行一次(@BeforeAll)
     * @AfterClass: 修饰静态方法，在所有测试方法之后执行一次(@AfterAll)
     *
     */

    @Before
    public void testBefore(){
        System.out.println("=============before被执行了");
    }

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("===================BeforeClass被执行了");
    }

    @Test
    public void testPrintNumber(){

        StringUtil.printNumber("admin");
        StringUtil.printNumber(null);

    }

    @Test
    public void testGetMaxIndex(){
        int index = StringUtil.getMaxIndex("admin");
        System.out.println(index);
        System.out.println(StringUtil.getMaxIndex(""));
        System.out.println(StringUtil.getMaxIndex(null));

        //使用断言机制，预测方法结果
        Assert.assertEquals("内部有bug",4, index);
    }

    @After
    public void testAfter(){
        System.out.println("===============after被执行了");
    }

    @AfterClass
    public static void testAfterClass(){
        System.out.println("===================AfterClass被执行了");
    }

}
