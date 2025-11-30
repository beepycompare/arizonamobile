package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1366a;
    public final List b;
    public final long c;

    public i0(boolean z, List list, long j) {
        this.f1366a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1366a;
    }

    public final List c() {
        return this.b;
    }

    public final String toString() {
        return "ServiceSideContentObserverCaptorConfig(enabled=" + this.f1366a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public i0(C0774p c0774p) {
        this(c0774p.b(), c0774p.c(), c0774p.a());
    }
}
