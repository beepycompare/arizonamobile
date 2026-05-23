package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.io  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0337io implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0207dm f1040a;

    public C0337io() {
        this(new C0207dm());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0552r6 fromModel(C0363jo c0363jo) {
        C0552r6 c0552r6 = new C0552r6();
        c0552r6.f1177a = (String) WrapUtils.getOrDefault(c0363jo.f1055a, "");
        c0552r6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(c0363jo.b, ""));
        List<C0258fm> list = c0363jo.c;
        if (list != null) {
            c0552r6.c = this.f1040a.fromModel(list);
        }
        C0363jo c0363jo2 = c0363jo.d;
        if (c0363jo2 != null) {
            c0552r6.d = fromModel(c0363jo2);
        }
        List<C0363jo> list2 = c0363jo.e;
        int i = 0;
        if (list2 == null) {
            c0552r6.e = new C0552r6[0];
            return c0552r6;
        }
        c0552r6.e = new C0552r6[list2.size()];
        for (C0363jo c0363jo3 : list2) {
            c0552r6.e[i] = fromModel(c0363jo3);
            i++;
        }
        return c0552r6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0552r6 c0552r6 = (C0552r6) obj;
        throw new UnsupportedOperationException();
    }

    public C0337io(C0207dm c0207dm) {
        this.f1040a = c0207dm;
    }

    public final C0363jo a(C0552r6 c0552r6) {
        throw new UnsupportedOperationException();
    }
}
