package com.smaboy.pc120.xiuxiu.c.manager;

import android.app.Activity;
import android.util.Log;

import com.smaboy.pc120.xiuxiu.c.util.LogUtil;

import java.util.HashMap;

/**
 * 类名: ActivityTaskManager
 * 类作用描述: Activity管理器
 * 作者: Smaboy
 * 创建时间: 2018/9/14 10:56
 */
public class ActivityTaskManager {
    // 创建ActivityTaskManager
    private static ActivityTaskManager activityTaskManager = null;
    // 创建activity管理Map
    private HashMap<String, Activity> activityMap = new HashMap<>();

    /**
     * 返回Activity管理器的唯一实例对象(采用单例的实现模式)
     *
     * @return ActivityTaskManager(Activity管理器的唯一实例对象)
     */
    public static ActivityTaskManager getInstance() {
        // synchronized方法声明时使用,放在范围操作符(public等)之后,返回类型声明(void等)之前.
        // 这时,线程获得的是成员锁,即一次只能有一个线程进入该方法,其他线程要想在此时调用该方法,只能排队等候,
        // 当前线程(就是在synchronized方法内部的线程)执行完该方法后,别的线程才能进入.
        if (activityTaskManager == null) {
            synchronized (ActivityTaskManager.class) {
                activityTaskManager = new ActivityTaskManager();
            }
        }

        return activityTaskManager;
    }


    /**
     * 向Activity管理器中添加Activity
     *
     * @param actName
     * @param activity
     */
    public void addActivity(String actName, Activity activity) {
        LogUtil.e(activity.getLocalClassName());

        // 先判断是否已经存在这个activity
        if (!activityMap.containsKey(actName)) {
            // 没有存在放入该activity
            activityMap.put(actName, activity);
        } else {
            // 已经存在,则结束要存入的activity
            activity.finish();
        }
    }

    /**
     * 得到保存在管理器中的Activity对象。
     *
     * @param name
     * @return
     */
    public Activity getActivity(String name) {

        return activityMap.get(name);

    }

    /**
     * @return 当且当管理器中的Activity对象为空时返回true，否则返回false。
     * @Description 返回管理器的Activity是否为空。
     */

    public boolean isEmpty() {

        return activityMap.isEmpty();

    }

    /**
     * @return 管理器中Activity对象的个数。
     * @Description 返回管理器中Activity对象的个数。
     */

    public int size() {

        return activityMap.size();

    }


    /**
     * removeActivity将不用的Activity移除
     *
     * @param actName
     */
    public void removeActivity(String actName) {
        // 得到该Activity的实例
        Activity activity = activityMap.get(actName);
        // 如果不为null,则结束掉该activity
        if (activity != null)
            activity.finish();

        // 在activityMap中移除
        activityMap.remove(actName);
    }

    /**
     * 结束掉所有Activity
     *
     */
    public void finishAll() {
        // 遍历所有的Activity找到后执行finish
        for (String actName : activityMap.keySet()) {
            Activity activity = activityMap.get(actName);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        // 完全退出app,否则还有进程在后台
        System.exit(0);
    }

}