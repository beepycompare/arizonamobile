package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.g1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0256g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f994a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0256g1(C0644v1 c0644v1, String str) {
        this.b = c0644v1;
        this.f994a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1.a(this.b).b(this.f994a);
    }
}
