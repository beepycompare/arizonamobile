package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class K0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f513a;
    public final /* synthetic */ C0497p1 b;

    public K0(C0497p1 c0497p1, String str) {
        this.b = c0497p1;
        this.f513a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.b).b(this.f513a);
    }
}
