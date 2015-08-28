/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.pkg1.ex.pkg1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martamiszczyk
 */
public class Threads1Ex1
{

    public static class Thread1 extends Thread
    {

        long sum;

        public void run()
        {
            for (long i = 0; i < 1000000000; i++)
            {
                sum = sum + i;
                System.out.println(sum);
            }
        }
    }

    public static class Thread2 extends Thread
    {

        public void run()
        {
            for (int i = 1; i < 6; i++)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException ex)
                {
                    
                }
            }
        }
    }
    
    public static volatile boolean finished= false;
    
    public static class Thread3 extends Thread
    {
        public void run()
        {
            for (int i=10; i<10000; i++)
            {
                
                if (finished)
                {
                    break;
                }
                try
                {
                    Thread.sleep(3000);
                    System.out.println(i);
                } catch (InterruptedException ex)
                {
                    
                }
            }
        }
    }

    public static void main(String[] args)
    {
//        Thread1 t1 = new Thread1();
//        t1.start();
//        Thread t2= new Thread2();
//        t2.start();
        Thread t3= new Thread3();
        t3.start();
        
        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException ex)
        {
            
        }
        finished=true;
    }

}
