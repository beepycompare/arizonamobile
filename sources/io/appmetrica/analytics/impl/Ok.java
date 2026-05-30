package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes5.dex */
public final class Ok {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f707a;
    public final long b;

    public Ok() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f707a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
