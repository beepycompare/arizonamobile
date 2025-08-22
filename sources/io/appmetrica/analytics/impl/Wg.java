package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Wg implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Hn f711a;
    public final V b;
    public final D6 c;
    public final Gl d;
    public final Xe e;
    public final Ye f;

    public Wg() {
        this(new Hn(), new V(new C0765zn()), new D6(), new Gl(), new Xe(), new Ye());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0598t6 fromModel(Vg vg) {
        C0598t6 c0598t6 = new C0598t6();
        c0598t6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(vg.f696a, c0598t6.f));
        Sn sn = vg.b;
        if (sn != null) {
            In in = sn.f652a;
            if (in != null) {
                c0598t6.f1070a = this.f711a.fromModel(in);
            }
            U u = sn.b;
            if (u != null) {
                c0598t6.b = this.b.fromModel(u);
            }
            List<Il> list = sn.c;
            if (list != null) {
                c0598t6.e = this.d.fromModel(list);
            }
            c0598t6.c = (String) WrapUtils.getOrDefault(sn.g, c0598t6.c);
            c0598t6.d = this.c.a(sn.h);
            if (!TextUtils.isEmpty(sn.d)) {
                c0598t6.i = this.e.fromModel(sn.d);
            }
            if (!TextUtils.isEmpty(sn.e)) {
                c0598t6.j = sn.e.getBytes();
            }
            if (!no.a(sn.f)) {
                c0598t6.k = this.f.fromModel(sn.f);
            }
        }
        return c0598t6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0598t6 c0598t6 = (C0598t6) obj;
        throw new UnsupportedOperationException();
    }

    public Wg(Hn hn, V v, D6 d6, Gl gl, Xe xe, Ye ye) {
        this.f711a = hn;
        this.b = v;
        this.c = d6;
        this.d = gl;
        this.e = xe;
        this.f = ye;
    }

    public final Vg a(C0598t6 c0598t6) {
        throw new UnsupportedOperationException();
    }
}
