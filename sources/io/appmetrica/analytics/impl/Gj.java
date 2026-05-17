package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Gj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f604a;
    public final /* synthetic */ byte[] b;

    public Gj(String str, byte[] bArr) {
        this.f604a = str;
        this.b = bArr;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.setSessionExtra(this.f604a, this.b);
    }
}
