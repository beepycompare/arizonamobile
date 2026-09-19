package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0280gk implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1002a;
    public final /* synthetic */ byte[] b;

    public C0280gk(String str, byte[] bArr) {
        this.f1002a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.setSessionExtra(this.f1002a, this.b);
    }
}
