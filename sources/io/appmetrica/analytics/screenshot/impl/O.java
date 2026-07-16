package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class O {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1442a;
    public final List b;
    public final long c;

    public O(boolean z, List list, long j) {
        this.f1442a = z;
        this.b = list;
        this.c = j;
    }

    public final String toString() {
        return "ServiceSideContentObserverCaptorConfig(enabled=" + this.f1442a + ", mediaStoreColumnNames=" + this.b + ", detectWindowSeconds=" + this.c + ')';
    }

    public O() {
        this(new x().f1464a, AbstractC0791m.a(), new x().b);
    }
}
