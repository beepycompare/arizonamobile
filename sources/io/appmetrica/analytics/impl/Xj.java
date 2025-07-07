package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f710a;
    public final /* synthetic */ String b;

    public Xj(String str, String str2) {
        this.f710a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.reportEvent(this.f710a, this.b);
    }
}
