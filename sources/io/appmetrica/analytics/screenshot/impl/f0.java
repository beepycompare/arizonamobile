package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1298a;
    public final List b;
    public final long c;

    public f0(boolean z, List list, long j) {
        this.f1298a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1298a;
    }

    public final List c() {
        return this.b;
    }

    public final String toString() {
        return "ServiceSideContentObserverCaptorConfig(enabled=" + this.f1298a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public f0(C0780o c0780o) {
        this(c0780o.b(), c0780o.c(), c0780o.a());
    }
}
