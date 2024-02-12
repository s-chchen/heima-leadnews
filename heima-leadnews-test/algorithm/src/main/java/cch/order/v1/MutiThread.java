package cch.order.v1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

public class MutiThread {
    public static void main(String[] args) {

        Map<String, String> map =new HashMap<>();
        

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(
                    "[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName()
                    + " waitedTime=" + threadInfo.getWaitedTime()
                    + " waitedcount=" + threadInfo.getWaitedCount()
                    + " inNative=" + threadInfo.isInNative()
                    + " threadState=" + threadInfo.getThreadState()
                    + " stackTrace=" + threadInfo.getStackTrace()  //线程的堆栈跟踪元素数组。
                    + " lockedMonitors=" + threadInfo.getLockedMonitors()  //线程锁定的监视器信息数组。
                    + " lockedSynchronizers=" + threadInfo.getLockedSynchronizers()  //线程锁定的同步器信息数组。

            );
        }
    }
}

