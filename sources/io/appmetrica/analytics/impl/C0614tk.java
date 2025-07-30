package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0614tk {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1070a;
    public final long b;

    public C0614tk() {
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f1070a = systemTimeProvider;
        this.b = systemTimeProvider.currentTimeMillis();
    }
}
