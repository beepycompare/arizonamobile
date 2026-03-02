package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.ff  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0249ff implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0552rf f994a;
    public final C0120af b;

    public C0249ff() {
        this(new C0552rf(), new C0120af());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0453nf fromModel(C0198df c0198df) {
        C0453nf c0453nf = new C0453nf();
        c0453nf.f1136a = this.f994a.fromModel(c0198df.f958a);
        c0453nf.b = new C0428mf[c0198df.b.size()];
        int i = 0;
        for (C0172cf c0172cf : c0198df.b) {
            c0453nf.b[i] = this.b.fromModel(c0172cf);
            i++;
        }
        return c0453nf;
    }

    public C0249ff(C0552rf c0552rf, C0120af c0120af) {
        this.f994a = c0552rf;
        this.b = c0120af;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0198df toModel(C0453nf c0453nf) {
        C0528qf model;
        ArrayList arrayList = new ArrayList(c0453nf.b.length);
        for (C0428mf c0428mf : c0453nf.b) {
            arrayList.add(this.b.toModel(c0428mf));
        }
        C0403lf c0403lf = c0453nf.f1136a;
        C0552rf c0552rf = this.f994a;
        if (c0403lf == null) {
            model = c0552rf.toModel(new C0403lf());
        } else {
            model = c0552rf.toModel(c0403lf);
        }
        return new C0198df(model, arrayList);
    }
}
