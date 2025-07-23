package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class I0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f480a;
    public final /* synthetic */ C0496p1 b;

    public I0(C0496p1 c0496p1, String str) {
        this.b = c0496p1;
        this.f480a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d().b.a(this.f480a, false);
    }
}
