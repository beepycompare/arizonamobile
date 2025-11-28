package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.uj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0629uj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1154a;
    public final /* synthetic */ Throwable b;

    public C0629uj(String str, Throwable th) {
        this.f1154a = str;
        this.b = th;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportError(this.f1154a, this.b);
    }
}
