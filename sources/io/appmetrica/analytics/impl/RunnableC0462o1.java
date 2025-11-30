package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0462o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1040a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0462o1(C0611u1 c0611u1, String str) {
        this.b = c0611u1;
        this.f1040a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportEvent(this.f1040a);
    }
}
