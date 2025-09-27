package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0126ah implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ln f796a;
    public final V b;
    public final G6 c;
    public final Kl d;
    public final C0150bf e;
    public final C0176cf f;

    public C0126ah() {
        this(new Ln(), new V(new Dn()), new G6(), new Kl(), new C0150bf(), new C0176cf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0677w6 fromModel(Zg zg) {
        C0677w6 c0677w6 = new C0677w6();
        c0677w6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(zg.f776a, c0677w6.f));
        Wn wn = zg.b;
        if (wn != null) {
            Mn mn = wn.f732a;
            if (mn != null) {
                c0677w6.f1136a = this.f796a.fromModel(mn);
            }
            U u = wn.b;
            if (u != null) {
                c0677w6.b = this.b.fromModel(u);
            }
            List<Ml> list = wn.c;
            if (list != null) {
                c0677w6.e = this.d.fromModel(list);
            }
            c0677w6.c = (String) WrapUtils.getOrDefault(wn.g, c0677w6.c);
            c0677w6.d = this.c.a(wn.h);
            if (!TextUtils.isEmpty(wn.d)) {
                c0677w6.i = this.e.fromModel(wn.d);
            }
            if (!TextUtils.isEmpty(wn.e)) {
                c0677w6.j = wn.e.getBytes();
            }
            if (!ro.a(wn.f)) {
                c0677w6.k = this.f.fromModel(wn.f);
            }
        }
        return c0677w6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0677w6 c0677w6 = (C0677w6) obj;
        throw new UnsupportedOperationException();
    }

    public C0126ah(Ln ln, V v, G6 g6, Kl kl, C0150bf c0150bf, C0176cf c0176cf) {
        this.f796a = ln;
        this.b = v;
        this.c = g6;
        this.d = kl;
        this.e = c0150bf;
        this.f = c0176cf;
    }

    public final Zg a(C0677w6 c0677w6) {
        throw new UnsupportedOperationException();
    }
}
