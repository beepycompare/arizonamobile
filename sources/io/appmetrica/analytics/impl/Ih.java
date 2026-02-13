package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Ih implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f630a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0279gi d;

    public Ih(C0279gi c0279gi, String str, String str2, Throwable th) {
        this.d = c0279gi;
        this.f630a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.d;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).reportError(this.f630a, this.b, this.c);
    }
}
