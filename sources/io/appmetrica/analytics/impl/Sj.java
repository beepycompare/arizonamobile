package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Sj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f642a;
    public final /* synthetic */ byte[] b;

    public Sj(String str, byte[] bArr) {
        this.f642a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.setSessionExtra(this.f642a, this.b);
    }
}
