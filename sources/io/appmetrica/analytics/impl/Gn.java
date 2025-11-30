package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Gn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Cl f497a;

    public Gn() {
        this(new Cl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0160c6 fromModel(Hn hn) {
        C0160c6 c0160c6 = new C0160c6();
        c0160c6.f825a = (String) WrapUtils.getOrDefault(hn.f514a, "");
        c0160c6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(hn.b, ""));
        List<El> list = hn.c;
        if (list != null) {
            c0160c6.c = this.f497a.fromModel(list);
        }
        Hn hn2 = hn.d;
        if (hn2 != null) {
            c0160c6.d = fromModel(hn2);
        }
        List<Hn> list2 = hn.e;
        int i = 0;
        if (list2 == null) {
            c0160c6.e = new C0160c6[0];
            return c0160c6;
        }
        c0160c6.e = new C0160c6[list2.size()];
        for (Hn hn3 : list2) {
            c0160c6.e[i] = fromModel(hn3);
            i++;
        }
        return c0160c6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0160c6 c0160c6 = (C0160c6) obj;
        throw new UnsupportedOperationException();
    }

    public Gn(Cl cl) {
        this.f497a = cl;
    }

    public final Hn a(C0160c6 c0160c6) {
        throw new UnsupportedOperationException();
    }
}
