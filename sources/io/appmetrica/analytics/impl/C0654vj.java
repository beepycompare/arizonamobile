package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.vj  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0654vj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1173a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;

    public C0654vj(String str, String str2, Throwable th) {
        this.f1173a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportError(this.f1173a, this.b, this.c);
    }
}
