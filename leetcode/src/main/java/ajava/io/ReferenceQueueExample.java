package ajava.io;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class MyObject {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("MyObject is being finalized.");
    }
}

public class ReferenceQueueExample {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        MyObject myObject = new MyObject();
        WeakReference<MyObject> weakReference = new WeakReference<>(myObject, referenceQueue);

        // Remove strong reference to myObject
        myObject = null; //若注释掉这行代码，MyObject对象将不会被回收
        System.out.println("Before GC: " + weakReference.get());

        System.out.println("Triggering garbage collection...");
        System.gc();

        // Wait for a short period to ensure GC has run
        Thread.sleep(1000);

        if (referenceQueue.poll() != null) {
            System.out.println("MyObject is being garbage collected.");
        } else {
            System.out.println("MyObject is still alive.");
        }
        System.out.println(referenceQueue.poll());
    }
}
