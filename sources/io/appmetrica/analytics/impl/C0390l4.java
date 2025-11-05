package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.l4  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0390l4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f983a;

    public C0390l4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f983a.elapsedRealtime();
    }

    public C0390l4(SystemTimeProvider systemTimeProvider) {
        this.f983a = systemTimeProvider;
    }
}
