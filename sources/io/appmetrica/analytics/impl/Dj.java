package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Dj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f400a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public Dj(String str, String str2, Throwable th) {
        this.f400a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportError(this.f400a, this.b, this.c);
    }
}
