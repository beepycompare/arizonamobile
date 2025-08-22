package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.vf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0657vf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final Hf f1104a;
    public final C0533qf b;

    public C0657vf() {
        this(new Hf(), new C0533qf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Df fromModel(C0607tf c0607tf) {
        Df df = new Df();
        df.f397a = this.f1104a.fromModel(c0607tf.f1073a);
        df.b = new Cf[c0607tf.b.size()];
        int i = 0;
        for (C0582sf c0582sf : c0607tf.b) {
            df.b[i] = this.b.fromModel(c0582sf);
            i++;
        }
        return df;
    }

    public C0657vf(Hf hf, C0533qf c0533qf) {
        this.f1104a = hf;
        this.b = c0533qf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0607tf toModel(Df df) {
        Gf model;
        ArrayList arrayList = new ArrayList(df.b.length);
        for (Cf cf : df.b) {
            arrayList.add(this.b.toModel(cf));
        }
        Bf bf = df.f397a;
        if (bf == null) {
            model = this.f1104a.toModel(new Bf());
        } else {
            model = this.f1104a.toModel(bf);
        }
        return new C0607tf(model, arrayList);
    }
}
