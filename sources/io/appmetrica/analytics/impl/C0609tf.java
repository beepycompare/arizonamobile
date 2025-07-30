package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.tf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0609tf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Ff f1066a;
    public final C0485of b;

    public C0609tf() {
        this(new Ff(), new C0485of());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Bf fromModel(C0559rf c0559rf) {
        Bf bf = new Bf();
        bf.f359a = this.f1066a.fromModel(c0559rf.f1037a);
        bf.b = new Af[c0559rf.b.size()];
        int i = 0;
        for (C0535qf c0535qf : c0559rf.b) {
            bf.b[i] = this.b.fromModel(c0535qf);
            i++;
        }
        return bf;
    }

    public C0609tf(Ff ff, C0485of c0485of) {
        this.f1066a = ff;
        this.b = c0485of;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0559rf toModel(Bf bf) {
        Ef model;
        ArrayList arrayList = new ArrayList(bf.b.length);
        for (Af af : bf.b) {
            arrayList.add(this.b.toModel(af));
        }
        C0759zf c0759zf = bf.f359a;
        if (c0759zf == null) {
            model = this.f1066a.toModel(new C0759zf());
        } else {
            model = this.f1066a.toModel(c0759zf);
        }
        return new C0559rf(model, arrayList);
    }
}
