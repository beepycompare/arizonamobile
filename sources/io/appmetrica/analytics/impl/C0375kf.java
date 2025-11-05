package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.kf  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0375kf implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0675wf f973a;
    public final C0246ff b;

    public C0375kf() {
        this(new C0675wf(), new C0246ff());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0575sf fromModel(Cif cif) {
        C0575sf c0575sf = new C0575sf();
        c0575sf.f1113a = this.f973a.fromModel(cif.f935a);
        c0575sf.b = new C0550rf[cif.b.size()];
        int i = 0;
        for (C0298hf c0298hf : cif.b) {
            c0575sf.b[i] = this.b.fromModel(c0298hf);
            i++;
        }
        return c0575sf;
    }

    public C0375kf(C0675wf c0675wf, C0246ff c0246ff) {
        this.f973a = c0675wf;
        this.b = c0246ff;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Cif toModel(C0575sf c0575sf) {
        C0650vf model;
        ArrayList arrayList = new ArrayList(c0575sf.b.length);
        for (C0550rf c0550rf : c0575sf.b) {
            arrayList.add(this.b.toModel(c0550rf));
        }
        C0526qf c0526qf = c0575sf.f1113a;
        if (c0526qf == null) {
            model = this.f973a.toModel(new C0526qf());
        } else {
            model = this.f973a.toModel(c0526qf);
        }
        return new Cif(model, arrayList);
    }
}
