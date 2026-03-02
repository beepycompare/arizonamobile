package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Eg implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Fn f568a;
    public final W b;
    public final C0292h6 c;
    public final Bl d;
    public final He e;
    public final Ie f;

    public Eg() {
        this(new Fn(), new W(new C0710xn()), new C0292h6(), new Bl(), new He(), new Ie());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final X5 fromModel(Dg dg) {
        X5 x5 = new X5();
        x5.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(dg.f551a, x5.f));
        Qn qn = dg.b;
        if (qn != null) {
            Gn gn = qn.f755a;
            if (gn != null) {
                x5.f849a = this.f568a.fromModel(gn);
            }
            V v = qn.b;
            if (v != null) {
                x5.b = this.b.fromModel(v);
            }
            List<Dl> list = qn.c;
            if (list != null) {
                x5.e = this.d.fromModel(list);
            }
            x5.c = (String) WrapUtils.getOrDefault(qn.g, x5.c);
            x5.d = this.c.a(qn.h);
            if (!TextUtils.isEmpty(qn.d)) {
                x5.i = this.e.fromModel(qn.d);
            }
            if (!TextUtils.isEmpty(qn.e)) {
                x5.j = qn.e.getBytes();
            }
            if (!lo.a(qn.f)) {
                x5.k = this.f.fromModel(qn.f);
            }
        }
        return x5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        X5 x5 = (X5) obj;
        throw new UnsupportedOperationException();
    }

    public Eg(Fn fn, W w, C0292h6 c0292h6, Bl bl, He he, Ie ie) {
        this.f568a = fn;
        this.b = w;
        this.c = c0292h6;
        this.d = bl;
        this.e = he;
        this.f = ie;
    }

    public final Dg a(X5 x5) {
        throw new UnsupportedOperationException();
    }
}
