package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Hj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f608a;
    public final /* synthetic */ byte[] b;

    public Hj(String str, byte[] bArr) {
        this.f608a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.setSessionExtra(this.f608a, this.b);
    }
}
