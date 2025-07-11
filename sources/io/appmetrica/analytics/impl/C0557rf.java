package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0557rf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Df f1026a;
    public final C0433mf b;

    public C0557rf() {
        this(new Df(), new C0433mf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0757zf fromModel(C0508pf c0508pf) {
        C0757zf c0757zf = new C0757zf();
        c0757zf.f1167a = this.f1026a.fromModel(c0508pf.f991a);
        c0757zf.b = new C0732yf[c0508pf.b.size()];
        int i = 0;
        for (C0483of c0483of : c0508pf.b) {
            c0757zf.b[i] = this.b.fromModel(c0483of);
            i++;
        }
        return c0757zf;
    }

    public C0557rf(Df df, C0433mf c0433mf) {
        this.f1026a = df;
        this.b = c0433mf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0508pf toModel(C0757zf c0757zf) {
        Cf model;
        ArrayList arrayList = new ArrayList(c0757zf.b.length);
        for (C0732yf c0732yf : c0757zf.b) {
            arrayList.add(this.b.toModel(c0732yf));
        }
        C0707xf c0707xf = c0757zf.f1167a;
        if (c0707xf == null) {
            model = this.f1026a.toModel(new C0707xf());
        } else {
            model = this.f1026a.toModel(c0707xf);
        }
        return new C0508pf(model, arrayList);
    }
}
