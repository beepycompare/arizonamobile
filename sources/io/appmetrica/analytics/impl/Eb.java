package io.appmetrica.analytics.impl;

import android.os.HandlerThread;
import io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread;
/* loaded from: classes5.dex */
public final class Eb extends HandlerThread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f526a;

    public Eb(String str) {
        super(str);
        this.f526a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized boolean isRunning() {
        return this.f526a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized void stopRunning() {
        this.f526a = false;
        interrupt();
    }
}
