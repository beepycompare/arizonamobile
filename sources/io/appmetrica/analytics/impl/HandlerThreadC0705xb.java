package io.appmetrica.analytics.impl;

import android.os.HandlerThread;
import io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread;
/* renamed from: io.appmetrica.analytics.impl.xb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerThreadC0705xb extends HandlerThread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1137a;

    public HandlerThreadC0705xb(String str) {
        super(str);
        this.f1137a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized boolean isRunning() {
        return this.f1137a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized void stopRunning() {
        this.f1137a = false;
        interrupt();
    }
}
