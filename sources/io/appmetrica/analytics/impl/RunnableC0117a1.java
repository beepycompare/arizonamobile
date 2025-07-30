package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.a1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0117a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f759a;
    public final /* synthetic */ C0496p1 b;

    public RunnableC0117a1(C0496p1 c0496p1, String str) {
        this.b = c0496p1;
        this.f759a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.b).a(this.f759a);
    }
}
