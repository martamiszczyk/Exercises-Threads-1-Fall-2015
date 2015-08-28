/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1.ex.pkg2;

/**
 *
 * @author martamiszczyk
 */
public class Threads1Ex2
{

    public static class Even
    {

        private int n = 0;

        public int next()
        {
            n++;
            n++;
            return n;

        }
    }

    public static class Thread1 extends Thread
    {

        public void run()
        {
            Even e = new Even();
            for(int i=0; i<10; i++)
            {
                System.out.println("tråd1="+e.next());
            }
             

        }
    }

    public static class Thread2 extends Thread
    {

        public void run()
        {
            Even e = new Even();

           for(int i=0; i<10; i++)
            {
                System.out.println("tråd2="+ e.next());
            }

        }
    }

    public static void main(String[] args)
    {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();

        t1.start();
        t2.start();
         try
        {
            t1.join();
            t2.join();
            Thread.sleep(20000);
        } catch (InterruptedException ex)
        {
            
        }

    }

}
