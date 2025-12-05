package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes3.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f351a;

    public InterruptionSafeThread() {
        this.f351a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f351a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f351a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f351a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f351a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f351a = true;
    }
}
