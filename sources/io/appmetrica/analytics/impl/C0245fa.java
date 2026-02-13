package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.fa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0245fa implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0428me f992a;

    public C0245fa() {
        this(new Sl());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0560rm fromModel(C0393l4 c0393l4) {
        C0560rm c0560rm = new C0560rm();
        c0560rm.b = c0393l4.b;
        c0560rm.f1212a = c0393l4.f1090a;
        c0560rm.c = c0393l4.c;
        c0560rm.d = c0393l4.d;
        c0560rm.e = c0393l4.e;
        c0560rm.f = this.f992a.a(c0393l4.f);
        return c0560rm;
    }

    public C0245fa(Sl sl) {
        this.f992a = sl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0393l4 toModel(C0560rm c0560rm) {
        C0342j4 c0342j4 = new C0342j4();
        c0342j4.d = c0560rm.d;
        c0342j4.c = c0560rm.c;
        c0342j4.b = c0560rm.b;
        c0342j4.f1055a = c0560rm.f1212a;
        c0342j4.e = c0560rm.e;
        c0342j4.f = this.f992a.a(c0560rm.f);
        return new C0393l4(c0342j4);
    }
}
