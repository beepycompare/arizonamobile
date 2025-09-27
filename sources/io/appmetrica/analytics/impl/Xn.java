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
    public final C0150bf e;
    public final C0176cf f;

    public Xn() {
        this(new Ln(), new V(new Dn()), new G6(), new Kl(), new C0150bf(), new C0176cf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0627u6 fromModel(Wn wn) {
        C0627u6 c0627u6 = new C0627u6();
        Mn mn = wn.f732a;
        if (mn != null) {
            c0627u6.f1107a = this.f749a.fromModel(mn);
        }
        U u = wn.b;
        if (u != null) {
            c0627u6.b = this.b.fromModel(u);
        }
        List<Ml> list = wn.c;
        if (list != null) {
            c0627u6.e = this.d.fromModel(list);
        }
        String str = wn.g;
        if (str != null) {
            c0627u6.c = str;
        }
        c0627u6.d = this.c.a(wn.h);
        if (!TextUtils.isEmpty(wn.d)) {
            c0627u6.h = this.e.fromModel(wn.d);
        }
        if (!TextUtils.isEmpty(wn.e)) {
            c0627u6.i = wn.e.getBytes();
        }
        if (!ro.a(wn.f)) {
            c0627u6.j = this.f.fromModel(wn.f);
        }
        return c0627u6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0627u6 c0627u6 = (C0627u6) obj;
        throw new UnsupportedOperationException();
    }

    public Xn(Ln ln, V v, G6 g6, Kl kl, C0150bf c0150bf, C0176cf c0176cf) {
        this.b = v;
        this.f749a = ln;
        this.c = g6;
        this.d = kl;
        this.e = c0150bf;
        this.f = c0176cf;
    }

    public final Wn a(C0627u6 c0627u6) {
        throw new UnsupportedOperationException();
    }
}
