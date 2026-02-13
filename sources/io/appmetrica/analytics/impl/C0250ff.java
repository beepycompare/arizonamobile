package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.ff  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0250ff implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0553rf f994a;
    public final C0121af b;

    public C0250ff() {
        this(new C0553rf(), new C0121af());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0454nf fromModel(C0199df c0199df) {
        C0454nf c0454nf = new C0454nf();
        c0454nf.f1136a = this.f994a.fromModel(c0199df.f958a);
        c0454nf.b = new C0429mf[c0199df.b.size()];
        int i = 0;
        for (C0173cf c0173cf : c0199df.b) {
            c0454nf.b[i] = this.b.fromModel(c0173cf);
            i++;
        }
        return c0454nf;
    }

    public C0250ff(C0553rf c0553rf, C0121af c0121af) {
        this.f994a = c0553rf;
        this.b = c0121af;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0199df toModel(C0454nf c0454nf) {
        C0529qf model;
        ArrayList arrayList = new ArrayList(c0454nf.b.length);
        for (C0429mf c0429mf : c0454nf.b) {
            arrayList.add(this.b.toModel(c0429mf));
        }
        C0404lf c0404lf = c0454nf.f1136a;
        if (c0404lf == null) {
            model = this.f994a.toModel(new C0404lf());
        } else {
            model = this.f994a.toModel(c0404lf);
        }
        return new C0199df(model, arrayList);
    }
}
