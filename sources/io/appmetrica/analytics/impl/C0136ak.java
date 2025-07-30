package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0136ak implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f773a;
    public final /* synthetic */ String b;

    public C0136ak(String str, String str2) {
        this.f773a = str;
        this.b = str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportEvent(this.f773a, this.b);
    }
}
