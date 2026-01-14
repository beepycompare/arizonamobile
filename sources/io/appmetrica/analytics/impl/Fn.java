package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Fn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Bl f586a;

    public Fn() {
        this(new Bl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0138b6 fromModel(Gn gn) {
        C0138b6 c0138b6 = new C0138b6();
        c0138b6.f914a = (String) WrapUtils.getOrDefault(gn.f604a, "");
        c0138b6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(gn.b, ""));
        List<Dl> list = gn.c;
        if (list != null) {
            c0138b6.c = this.f586a.fromModel(list);
        }
        Gn gn2 = gn.d;
        if (gn2 != null) {
            c0138b6.d = fromModel(gn2);
        }
        List<Gn> list2 = gn.e;
        int i = 0;
        if (list2 == null) {
            c0138b6.e = new C0138b6[0];
            return c0138b6;
        }
        c0138b6.e = new C0138b6[list2.size()];
        for (Gn gn3 : list2) {
            c0138b6.e[i] = fromModel(gn3);
            i++;
        }
        return c0138b6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0138b6 c0138b6 = (C0138b6) obj;
        throw new UnsupportedOperationException();
    }

    public Fn(Bl bl) {
        this.f586a = bl;
    }

    public final Gn a(C0138b6 c0138b6) {
        throw new UnsupportedOperationException();
    }
}
