package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0558rg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0337ij f1027a;
    public final La b;
    public final La c;

    public C0558rg() {
        this(new C0337ij(), new La(100), new La(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(Ig ig) {
        Ni ni;
        G8 g8 = new G8();
        Gn a2 = this.b.a(ig.f477a);
        g8.f442a = StringUtils.getUTF8Bytes((String) a2.f450a);
        Gn a3 = this.c.a(ig.b);
        g8.b = StringUtils.getUTF8Bytes((String) a3.f450a);
        C0437mj c0437mj = ig.c;
        if (c0437mj != null) {
            ni = this.f1027a.fromModel(c0437mj);
            g8.c = (H8) ni.f557a;
        } else {
            ni = null;
        }
        return new Ni(g8, new C0670w3(C0670w3.b(a2, a3, ni)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public C0558rg(C0337ij c0337ij, La la, La la2) {
        this.f1027a = c0337ij;
        this.b = la;
        this.c = la2;
    }

    public final Ig a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
