package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes4.dex */
public final class Ck {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f394a;
    public final long b;

    public Ck() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f394a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
