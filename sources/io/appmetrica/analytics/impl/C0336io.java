package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.io  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0336io implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0206dm f1043a;

    public C0336io() {
        this(new C0206dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0551r6 fromModel(C0362jo c0362jo) {
        C0551r6 c0551r6 = new C0551r6();
        c0551r6.f1180a = (String) WrapUtils.getOrDefault(c0362jo.f1058a, "");
        c0551r6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(c0362jo.b, ""));
        List<C0257fm> list = c0362jo.c;
        if (list != null) {
            c0551r6.c = this.f1043a.fromModel(list);
        }
        C0362jo c0362jo2 = c0362jo.d;
        if (c0362jo2 != null) {
            c0551r6.d = fromModel(c0362jo2);
        }
        List<C0362jo> list2 = c0362jo.e;
        int i = 0;
        if (list2 == null) {
            c0551r6.e = new C0551r6[0];
            return c0551r6;
        }
        c0551r6.e = new C0551r6[list2.size()];
        for (C0362jo c0362jo3 : list2) {
            c0551r6.e[i] = fromModel(c0362jo3);
            i++;
        }
        return c0551r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0551r6 c0551r6 = (C0551r6) obj;
        throw new UnsupportedOperationException();
    }

    public C0336io(C0206dm c0206dm) {
        this.f1043a = c0206dm;
    }

    public final C0362jo a(C0551r6 c0551r6) {
        throw new UnsupportedOperationException();
    }
}
