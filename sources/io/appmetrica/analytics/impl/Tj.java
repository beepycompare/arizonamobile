package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Tj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f646a;
    public final /* synthetic */ String b;

    public Tj(String str, String str2) {
        this.f646a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.putAppEnvironmentValue(this.f646a, this.b);
    }
}
