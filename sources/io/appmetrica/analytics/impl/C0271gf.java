package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.gf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0271gf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0574sf f989a;
    public final C0142bf b;

    public C0271gf() {
        this(new C0574sf(), new C0142bf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0475of fromModel(C0219ef c0219ef) {
        C0475of c0475of = new C0475of();
        c0475of.f1132a = this.f989a.fromModel(c0219ef.f954a);
        c0475of.b = new C0450nf[c0219ef.b.size()];
        int i = 0;
        for (C0194df c0194df : c0219ef.b) {
            c0475of.b[i] = this.b.fromModel(c0194df);
            i++;
        }
        return c0475of;
    }

    public C0271gf(C0574sf c0574sf, C0142bf c0142bf) {
        this.f989a = c0574sf;
        this.b = c0142bf;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0219ef toModel(C0475of c0475of) {
        C0549rf model;
        ArrayList arrayList = new ArrayList(c0475of.b.length);
        for (C0450nf c0450nf : c0475of.b) {
            arrayList.add(this.b.toModel(c0450nf));
        }
        C0425mf c0425mf = c0475of.f1132a;
        if (c0425mf == null) {
            model = this.f989a.toModel(new C0425mf());
        } else {
            model = this.f989a.toModel(c0425mf);
        }
        return new C0219ef(model, arrayList);
    }
}
