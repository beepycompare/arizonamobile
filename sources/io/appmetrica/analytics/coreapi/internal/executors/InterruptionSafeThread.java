package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes3.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f268a;

    public InterruptionSafeThread() {
        this.f268a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f268a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f268a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f268a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f268a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f268a = true;
    }
}
