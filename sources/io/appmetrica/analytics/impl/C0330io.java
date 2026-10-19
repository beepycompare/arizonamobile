package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.io  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0330io implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0200dm f1046a;

    public C0330io() {
        this(new C0200dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0545r6 fromModel(C0356jo c0356jo) {
        C0545r6 c0545r6 = new C0545r6();
        c0545r6.f1183a = (String) WrapUtils.getOrDefault(c0356jo.f1061a, "");
        c0545r6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(c0356jo.b, ""));
        List<C0251fm> list = c0356jo.c;
        if (list != null) {
            c0545r6.c = this.f1046a.fromModel(list);
        }
        C0356jo c0356jo2 = c0356jo.d;
        if (c0356jo2 != null) {
            c0545r6.d = fromModel(c0356jo2);
        }
        List<C0356jo> list2 = c0356jo.e;
        int i = 0;
        if (list2 == null) {
            c0545r6.e = new C0545r6[0];
            return c0545r6;
        }
        c0545r6.e = new C0545r6[list2.size()];
        for (C0356jo c0356jo3 : list2) {
            c0545r6.e[i] = fromModel(c0356jo3);
            i++;
        }
        return c0545r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0545r6 c0545r6 = (C0545r6) obj;
        throw new UnsupportedOperationException();
    }

    public C0330io(C0200dm c0200dm) {
        this.f1046a = c0200dm;
    }

    public final C0356jo a(C0545r6 c0545r6) {
        throw new UnsupportedOperationException();
    }
}
