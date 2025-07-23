package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Cn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bl f384a;

    public Cn() {
        this(new Bl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0700x6 fromModel(Dn dn) {
        C0700x6 c0700x6 = new C0700x6();
        c0700x6.f1131a = (String) WrapUtils.getOrDefault(dn.f403a, "");
        c0700x6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(dn.b, ""));
        List<Dl> list = dn.c;
        if (list != null) {
            c0700x6.c = this.f384a.fromModel(list);
        }
        Dn dn2 = dn.d;
        if (dn2 != null) {
            c0700x6.d = fromModel(dn2);
        }
        List<Dn> list2 = dn.e;
        int i = 0;
        if (list2 == null) {
            c0700x6.e = new C0700x6[0];
            return c0700x6;
        }
        c0700x6.e = new C0700x6[list2.size()];
        for (Dn dn3 : list2) {
            c0700x6.e[i] = fromModel(dn3);
            i++;
        }
        return c0700x6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0700x6 c0700x6 = (C0700x6) obj;
        throw new UnsupportedOperationException();
    }

    public Cn(Bl bl) {
        this.f384a = bl;
    }

    public final Dn a(C0700x6 c0700x6) {
        throw new UnsupportedOperationException();
    }
}
