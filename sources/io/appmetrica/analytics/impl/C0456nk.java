package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.nk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0456nk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1034a;
    public final long b;

    public C0456nk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1034a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
