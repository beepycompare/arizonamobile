package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
/* renamed from: io.appmetrica.analytics.impl.ta  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0607ta implements D6 {

    /* renamed from: a  reason: collision with root package name */
    public final SystemTimeProvider f1215a = new SystemTimeProvider();

    public final long a(Lb lb) {
        long j = lb.k;
        return j > 0 ? j : this.f1215a.currentTimeMillis();
    }
}
