package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f705a;
    public final /* synthetic */ String b;

    public Wj(String str, String str2) {
        this.f705a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.putAppEnvironmentValue(this.f705a, this.b);
    }
}
