package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Hj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f607a;
    public final /* synthetic */ byte[] b;

    public Hj(String str, byte[] bArr) {
        this.f607a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.setSessionExtra(this.f607a, this.b);
    }
}
