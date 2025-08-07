package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes4.dex */
public final class Em implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0667vm fromModel(Dm dm) {
        C0667vm c0667vm = new C0667vm();
        c0667vm.f1105a = dm.f402a;
        return c0667vm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        return new Dm(((C0667vm) obj).f1105a);
    }

    public final Dm a(C0667vm c0667vm) {
        return new Dm(c0667vm.f1105a);
    }
}
