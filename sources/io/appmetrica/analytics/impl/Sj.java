package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Sj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f641a;
    public final /* synthetic */ byte[] b;

    public Sj(String str, byte[] bArr) {
        this.f641a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.setSessionExtra(this.f641a, this.b);
    }
}
