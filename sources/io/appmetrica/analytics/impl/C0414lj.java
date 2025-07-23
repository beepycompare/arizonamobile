package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.lj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0414lj implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f941a;
    public final H3 b;
    public final Na c;
    public final Na d;

    public C0414lj() {
        this(new Ge(), new H3(), new Na(100), new Na(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(C0514pj c0514pj) {
        Qi qi;
        K8 k8 = new K8();
        Jn a2 = this.c.a(c0514pj.f1004a);
        k8.f518a = StringUtils.getUTF8Bytes((String) a2.f511a);
        List<String> list = c0514pj.b;
        Qi qi2 = null;
        if (list != null) {
            qi = this.b.fromModel(list);
            k8.b = (C0752z8) qi.f612a;
        } else {
            qi = null;
        }
        Jn a3 = this.d.a(c0514pj.c);
        k8.c = StringUtils.getUTF8Bytes((String) a3.f511a);
        Map<String, String> map = c0514pj.d;
        if (map != null) {
            qi2 = this.f941a.fromModel(map);
            k8.d = (F8) qi2.f612a;
        }
        return new Qi(k8, new C0672w3(C0672w3.b(a2, qi, a3, qi2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public C0414lj(Ge ge, H3 h3, Na na, Na na2) {
        this.f941a = ge;
        this.b = h3;
        this.c = na;
        this.d = na2;
    }

    public final C0514pj a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
