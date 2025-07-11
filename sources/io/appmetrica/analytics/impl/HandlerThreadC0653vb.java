package io.appmetrica.analytics.impl;

import android.os.HandlerThread;
import io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread;
/* renamed from: io.appmetrica.analytics.impl.vb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerThreadC0653vb extends HandlerThread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1091a;

    public HandlerThreadC0653vb(String str) {
        super(str);
        this.f1091a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized boolean isRunning() {
        return this.f1091a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized void stopRunning() {
        this.f1091a = false;
        interrupt();
    }
}
