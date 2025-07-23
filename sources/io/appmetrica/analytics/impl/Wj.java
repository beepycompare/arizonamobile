package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f705a;
    public final /* synthetic */ String b;

    public Wj(String str, String str2) {
        this.f705a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.putAppEnvironmentValue(this.f705a, this.b);
    }
}
