package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0232f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f880a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0232f1(C0611u1 c0611u1, String str) {
        this.b = c0611u1;
        this.f880a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).b(this.f880a);
    }
}
