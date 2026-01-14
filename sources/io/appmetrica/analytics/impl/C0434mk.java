package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0434mk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1122a;
    public final long b;

    public C0434mk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1122a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
