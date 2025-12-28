package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.nk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0455nk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1132a;
    public final long b;

    public C0455nk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1132a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
