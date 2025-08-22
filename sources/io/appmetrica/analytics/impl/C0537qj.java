package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0537qj implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ie f1030a;
    public final H3 b;
    public final Pa c;
    public final Pa d;

    public C0537qj() {
        this(new Ie(), new H3(), new Pa(100), new Pa(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(C0636uj c0636uj) {
        Vi vi;
        M8 m8 = new M8();
        On a2 = this.c.a(c0636uj.f1090a);
        m8.f557a = StringUtils.getUTF8Bytes((String) a2.f594a);
        List<String> list = c0636uj.b;
        Vi vi2 = null;
        if (list != null) {
            vi = this.b.fromModel(list);
            m8.b = (B8) vi.f697a;
        } else {
            vi = null;
        }
        On a3 = this.d.a(c0636uj.c);
        m8.c = StringUtils.getUTF8Bytes((String) a3.f594a);
        Map<String, String> map = c0636uj.d;
        if (map != null) {
            vi2 = this.f1030a.fromModel(map);
            m8.d = (H8) vi2.f697a;
        }
        return new Vi(m8, new C0670w3(C0670w3.b(a2, vi, a3, vi2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public C0537qj(Ie ie, H3 h3, Pa pa, Pa pa2) {
        this.f1030a = ie;
        this.b = h3;
        this.c = pa;
        this.d = pa2;
    }

    public final C0636uj a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
