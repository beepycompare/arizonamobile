package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes4.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f246a;

    public InterruptionSafeThread() {
        this.f246a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f246a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f246a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f246a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f246a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f246a = true;
    }
}
