package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.collections.ArraysKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.p  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0774p {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1374a;
    public final List b;
    public final long c;

    public C0774p(boolean z, List list, long j) {
        this.f1374a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1374a;
    }

    public final List c() {
        return this.b;
    }

    public final String toString() {
        return "ContentObserverCaptorConfig(enabled=" + this.f1374a + ", mediaStoreColumnNames='" + this.b + "', detectWindowSeconds=" + this.c + ')';
    }

    public C0774p() {
        this(new O().f1344a, ArraysKt.toList(new O().c), new O().b);
    }
}
