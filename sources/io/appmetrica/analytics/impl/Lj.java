package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Lj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f578a;
    public final /* synthetic */ byte[] b;

    public Lj(String str, byte[] bArr) {
        this.f578a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.setSessionExtra(this.f578a, this.b);
    }
}
