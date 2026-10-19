package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.v4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0647v4 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1247a;

    public C0647v4() {
        this(new SystemTimeProvider());
    }

    public final void a() {
        this.f1247a.elapsedRealtime();
    }

    public C0647v4(SystemTimeProvider systemTimeProvider) {
        this.f1247a = systemTimeProvider;
    }
}
