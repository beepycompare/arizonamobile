package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.fa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0244fa implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0427me f997a;

    public C0244fa() {
        this(new Sl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0559rm fromModel(C0392l4 c0392l4) {
        C0559rm c0559rm = new C0559rm();
        c0559rm.b = c0392l4.b;
        c0559rm.f1217a = c0392l4.f1095a;
        c0559rm.c = c0392l4.c;
        c0559rm.d = c0392l4.d;
        c0559rm.e = c0392l4.e;
        c0559rm.f = this.f997a.a(c0392l4.f);
        return c0559rm;
    }

    public C0244fa(Sl sl) {
        this.f997a = sl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0392l4 toModel(C0559rm c0559rm) {
        C0341j4 c0341j4 = new C0341j4();
        c0341j4.d = c0559rm.d;
        c0341j4.c = c0559rm.c;
        c0341j4.b = c0559rm.b;
        c0341j4.f1060a = c0559rm.f1217a;
        c0341j4.e = c0559rm.e;
        c0341j4.f = this.f997a.a(c0559rm.f);
        return new C0392l4(c0341j4);
    }
}
