package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.xc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0707xc {

    /* renamed from: a  reason: collision with root package name */
    public final C0212dh f1137a;
    public final M9 b;
    public final J4 c;
    public final C0386kf d;
    public final C0327i5 e;
    public final Qc f = new Qc();
    public final Lazy g = LazyKt.lazy(new C0682wc(this));

    public C0707xc(C0279g7 c0279g7, C0212dh c0212dh, M9 m9, J4 j4, C0386kf c0386kf) {
        this.f1137a = c0212dh;
        this.b = m9;
        this.c = j4;
        this.d = c0386kf;
        this.e = new C0327i5(c0279g7, c0212dh);
    }

    public final List<Y8> a() {
        return this.e.a();
    }

    public final List<Y8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((Y8) this.g.getValue()));
    }
}
