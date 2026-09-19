package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.io  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0335io implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0205dm f1043a;

    public C0335io() {
        this(new C0205dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0550r6 fromModel(C0361jo c0361jo) {
        C0550r6 c0550r6 = new C0550r6();
        c0550r6.f1180a = (String) WrapUtils.getOrDefault(c0361jo.f1058a, "");
        c0550r6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(c0361jo.b, ""));
        List<C0256fm> list = c0361jo.c;
        if (list != null) {
            c0550r6.c = this.f1043a.fromModel(list);
        }
        C0361jo c0361jo2 = c0361jo.d;
        if (c0361jo2 != null) {
            c0550r6.d = fromModel(c0361jo2);
        }
        List<C0361jo> list2 = c0361jo.e;
        int i = 0;
        if (list2 == null) {
            c0550r6.e = new C0550r6[0];
            return c0550r6;
        }
        c0550r6.e = new C0550r6[list2.size()];
        for (C0361jo c0361jo3 : list2) {
            c0550r6.e[i] = fromModel(c0361jo3);
            i++;
        }
        return c0550r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0550r6 c0550r6 = (C0550r6) obj;
        throw new UnsupportedOperationException();
    }

    public C0335io(C0205dm c0205dm) {
        this.f1043a = c0205dm;
    }

    public final C0361jo a(C0550r6 c0550r6) {
        throw new UnsupportedOperationException();
    }
}
