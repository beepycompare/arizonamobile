package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.n1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0437n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1017a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0561s1 c;

    public RunnableC0437n1(C0561s1 c0561s1, String str, String str2) {
        this.c = c0561s1;
        this.f1017a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.c).reportEvent(this.f1017a, this.b);
    }
}
