package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes3.dex */
public final class Hn implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Fl f513a;

    public Hn() {
        this(new Fl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0315i6 fromModel(In in) {
        C0315i6 c0315i6 = new C0315i6();
        c0315i6.f926a = (String) WrapUtils.getOrDefault(in.f534a, "");
        c0315i6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(in.b, ""));
        List<Hl> list = in.c;
        if (list != null) {
            c0315i6.c = this.f513a.fromModel(list);
        }
        In in2 = in.d;
        if (in2 != null) {
            c0315i6.d = fromModel(in2);
        }
        List<In> list2 = in.e;
        int i = 0;
        if (list2 == null) {
            c0315i6.e = new C0315i6[0];
            return c0315i6;
        }
        c0315i6.e = new C0315i6[list2.size()];
        for (In in3 : list2) {
            c0315i6.e[i] = fromModel(in3);
            i++;
        }
        return c0315i6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0315i6 c0315i6 = (C0315i6) obj;
        throw new UnsupportedOperationException();
    }

    public Hn(Fl fl) {
        this.f513a = fl;
    }

    public final In a(C0315i6 c0315i6) {
        throw new UnsupportedOperationException();
    }
}
