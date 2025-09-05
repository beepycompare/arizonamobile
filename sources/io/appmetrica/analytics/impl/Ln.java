package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Ln implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Kl f561a;

    public Ln() {
        this(new Kl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A6 fromModel(Mn mn) {
        A6 a6 = new A6();
        a6.f341a = (String) WrapUtils.getOrDefault(mn.f579a, "");
        a6.b = StringUtils.correctIllFormedString((String) WrapUtils.getOrDefault(mn.b, ""));
        List<Ml> list = mn.c;
        if (list != null) {
            a6.c = this.f561a.fromModel(list);
        }
        Mn mn2 = mn.d;
        if (mn2 != null) {
            a6.d = fromModel(mn2);
        }
        List<Mn> list2 = mn.e;
        int i = 0;
        if (list2 == null) {
            a6.e = new A6[0];
            return a6;
        }
        a6.e = new A6[list2.size()];
        for (Mn mn3 : list2) {
            a6.e[i] = fromModel(mn3);
            i++;
        }
        return a6;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        A6 a6 = (A6) obj;
        throw new UnsupportedOperationException();
    }

    public Ln(Kl kl) {
        this.f561a = kl;
    }

    public final Mn a(A6 a6) {
        throw new UnsupportedOperationException();
    }
}
