package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class O {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1440a;
    public final List b;
    public final long c;

    public O(boolean z, List list, long j) {
        this.f1440a = z;
        this.b = list;
        this.c = j;
    }

    public final String toString() {
        return "ServiceSideContentObserverCaptorConfig(enabled=" + this.f1440a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public O() {
        this(new x().f1462a, AbstractC0791m.a(), new x().b);
    }
}
