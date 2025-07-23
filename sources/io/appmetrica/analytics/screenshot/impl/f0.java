package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes4.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1301a;
    public final List b;
    public final long c;

    public f0(boolean z, List list, long j) {
        this.f1301a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1301a;
    }

    public final List c() {
        return this.b;
    }

    public final String toString() {
        return "ServiceSideContentObserverCaptorConfig(enabled=" + this.f1301a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public f0(C0782o c0782o) {
        this(c0782o.b(), c0782o.c(), c0782o.a());
    }
}
