package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Rg implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cn f624a;
    public final V b;
    public final D6 c;
    public final Bl d;
    public final Ve e;
    public final We f;

    public Rg() {
        this(new Cn(), new V(new C0643un()), new D6(), new Bl(), new Ve(), new We());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0601t6 fromModel(Qg qg) {
        C0601t6 c0601t6 = new C0601t6();
        c0601t6.f = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(qg.f611a, c0601t6.f));
        Nn nn = qg.b;
        if (nn != null) {
            Dn dn = nn.f568a;
            if (dn != null) {
                c0601t6.f1060a = this.f624a.fromModel(dn);
            }
            U u = nn.b;
            if (u != null) {
                c0601t6.b = this.b.fromModel(u);
            }
            List<Dl> list = nn.c;
            if (list != null) {
                c0601t6.e = this.d.fromModel(list);
            }
            c0601t6.c = (String) WrapUtils.getOrDefault(nn.g, c0601t6.c);
            c0601t6.d = this.c.a(nn.h);
            if (!TextUtils.isEmpty(nn.d)) {
                c0601t6.i = this.e.fromModel(nn.d);
            }
            if (!TextUtils.isEmpty(nn.e)) {
                c0601t6.j = nn.e.getBytes();
            }
            if (!io.a(nn.f)) {
                c0601t6.k = this.f.fromModel(nn.f);
            }
        }
        return c0601t6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0601t6 c0601t6 = (C0601t6) obj;
        throw new UnsupportedOperationException();
    }

    public Rg(Cn cn, V v, D6 d6, Bl bl, Ve ve, We we) {
        this.f624a = cn;
        this.b = v;
        this.c = d6;
        this.d = bl;
        this.e = ve;
        this.f = we;
    }

    public final Qg a(C0601t6 c0601t6) {
        throw new UnsupportedOperationException();
    }
}
