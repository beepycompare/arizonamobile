package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0531qk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1078a;
    public final long b;

    public C0531qk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1078a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
