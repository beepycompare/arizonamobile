package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Hn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Gl f483a;

    public Hn() {
        this(new Gl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0698x6 fromModel(In in) {
        C0698x6 c0698x6 = new C0698x6();
        c0698x6.f1136a = (String) WrapUtils.getOrDefault(in.f503a, "");
        c0698x6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(in.b, ""));
        List<Il> list = in.c;
        if (list != null) {
            c0698x6.c = this.f483a.fromModel(list);
        }
        In in2 = in.d;
        if (in2 != null) {
            c0698x6.d = fromModel(in2);
        }
        List<In> list2 = in.e;
        int i = 0;
        if (list2 == null) {
            c0698x6.e = new C0698x6[0];
            return c0698x6;
        }
        c0698x6.e = new C0698x6[list2.size()];
        for (In in3 : list2) {
            c0698x6.e[i] = fromModel(in3);
            i++;
        }
        return c0698x6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0698x6 c0698x6 = (C0698x6) obj;
        throw new UnsupportedOperationException();
    }

    public Hn(Gl gl) {
        this.f483a = gl;
    }

    public final In a(C0698x6 c0698x6) {
        throw new UnsupportedOperationException();
    }
}
