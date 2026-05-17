package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ih implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f635a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0278gi d;

    public Ih(C0278gi c0278gi, String str, String str2, Throwable th) {
        this.d = c0278gi;
        this.f635a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.d;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).reportError(this.f635a, this.b, this.c);
    }
}
