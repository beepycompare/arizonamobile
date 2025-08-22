package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.yk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0737yk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1163a;
    public final long b;

    public C0737yk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1163a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
