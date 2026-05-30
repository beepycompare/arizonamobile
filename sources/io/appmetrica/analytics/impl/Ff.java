package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class Ff implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Rf f546a;
    public final Af b;

    public Ff() {
        this(new Rf(), new Af());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Nf fromModel(Df df) {
        Nf nf = new Nf();
        nf.f685a = this.f546a.fromModel(df.f513a);
        nf.b = new Mf[df.b.size()];
        int i = 0;
        for (Cf cf : df.b) {
            nf.b[i] = this.b.fromModel(cf);
            i++;
        }
        return nf;
    }

    public Ff(Rf rf, Af af) {
        this.f546a = rf;
        this.b = af;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Df toModel(Nf nf) {
        Qf model;
        ArrayList arrayList = new ArrayList(nf.b.length);
        for (Mf mf : nf.b) {
            arrayList.add(this.b.toModel(mf));
        }
        Lf lf = nf.f685a;
        Rf rf = this.f546a;
        if (lf == null) {
            model = rf.toModel(new Lf());
        } else {
            model = rf.toModel(lf);
        }
        return new Df(model, arrayList);
    }
}
