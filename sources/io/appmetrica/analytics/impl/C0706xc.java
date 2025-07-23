package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.xc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0706xc {

    /* renamed from: a  reason: collision with root package name */
    public final C0211dh f1137a;
    public final M9 b;
    public final J4 c;
    public final C0385kf d;
    public final C0326i5 e;
    public final Qc f = new Qc();
    public final Lazy g = LazyKt.lazy(new C0681wc(this));

    public C0706xc(C0278g7 c0278g7, C0211dh c0211dh, M9 m9, J4 j4, C0385kf c0385kf) {
        this.f1137a = c0211dh;
        this.b = m9;
        this.c = j4;
        this.d = c0385kf;
        this.e = new C0326i5(c0278g7, c0211dh);
    }

    public final List<Y8> a() {
        return this.e.a();
    }

    public final List<Y8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((Y8) this.g.getValue()));
    }
}
