package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0433mk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1121a;
    public final long b;

    public C0433mk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1121a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
