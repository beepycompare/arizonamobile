package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* loaded from: classes4.dex */
public final class C4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f383a;

    public C4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f383a.elapsedRealtime();
    }

    public C4(SystemTimeProvider systemTimeProvider) {
        this.f383a = systemTimeProvider;
    }
}
