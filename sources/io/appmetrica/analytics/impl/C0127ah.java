package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0127ah implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ln f796a;
    public final V b;
    public final G6 c;
    public final Kl d;
    public final C0151bf e;
    public final C0177cf f;

    public C0127ah() {
        this(new Ln(), new V(new Dn()), new G6(), new Kl(), new C0151bf(), new C0177cf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0678w6 fromModel(Zg zg) {
        C0678w6 c0678w6 = new C0678w6();
        c0678w6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(zg.f776a, c0678w6.f));
        Wn wn = zg.b;
        if (wn != null) {
            Mn mn = wn.f732a;
            if (mn != null) {
                c0678w6.f1136a = this.f796a.fromModel(mn);
            }
            U u = wn.b;
            if (u != null) {
                c0678w6.b = this.b.fromModel(u);
            }
            List<Ml> list = wn.c;
            if (list != null) {
                c0678w6.e = this.d.fromModel(list);
            }
            c0678w6.c = (String) WrapUtils.getOrDefault(wn.g, c0678w6.c);
            c0678w6.d = this.c.a(wn.h);
            if (!TextUtils.isEmpty(wn.d)) {
                c0678w6.i = this.e.fromModel(wn.d);
            }
            if (!TextUtils.isEmpty(wn.e)) {
                c0678w6.j = wn.e.getBytes();
            }
            if (!ro.a(wn.f)) {
                c0678w6.k = this.f.fromModel(wn.f);
            }
        }
        return c0678w6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0678w6 c0678w6 = (C0678w6) obj;
        throw new UnsupportedOperationException();
    }

    public C0127ah(Ln ln, V v, G6 g6, Kl kl, C0151bf c0151bf, C0177cf c0177cf) {
        this.f796a = ln;
        this.b = v;
        this.c = g6;
        this.d = kl;
        this.e = c0151bf;
        this.f = c0177cf;
    }

    public final Zg a(C0678w6 c0678w6) {
        throw new UnsupportedOperationException();
    }
}
