package io.appmetrica.analytics.impl;

import android.os.HandlerThread;
import io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread;
/* renamed from: io.appmetrica.analytics.impl.db  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class HandlerThreadC0190db extends HandlerThread implements IInterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f931a;

    public HandlerThreadC0190db(String str) {
        super(str);
        this.f931a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized boolean isRunning() {
        return this.f931a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final synchronized void stopRunning() {
        this.f931a = false;
        interrupt();
    }
}
