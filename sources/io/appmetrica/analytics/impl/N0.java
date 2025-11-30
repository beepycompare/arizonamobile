package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class N0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f595a;
    public final /* synthetic */ C0611u1 b;

    public N0(C0611u1 c0611u1, String str) {
        this.b = c0611u1;
        this.f595a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f595a, false);
    }
}
