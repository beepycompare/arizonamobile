package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.tf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0610tf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ff f1065a;
    public final C0486of b;

    public C0610tf() {
        this(new Ff(), new C0486of());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Bf fromModel(C0560rf c0560rf) {
        Bf bf = new Bf();
        bf.f358a = this.f1065a.fromModel(c0560rf.f1036a);
        bf.b = new Af[c0560rf.b.size()];
        int i = 0;
        for (C0536qf c0536qf : c0560rf.b) {
            bf.b[i] = this.b.fromModel(c0536qf);
            i++;
        }
        return bf;
    }

    public C0610tf(Ff ff, C0486of c0486of) {
        this.f1065a = ff;
        this.b = c0486of;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0560rf toModel(Bf bf) {
        Ef model;
        ArrayList arrayList = new ArrayList(bf.b.length);
        for (Af af : bf.b) {
            arrayList.add(this.b.toModel(af));
        }
        C0760zf c0760zf = bf.f358a;
        if (c0760zf == null) {
            model = this.f1065a.toModel(new C0760zf());
        } else {
            model = this.f1065a.toModel(c0760zf);
        }
        return new C0560rf(model, arrayList);
    }
}
