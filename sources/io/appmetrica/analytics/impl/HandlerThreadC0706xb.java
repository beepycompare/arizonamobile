package io.appmetrica.analytics.impl;

import android.os.HandlerThread;
import io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread;
/* renamed from: io.appmetrica.analytics.impl.xb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerThreadC0706xb extends HandlerThread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1136a;

    public HandlerThreadC0706xb(String str) {
        super(str);
        this.f1136a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized boolean isRunning() {
        return this.f1136a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized void stopRunning() {
        this.f1136a = false;
        interrupt();
    }
}
