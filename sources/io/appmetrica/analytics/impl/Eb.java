package io.appmetrica.analytics.impl;

import android.os.HandlerThread;
import io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread;
/* loaded from: classes5.dex */
public final class Eb extends HandlerThread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f525a;

    public Eb(String str) {
        super(str);
        this.f525a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized boolean isRunning() {
        return this.f525a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized void stopRunning() {
        this.f525a = false;
        interrupt();
    }
}
