package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes4.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f237a;

    public InterruptionSafeThread() {
        this.f237a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f237a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f237a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f237a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f237a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f237a = true;
    }
}
