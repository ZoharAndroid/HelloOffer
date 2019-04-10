package Java.code;

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        // 设置为null好让gc回收
        SAVE_HOOK = null;
        System.gc();// 启动GC回收
        // finalize方法优先级比较低，所以暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am die :(");
        }

        SAVE_HOOK = null;
        System.gc();// 启动GC回收
        // finalize方法优先级比较低，所以暂停0.5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no, i am die :(");
        }
    }
}

/**
 *
 * finalize method executed
 * yes, i am still alive :)
 * no, i am die :(
 *
 * 这里将对象从GC收集器中就回来了一次，但是只能使用一次，第二次使用的时候也就会发现没有用了。
 *
 */
