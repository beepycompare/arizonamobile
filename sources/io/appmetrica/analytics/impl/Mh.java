package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Mh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f593a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ C0404li c;

    public Mh(C0404li c0404li, String str, Throwable th) {
        this.c = c0404li;
        this.f593a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.c;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportError(this.f593a, this.b);
    }
}
