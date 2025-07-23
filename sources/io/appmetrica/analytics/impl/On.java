package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.List;
/* loaded from: classes4.dex */
public final class On implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cn f584a;
    public final V b;
    public final D6 c;
    public final Bl d;
    public final Ve e;
    public final We f;

    public On() {
        this(new Cn(), new V(new C0642un()), new D6(), new Bl(), new Ve(), new We());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0550r6 fromModel(Nn nn) {
        C0550r6 c0550r6 = new C0550r6();
        Dn dn = nn.f568a;
        if (dn != null) {
            c0550r6.f1032a = this.f584a.fromModel(dn);
        }
        U u = nn.b;
        if (u != null) {
            c0550r6.b = this.b.fromModel(u);
        }
        List<Dl> list = nn.c;
        if (list != null) {
            c0550r6.e = this.d.fromModel(list);
        }
        String str = nn.g;
        if (str != null) {
            c0550r6.c = str;
        }
        c0550r6.d = this.c.a(nn.h);
        if (!TextUtils.isEmpty(nn.d)) {
            c0550r6.h = this.e.fromModel(nn.d);
        }
        if (!TextUtils.isEmpty(nn.e)) {
            c0550r6.i = nn.e.getBytes();
        }
        if (!io.a(nn.f)) {
            c0550r6.j = this.f.fromModel(nn.f);
        }
        return c0550r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0550r6 c0550r6 = (C0550r6) obj;
        throw new UnsupportedOperationException();
    }

    public On(Cn cn, V v, D6 d6, Bl bl, Ve ve, We we) {
        this.b = v;
        this.f584a = cn;
        this.c = d6;
        this.d = bl;
        this.e = ve;
        this.f = we;
    }

    public final Nn a(C0550r6 c0550r6) {
        throw new UnsupportedOperationException();
    }
}
