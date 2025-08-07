package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Ej implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f421a;

    public Ej(Throwable th) {
        this.f421a = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportUnhandledException(this.f421a);
    }
}
