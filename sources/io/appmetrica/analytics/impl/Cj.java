package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Cj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f381a;
    public final /* synthetic */ Throwable b;

    public Cj(String str, Throwable th) {
        this.f381a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportError(this.f381a, this.b);
    }
}
