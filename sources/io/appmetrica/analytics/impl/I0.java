package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class I0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f466a;
    public final /* synthetic */ C0502p1 b;

    public I0(C0502p1 c0502p1, String str) {
        this.b = c0502p1;
        this.f466a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f466a, false);
    }
}
