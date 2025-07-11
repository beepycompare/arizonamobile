package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.zn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0765zn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0738yl f1173a;

    public C0765zn() {
        this(new C0738yl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0623u6 fromModel(An an) {
        C0623u6 c0623u6 = new C0623u6();
        c0623u6.f1069a = (String) WrapUtils.getOrDefault(an.f343a, "");
        c0623u6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(an.b, ""));
        List<Al> list = an.c;
        if (list != null) {
            c0623u6.c = this.f1173a.fromModel(list);
        }
        An an2 = an.d;
        if (an2 != null) {
            c0623u6.d = fromModel(an2);
        }
        List<An> list2 = an.e;
        int i = 0;
        if (list2 == null) {
            c0623u6.e = new C0623u6[0];
            return c0623u6;
        }
        c0623u6.e = new C0623u6[list2.size()];
        for (An an3 : list2) {
            c0623u6.e[i] = fromModel(an3);
            i++;
        }
        return c0623u6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0623u6 c0623u6 = (C0623u6) obj;
        throw new UnsupportedOperationException();
    }

    public C0765zn(C0738yl c0738yl) {
        this.f1173a = c0738yl;
    }

    public final An a(C0623u6 c0623u6) {
        throw new UnsupportedOperationException();
    }
}
