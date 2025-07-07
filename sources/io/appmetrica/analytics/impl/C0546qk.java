package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0546qk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1008a;
    public final long b;

    public C0546qk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1008a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
