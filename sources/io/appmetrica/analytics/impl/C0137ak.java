package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0137ak implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f772a;
    public final /* synthetic */ String b;

    public C0137ak(String str, String str2) {
        this.f772a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportEvent(this.f772a, this.b);
    }
}
