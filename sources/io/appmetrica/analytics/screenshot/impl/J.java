package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class J implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final V f1298a;

    public J() {
        this(null, 1, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final O fromModel(G g) {
        O o = new O();
        o.f1303a = g.f1295a;
        T t = g.b;
        o.b = t != null ? this.f1298a.fromModel(t) : null;
        return o;
    }

    public J(V v) {
        this.f1298a = v;
    }

    public /* synthetic */ J(V v, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new V(null, null, null, 7, null) : v);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final G toModel(O o) {
        return new G(o.f1303a, this.f1298a.toModel(o.b));
    }
}
