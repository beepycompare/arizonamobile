package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class Tn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Hn f667a;
    public final V b;
    public final D6 c;
    public final Gl d;
    public final Xe e;
    public final Ye f;

    public Tn() {
        this(new Hn(), new V(new C0765zn()), new D6(), new Gl(), new Xe(), new Ye());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0548r6 fromModel(Sn sn) {
        C0548r6 c0548r6 = new C0548r6();
        In in = sn.f652a;
        if (in != null) {
            c0548r6.f1040a = this.f667a.fromModel(in);
        }
        U u = sn.b;
        if (u != null) {
            c0548r6.b = this.b.fromModel(u);
        }
        List<Il> list = sn.c;
        if (list != null) {
            c0548r6.e = this.d.fromModel(list);
        }
        String str = sn.g;
        if (str != null) {
            c0548r6.c = str;
        }
        c0548r6.d = this.c.a(sn.h);
        if (!TextUtils.isEmpty(sn.d)) {
            c0548r6.h = this.e.fromModel(sn.d);
        }
        if (!TextUtils.isEmpty(sn.e)) {
            c0548r6.i = sn.e.getBytes();
        }
        if (!no.a(sn.f)) {
            c0548r6.j = this.f.fromModel(sn.f);
        }
        return c0548r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0548r6 c0548r6 = (C0548r6) obj;
        throw new UnsupportedOperationException();
    }

    public Tn(Hn hn, V v, D6 d6, Gl gl, Xe xe, Ye ye) {
        this.b = v;
        this.f667a = hn;
        this.c = d6;
        this.d = gl;
        this.e = xe;
        this.f = ye;
    }

    public final Sn a(C0548r6 c0548r6) {
        throw new UnsupportedOperationException();
    }
}
