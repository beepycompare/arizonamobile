package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Dj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f399a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Dj(String str, String str2, Throwable th) {
        this.f399a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportError(this.f399a, this.b, this.c);
    }
}
