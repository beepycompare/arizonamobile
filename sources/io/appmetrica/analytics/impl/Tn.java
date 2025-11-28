package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes5.dex */
public final class Tn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Hn f712a;
    public final W b;
    public final C0467o6 c;
    public final Fl d;
    public final Me e;
    public final Ne f;

    public Tn() {
        this(new Hn(), new W(new C0758zn()), new C0467o6(), new Fl(), new Me(), new Ne());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0160c6 fromModel(Sn sn) {
        C0160c6 c0160c6 = new C0160c6();
        In in = sn.f691a;
        if (in != null) {
            c0160c6.f825a = this.f712a.fromModel(in);
        }
        V v = sn.b;
        if (v != null) {
            c0160c6.b = this.b.fromModel(v);
        }
        List<Hl> list = sn.c;
        if (list != null) {
            c0160c6.e = this.d.fromModel(list);
        }
        String str = sn.g;
        if (str != null) {
            c0160c6.c = str;
        }
        c0160c6.d = this.c.a(sn.h);
        if (!TextUtils.isEmpty(sn.d)) {
            c0160c6.h = this.e.fromModel(sn.d);
        }
        if (!TextUtils.isEmpty(sn.e)) {
            c0160c6.i = sn.e.getBytes();
        }
        if (!no.a(sn.f)) {
            c0160c6.j = this.f.fromModel(sn.f);
        }
        return c0160c6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0160c6 c0160c6 = (C0160c6) obj;
        throw new UnsupportedOperationException();
    }

    public Tn(Hn hn, W w, C0467o6 c0467o6, Fl fl, Me me2, Ne ne) {
        this.b = w;
        this.f712a = hn;
        this.c = c0467o6;
        this.d = fl;
        this.e = me2;
        this.f = ne;
    }

    public final Sn a(C0160c6 c0160c6) {
        throw new UnsupportedOperationException();
    }
}
