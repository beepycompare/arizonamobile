package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.f4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0235f4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f883a;

    public C0235f4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f883a.elapsedRealtime();
    }

    public C0235f4(SystemTimeProvider systemTimeProvider) {
        this.f883a = systemTimeProvider;
    }
}
