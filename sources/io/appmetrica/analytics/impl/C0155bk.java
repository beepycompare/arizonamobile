package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0155bk implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f809a;
    public final /* synthetic */ byte[] b;

    public C0155bk(String str, byte[] bArr) {
        this.f809a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.setSessionExtra(this.f809a, this.b);
    }
}
