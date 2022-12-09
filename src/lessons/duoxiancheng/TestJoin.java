package lessons.duoxiancheng;

/**
 * @author LJP
 */

//测试join方法
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
              // 避免两个线程并发执行太快，看不出效果
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //启动线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
