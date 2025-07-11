package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0538qk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1009a;
    public final long b;

    public C0538qk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1009a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
