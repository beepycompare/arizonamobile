package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes5.dex */
public final class Sn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Gn f781a;
    public final W b;
    public final C0314i6 c;
    public final Cl d;
    public final Ie e;
    public final Je f;

    public Sn() {
        this(new Gn(), new W(new C0732yn()), new C0314i6(), new Cl(), new Ie(), new Je());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W5 fromModel(Rn rn) {
        W5 w5 = new W5();
        Hn hn = rn.f764a;
        if (hn != null) {
            w5.f833a = this.f781a.fromModel(hn);
        }
        V v = rn.b;
        if (v != null) {
            w5.b = this.b.fromModel(v);
        }
        List<El> list = rn.c;
        if (list != null) {
            w5.e = this.d.fromModel(list);
        }
        String str = rn.g;
        if (str != null) {
            w5.c = str;
        }
        w5.d = this.c.a(rn.h);
        if (!TextUtils.isEmpty(rn.d)) {
            w5.h = this.e.fromModel(rn.d);
        }
        if (!TextUtils.isEmpty(rn.e)) {
            w5.i = rn.e.getBytes();
        }
        if (!mo.a(rn.f)) {
            w5.j = this.f.fromModel(rn.f);
        }
        return w5;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        W5 w5 = (W5) obj;
        throw new UnsupportedOperationException();
    }

    public Sn(Gn gn, W w, C0314i6 c0314i6, Cl cl, Ie ie, Je je) {
        this.b = w;
        this.f781a = gn;
        this.c = c0314i6;
        this.d = cl;
        this.e = ie;
        this.f = je;
    }

    public final Rn a(W5 w5) {
        throw new UnsupportedOperationException();
    }
}
