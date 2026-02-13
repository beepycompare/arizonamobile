package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0176ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f940a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0279gi c;

    public RunnableC0176ci(C0279gi c0279gi, String str, String str2) {
        this.c = c0279gi;
        this.f940a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.c;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).putAppEnvironmentValue(this.f940a, this.b);
    }
}
