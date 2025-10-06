package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ik  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0336ik implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f927a;

    public C0336ik(String str) {
        this.f927a = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportEvent(this.f927a);
    }
}
