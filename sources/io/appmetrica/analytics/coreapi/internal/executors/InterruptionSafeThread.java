package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes3.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f265a;

    public InterruptionSafeThread() {
        this.f265a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f265a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f265a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f265a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f265a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f265a = true;
    }
}
