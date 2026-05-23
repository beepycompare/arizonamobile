package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0280gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f997a;
    public final /* synthetic */ Ai b;

    public RunnableC0280gi(Ai ai, String str) {
        this.b = ai;
        this.f997a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f460a, ai.d, ai.e).setUserProfileID(this.f997a);
    }
}
