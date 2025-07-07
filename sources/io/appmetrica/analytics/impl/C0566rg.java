package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0566rg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0345ij f1026a;
    public final La b;
    public final La c;

    public C0566rg() {
        this(new C0345ij(), new La(100), new La(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Ig ig) {
        Ni ni;
        G8 g8 = new G8();
        Gn a2 = this.b.a(ig.f476a);
        g8.f441a = StringUtils.getUTF8Bytes((String) a2.f449a);
        Gn a3 = this.c.a(ig.b);
        g8.b = StringUtils.getUTF8Bytes((String) a3.f449a);
        C0445mj c0445mj = ig.c;
        if (c0445mj != null) {
            ni = this.f1026a.fromModel(c0445mj);
            g8.c = (H8) ni.f556a;
        } else {
            ni = null;
        }
        return new Ni(g8, new C0678w3(C0678w3.b(a2, a3, ni)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public C0566rg(C0345ij c0345ij, La la, La la2) {
        this.f1026a = c0345ij;
        this.b = la;
        this.c = la2;
    }

    public final Ig a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
