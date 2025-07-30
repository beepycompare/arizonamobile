package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Ej implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f422a;

    public Ej(Throwable th) {
        this.f422a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportUnhandledException(this.f422a);
    }
}
