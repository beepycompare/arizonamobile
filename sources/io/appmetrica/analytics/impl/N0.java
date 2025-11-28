package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class N0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f599a;
    public final /* synthetic */ C0561s1 b;

    public N0(C0561s1 c0561s1, String str) {
        this.b = c0561s1;
        this.f599a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).c(this.f599a);
    }
}
