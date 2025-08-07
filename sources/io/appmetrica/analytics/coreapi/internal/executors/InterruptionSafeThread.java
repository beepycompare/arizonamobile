package io.appmetrica.analytics.coreapi.internal.executors;
/* loaded from: classes4.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f238a;

    public InterruptionSafeThread() {
        this.f238a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.f238a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.f238a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.f238a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.f238a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.f238a = true;
    }
}
