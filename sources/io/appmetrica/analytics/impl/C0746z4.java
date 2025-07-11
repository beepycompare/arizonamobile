package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.z4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0746z4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1158a;

    public C0746z4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f1158a.elapsedRealtime();
    }

    public C0746z4(SystemTimeProvider systemTimeProvider) {
        this.f1158a = systemTimeProvider;
    }
}
