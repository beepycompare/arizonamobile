package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.zn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0773zn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0746yl f1172a;

    public C0773zn() {
        this(new C0746yl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0631u6 fromModel(An an) {
        C0631u6 c0631u6 = new C0631u6();
        c0631u6.f1068a = (String) WrapUtils.getOrDefault(an.f342a, "");
        c0631u6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(an.b, ""));
        List<Al> list = an.c;
        if (list != null) {
            c0631u6.c = this.f1172a.fromModel(list);
        }
        An an2 = an.d;
        if (an2 != null) {
            c0631u6.d = fromModel(an2);
        }
        List<An> list2 = an.e;
        int i = 0;
        if (list2 == null) {
            c0631u6.e = new C0631u6[0];
            return c0631u6;
        }
        c0631u6.e = new C0631u6[list2.size()];
        for (An an3 : list2) {
            c0631u6.e[i] = fromModel(an3);
            i++;
        }
        return c0631u6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0631u6 c0631u6 = (C0631u6) obj;
        throw new UnsupportedOperationException();
    }

    public C0773zn(C0746yl c0746yl) {
        this.f1172a = c0746yl;
    }

    public final An a(C0631u6 c0631u6) {
        throw new UnsupportedOperationException();
    }
}
