package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes3.dex */
public final class Jg implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Hn f547a;
    public final W b;
    public final C0467o6 c;
    public final Fl d;
    public final Me e;
    public final Ne f;

    public Jg() {
        this(new Hn(), new W(new C0758zn()), new C0467o6(), new Fl(), new Me(), new Ne());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0211e6 fromModel(Ig ig) {
        C0211e6 c0211e6 = new C0211e6();
        c0211e6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(ig.f529a, c0211e6.f));
        Sn sn = ig.b;
        if (sn != null) {
            In in = sn.f691a;
            if (in != null) {
                c0211e6.f858a = this.f547a.fromModel(in);
            }
            V v = sn.b;
            if (v != null) {
                c0211e6.b = this.b.fromModel(v);
            }
            List<Hl> list = sn.c;
            if (list != null) {
                c0211e6.e = this.d.fromModel(list);
            }
            c0211e6.c = (String) WrapUtils.getOrDefault(sn.g, c0211e6.c);
            c0211e6.d = this.c.a(sn.h);
            if (!TextUtils.isEmpty(sn.d)) {
                c0211e6.i = this.e.fromModel(sn.d);
            }
            if (!TextUtils.isEmpty(sn.e)) {
                c0211e6.j = sn.e.getBytes();
            }
            if (!no.a(sn.f)) {
                c0211e6.k = this.f.fromModel(sn.f);
            }
        }
        return c0211e6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0211e6 c0211e6 = (C0211e6) obj;
        throw new UnsupportedOperationException();
    }

    public Jg(Hn hn, W w, C0467o6 c0467o6, Fl fl, Me me2, Ne ne) {
        this.f547a = hn;
        this.b = w;
        this.c = c0467o6;
        this.d = fl;
        this.e = me2;
        this.f = ne;
    }

    public final Ig a(C0211e6 c0211e6) {
        throw new UnsupportedOperationException();
    }
}
