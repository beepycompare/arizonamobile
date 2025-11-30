package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.gf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0272gf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0575sf f906a;
    public final C0143bf b;

    public C0272gf() {
        this(new C0575sf(), new C0143bf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0476of fromModel(C0220ef c0220ef) {
        C0476of c0476of = new C0476of();
        c0476of.f1049a = this.f906a.fromModel(c0220ef.f871a);
        c0476of.b = new C0451nf[c0220ef.b.size()];
        int i = 0;
        for (C0195df c0195df : c0220ef.b) {
            c0476of.b[i] = this.b.fromModel(c0195df);
            i++;
        }
        return c0476of;
    }

    public C0272gf(C0575sf c0575sf, C0143bf c0143bf) {
        this.f906a = c0575sf;
        this.b = c0143bf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0220ef toModel(C0476of c0476of) {
        C0550rf model;
        ArrayList arrayList = new ArrayList(c0476of.b.length);
        for (C0451nf c0451nf : c0476of.b) {
            arrayList.add(this.b.toModel(c0451nf));
        }
        C0426mf c0426mf = c0476of.f1049a;
        if (c0426mf == null) {
            model = this.f906a.toModel(new C0426mf());
        } else {
            model = this.f906a.toModel(c0426mf);
        }
        return new C0220ef(model, arrayList);
    }
}
