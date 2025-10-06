package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Xn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ln f749a;
    public final V b;
    public final G6 c;
    public final Kl d;
    public final C0151bf e;
    public final C0177cf f;

    public Xn() {
        this(new Ln(), new V(new Dn()), new G6(), new Kl(), new C0151bf(), new C0177cf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0628u6 fromModel(Wn wn) {
        C0628u6 c0628u6 = new C0628u6();
        Mn mn = wn.f732a;
        if (mn != null) {
            c0628u6.f1107a = this.f749a.fromModel(mn);
        }
        U u = wn.b;
        if (u != null) {
            c0628u6.b = this.b.fromModel(u);
        }
        List<Ml> list = wn.c;
        if (list != null) {
            c0628u6.e = this.d.fromModel(list);
        }
        String str = wn.g;
        if (str != null) {
            c0628u6.c = str;
        }
        c0628u6.d = this.c.a(wn.h);
        if (!TextUtils.isEmpty(wn.d)) {
            c0628u6.h = this.e.fromModel(wn.d);
        }
        if (!TextUtils.isEmpty(wn.e)) {
            c0628u6.i = wn.e.getBytes();
        }
        if (!ro.a(wn.f)) {
            c0628u6.j = this.f.fromModel(wn.f);
        }
        return c0628u6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0628u6 c0628u6 = (C0628u6) obj;
        throw new UnsupportedOperationException();
    }

    public Xn(Ln ln, V v, G6 g6, Kl kl, C0151bf c0151bf, C0177cf c0177cf) {
        this.b = v;
        this.f749a = ln;
        this.c = g6;
        this.d = kl;
        this.e = c0151bf;
        this.f = c0177cf;
    }

    public final Wn a(C0628u6 c0628u6) {
        throw new UnsupportedOperationException();
    }
}
