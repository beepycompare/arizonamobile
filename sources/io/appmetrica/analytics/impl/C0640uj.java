package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.uj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0640uj implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Me f1115a;
    public final K3 b;
    public final Sa c;
    public final Sa d;

    public C0640uj() {
        this(new Me(), new K3(), new Sa(100), new Sa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Zi fromModel(C0740yj c0740yj) {
        Zi zi;
        P8 p8 = new P8();
        Sn a2 = this.c.a(c0740yj.f1174a);
        p8.f623a = StringUtils.getUTF8Bytes((String) a2.f676a);
        List<String> list = c0740yj.b;
        Zi zi2 = null;
        if (list != null) {
            zi = this.b.fromModel(list);
            p8.b = (E8) zi.f777a;
        } else {
            zi = null;
        }
        Sn a3 = this.d.a(c0740yj.c);
        p8.c = StringUtils.getUTF8Bytes((String) a3.f676a);
        Map<String, String> map = c0740yj.d;
        if (map != null) {
            zi2 = this.f1115a.fromModel(map);
            p8.d = (K8) zi2.f777a;
        }
        return new Zi(p8, new C0749z3(C0749z3.b(a2, zi, a3, zi2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Zi zi = (Zi) obj;
        throw new UnsupportedOperationException();
    }

    public C0640uj(Me me2, K3 k3, Sa sa, Sa sa2) {
        this.f1115a = me2;
        this.b = k3;
        this.c = sa;
        this.d = sa2;
    }

    public final C0740yj a(Zi zi) {
        throw new UnsupportedOperationException();
    }
}
