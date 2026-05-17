package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes5.dex */
public final class Rn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Fn f776a;
    public final W b;
    public final C0292h6 c;
    public final Bl d;
    public final He e;
    public final Ie f;

    public Rn() {
        this(new Fn(), new W(new C0710xn()), new C0292h6(), new Bl(), new He(), new Ie());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final V5 fromModel(Qn qn) {
        V5 v5 = new V5();
        Gn gn = qn.f760a;
        if (gn != null) {
            v5.f828a = this.f776a.fromModel(gn);
        }
        V v = qn.b;
        if (v != null) {
            v5.b = this.b.fromModel(v);
        }
        List<Dl> list = qn.c;
        if (list != null) {
            v5.e = this.d.fromModel(list);
        }
        String str = qn.g;
        if (str != null) {
            v5.c = str;
        }
        v5.d = this.c.a(qn.h);
        if (!TextUtils.isEmpty(qn.d)) {
            v5.h = this.e.fromModel(qn.d);
        }
        if (!TextUtils.isEmpty(qn.e)) {
            v5.i = qn.e.getBytes();
        }
        if (!lo.a(qn.f)) {
            v5.j = this.f.fromModel(qn.f);
        }
        return v5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        V5 v5 = (V5) obj;
        throw new UnsupportedOperationException();
    }

    public Rn(Fn fn, W w, C0292h6 c0292h6, Bl bl, He he, Ie ie) {
        this.b = w;
        this.f776a = fn;
        this.c = c0292h6;
        this.d = bl;
        this.e = he;
        this.f = ie;
    }

    public final Qn a(V5 v5) {
        throw new UnsupportedOperationException();
    }
}
