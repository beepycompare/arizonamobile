package io.appmetrica.analytics.screenshot.impl;

import java.util.List;
import kotlin.collections.ArraysKt;
/* renamed from: io.appmetrica.analytics.screenshot.impl.o  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0788o {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1307a;
    public final List b;
    public final long c;

    public C0788o(boolean z, List list, long j) {
        this.f1307a = z;
        this.b = list;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final boolean b() {
        return this.f1307a;
    }

    public final List c() {
        return this.b;
    }

    public final String toString() {
        return "ContentObserverCaptorConfig(enabled=" + this.f1307a + ", mediaStoreColumnNames='" + this.b + "', detectWindowSeconds=" + this.c + ')';
    }

    public C0788o() {
        this(new L().f1277a, ArraysKt.toList(new L().c), new L().b);
    }
}
