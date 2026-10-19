package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0230f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f977a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0644v1 c;

    public RunnableC0230f1(C0644v1 c0644v1, String str, String str2) {
        this.c = c0644v1;
        this.f977a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.c).b(this.f977a, this.b);
    }
}
