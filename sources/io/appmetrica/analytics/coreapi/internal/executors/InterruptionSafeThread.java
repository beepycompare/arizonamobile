package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes5.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f370a;

    public InterruptionSafeThread() {
        this.f370a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f370a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f370a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f370a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f370a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f370a = true;
    }
}
