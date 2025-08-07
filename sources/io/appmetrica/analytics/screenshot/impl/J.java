package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class J implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final V f1279a;

    public J() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O fromModel(G g) {
        O o = new O();
        o.f1284a = g.f1276a;
        T t = g.b;
        o.b = t != null ? this.f1279a.fromModel(t) : null;
        return o;
    }

    public J(V v) {
        this.f1279a = v;
    }

    public /* synthetic */ J(V v, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new V(null, null, null, 7, null) : v);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G toModel(O o) {
        return new G(o.f1284a, this.f1279a.toModel(o.b));
    }
}
