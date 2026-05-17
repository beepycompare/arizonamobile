package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.e4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0212e4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f975a;

    public C0212e4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f975a.elapsedRealtime();
    }

    public C0212e4(SystemTimeProvider systemTimeProvider) {
        this.f975a = systemTimeProvider;
    }
}
