package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.dj  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0199dj implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0724ye f849a;
    public final C0588t3 b;
    public final C0745za c;
    public final C0745za d;

    public C0199dj() {
        this(new C0724ye(), new C0588t3(), new C0745za(100), new C0745za(1000));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ii fromModel(C0302hj c0302hj) {
        Ii ii;
        C0668w8 c0668w8 = new C0668w8();
        On a2 = this.c.a(c0302hj.f914a);
        c0668w8.f1182a = StringUtils.getUTF8Bytes((String) a2.f625a);
        List<String> list = c0302hj.b;
        Ii ii2 = null;
        if (list != null) {
            ii = this.b.fromModel(list);
            c0668w8.b = (C0394l8) ii.f530a;
        } else {
            ii = null;
        }
        On a3 = this.d.a(c0302hj.c);
        c0668w8.c = StringUtils.getUTF8Bytes((String) a3.f625a);
        Map<String, String> map = c0302hj.d;
        if (map != null) {
            ii2 = this.f849a.fromModel(map);
            c0668w8.d = (C0543r8) ii2.f530a;
        }
        return new Ii(c0668w8, new C0312i3(C0312i3.b(a2, ii, a3, ii2)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ii ii = (Ii) obj;
        throw new UnsupportedOperationException();
    }

    public C0199dj(C0724ye c0724ye, C0588t3 c0588t3, C0745za c0745za, C0745za c0745za2) {
        this.f849a = c0724ye;
        this.b = c0588t3;
        this.c = c0745za;
        this.d = c0745za2;
    }

    public final C0302hj a(Ii ii) {
        throw new UnsupportedOperationException();
    }
}
