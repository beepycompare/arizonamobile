package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Tj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f645a;
    public final /* synthetic */ String b;

    public Tj(String str, String str2) {
        this.f645a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.putAppEnvironmentValue(this.f645a, this.b);
    }
}
