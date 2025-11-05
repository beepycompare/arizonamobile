package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0412m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1000a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0412m1(C0561s1 c0561s1, String str) {
        this.b = c0561s1;
        this.f1000a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportEvent(this.f1000a);
    }
}
