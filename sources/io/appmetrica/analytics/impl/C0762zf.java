package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0762zf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Lf f1192a;
    public final C0637uf b;

    public C0762zf() {
        this(new Lf(), new C0637uf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Hf fromModel(C0712xf c0712xf) {
        Hf hf = new Hf();
        hf.f479a = this.f1192a.fromModel(c0712xf.f1156a);
        hf.b = new Gf[c0712xf.b.size()];
        int i = 0;
        for (C0687wf c0687wf : c0712xf.b) {
            hf.b[i] = this.b.fromModel(c0687wf);
            i++;
        }
        return hf;
    }

    public C0762zf(Lf lf, C0637uf c0637uf) {
        this.f1192a = lf;
        this.b = c0637uf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0712xf toModel(Hf hf) {
        Kf model;
        ArrayList arrayList = new ArrayList(hf.b.length);
        for (Gf gf : hf.b) {
            arrayList.add(this.b.toModel(gf));
        }
        Ff ff = hf.f479a;
        if (ff == null) {
            model = this.f1192a.toModel(new Ff());
        } else {
            model = this.f1192a.toModel(ff);
        }
        return new C0712xf(model, arrayList);
    }
}
