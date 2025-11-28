package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Nh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f609a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ C0404li d;

    public Nh(C0404li c0404li, String str, String str2, Throwable th) {
        this.d = c0404li;
        this.f609a = str;
        this.b = str2;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.d;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportError(this.f609a, this.b, this.c);
    }
}
