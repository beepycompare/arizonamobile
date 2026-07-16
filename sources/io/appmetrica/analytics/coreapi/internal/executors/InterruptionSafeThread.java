package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes5.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f319a;

    public InterruptionSafeThread() {
        this.f319a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f319a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f319a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f319a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f319a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f319a = true;
    }
}
