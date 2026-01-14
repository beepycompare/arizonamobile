package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.e4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0213e4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f971a;

    public C0213e4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f971a.elapsedRealtime();
    }

    public C0213e4(SystemTimeProvider systemTimeProvider) {
        this.f971a = systemTimeProvider;
    }
}
