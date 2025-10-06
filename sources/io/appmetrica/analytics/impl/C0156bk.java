package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0156bk implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f814a;
    public final /* synthetic */ byte[] b;

    public C0156bk(String str, byte[] bArr) {
        this.f814a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.setSessionExtra(this.f814a, this.b);
    }
}
