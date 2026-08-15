package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.v4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0653v4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1244a;

    public C0653v4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f1244a.elapsedRealtime();
    }

    public C0653v4(SystemTimeProvider systemTimeProvider) {
        this.f1244a = systemTimeProvider;
    }
}
