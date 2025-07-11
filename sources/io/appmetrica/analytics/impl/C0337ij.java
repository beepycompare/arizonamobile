package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ij  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0337ij implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ee f880a;
    public final H3 b;
    public final La c;
    public final La d;

    public C0337ij() {
        this(new Ee(), new H3(), new La(100), new La(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(C0437mj c0437mj) {
        Ni ni;
        H8 h8 = new H8();
        Gn a2 = this.c.a(c0437mj.f943a);
        h8.f458a = StringUtils.getUTF8Bytes((String) a2.f450a);
        List<String> list = c0437mj.b;
        Ni ni2 = null;
        if (list != null) {
            ni = this.b.fromModel(list);
            h8.b = (C0675w8) ni.f557a;
        } else {
            ni = null;
        }
        Gn a3 = this.d.a(c0437mj.c);
        h8.c = StringUtils.getUTF8Bytes((String) a3.f450a);
        Map<String, String> map = c0437mj.d;
        if (map != null) {
            ni2 = this.f880a.fromModel(map);
            h8.d = (C8) ni2.f557a;
        }
        return new Ni(h8, new C0670w3(C0670w3.b(a2, ni, a3, ni2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public C0337ij(Ee ee, H3 h3, La la, La la2) {
        this.f880a = ee;
        this.b = h3;
        this.c = la;
        this.d = la2;
    }

    public final C0437mj a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
