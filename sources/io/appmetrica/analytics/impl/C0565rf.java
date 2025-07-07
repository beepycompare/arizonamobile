package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0565rf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Df f1025a;
    public final C0441mf b;

    public C0565rf() {
        this(new Df(), new C0441mf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0765zf fromModel(C0516pf c0516pf) {
        C0765zf c0765zf = new C0765zf();
        c0765zf.f1166a = this.f1025a.fromModel(c0516pf.f990a);
        c0765zf.b = new C0740yf[c0516pf.b.size()];
        int i = 0;
        for (C0491of c0491of : c0516pf.b) {
            c0765zf.b[i] = this.b.fromModel(c0491of);
            i++;
        }
        return c0765zf;
    }

    public C0565rf(Df df, C0441mf c0441mf) {
        this.f1025a = df;
        this.b = c0441mf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0516pf toModel(C0765zf c0765zf) {
        Cf model;
        ArrayList arrayList = new ArrayList(c0765zf.b.length);
        for (C0740yf c0740yf : c0765zf.b) {
            arrayList.add(this.b.toModel(c0740yf));
        }
        C0715xf c0715xf = c0765zf.f1166a;
        if (c0715xf == null) {
            model = this.f1025a.toModel(new C0715xf());
        } else {
            model = this.f1025a.toModel(c0715xf);
        }
        return new C0516pf(model, arrayList);
    }
}
