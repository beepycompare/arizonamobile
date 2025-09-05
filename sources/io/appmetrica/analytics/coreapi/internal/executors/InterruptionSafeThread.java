package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes4.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f247a;

    public InterruptionSafeThread() {
        this.f247a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f247a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f247a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f247a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f247a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f247a = true;
    }
}
