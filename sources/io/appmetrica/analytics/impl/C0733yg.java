package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0733yg implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0537qj f1160a;
    public final Pa b;
    public final Pa c;

    public C0733yg() {
        this(new C0537qj(), new Pa(100), new Pa(2048));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Vi fromModel(Pg pg) {
        Vi vi;
        L8 l8 = new L8();
        On a2 = this.b.a(pg.f606a);
        l8.f539a = StringUtils.getUTF8Bytes((String) a2.f594a);
        On a3 = this.c.a(pg.b);
        l8.b = StringUtils.getUTF8Bytes((String) a3.f594a);
        C0636uj c0636uj = pg.c;
        if (c0636uj != null) {
            vi = this.f1160a.fromModel(c0636uj);
            l8.c = (M8) vi.f697a;
        } else {
            vi = null;
        }
        return new Vi(l8, new C0670w3(C0670w3.b(a2, a3, vi)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Vi vi = (Vi) obj;
        throw new UnsupportedOperationException();
    }

    public C0733yg(C0537qj c0537qj, Pa pa, Pa pa2) {
        this.f1160a = c0537qj;
        this.b = pa;
        this.c = pa2;
    }

    public final Pg a(Vi vi) {
        throw new UnsupportedOperationException();
    }
}
