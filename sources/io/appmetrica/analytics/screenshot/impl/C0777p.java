package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.collections.ArraysKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.p  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0777p {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1482a;
    public final List b;
    public final long c;

    public C0777p(boolean z, List list, long j) {
        this.f1482a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1482a;
    }

    public final List c() {
        return this.b;
    }

    public final String toString() {
        return "ContentObserverCaptorConfig(enabled=" + this.f1482a + ", mediaStoreColumnNames='" + this.b + "', detectWindowSeconds=" + this.c + ')';
    }

    public C0777p() {
        this(new O().f1452a, ArraysKt.toList(new O().c), new O().b);
    }
}
