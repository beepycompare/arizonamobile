package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0753zj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f1332a;

    public C0753zj(boolean z) {
        this.f1332a = z;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.setDataSendingEnabled(this.f1332a);
    }
}
