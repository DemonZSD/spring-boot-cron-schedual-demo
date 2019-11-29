package org.weshzhu.cronschedualdemo.task;

/**
 * TODO
 *
 * @author by Zhu Shidong
 */
public class TaskRunner implements  Runnable {
    @Override
    public void run() {
        System.out.println("do CustomTaskAlternate work");
    }
}
