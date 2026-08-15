package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0384kk implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1071a;
    public final /* synthetic */ String b;

    public C0384kk(String str, String str2) {
        this.f1071a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.putAppEnvironmentValue(this.f1071a, this.b);
    }
}
