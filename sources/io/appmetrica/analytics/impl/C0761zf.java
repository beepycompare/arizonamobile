package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.zf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0761zf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Lf f1192a;
    public final C0636uf b;

    public C0761zf() {
        this(new Lf(), new C0636uf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Hf fromModel(C0711xf c0711xf) {
        Hf hf = new Hf();
        hf.f479a = this.f1192a.fromModel(c0711xf.f1156a);
        hf.b = new Gf[c0711xf.b.size()];
        int i = 0;
        for (C0686wf c0686wf : c0711xf.b) {
            hf.b[i] = this.b.fromModel(c0686wf);
            i++;
        }
        return hf;
    }

    public C0761zf(Lf lf, C0636uf c0636uf) {
        this.f1192a = lf;
        this.b = c0636uf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0711xf toModel(Hf hf) {
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
        return new C0711xf(model, arrayList);
    }
}
