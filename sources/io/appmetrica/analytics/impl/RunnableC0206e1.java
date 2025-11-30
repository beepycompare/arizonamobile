package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0206e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f861a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0611u1 c;

    public RunnableC0206e1(C0611u1 c0611u1, String str, String str2) {
        this.c = c0611u1;
        this.f861a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.c).b(this.f861a, this.b);
    }
}
