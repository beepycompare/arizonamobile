package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.zj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0754zj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f1234a;

    public C0754zj(boolean z) {
        this.f1234a = z;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.setDataSendingEnabled(this.f1234a);
    }
}
