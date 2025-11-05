package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class L0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f566a;
    public final /* synthetic */ C0561s1 b;

    public L0(C0561s1 c0561s1, String str) {
        this.b = c0561s1;
        this.f566a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f566a, false);
    }
}
