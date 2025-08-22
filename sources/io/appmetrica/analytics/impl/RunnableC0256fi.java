package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0256fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f857a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0256fi(C0735yi c0735yi, UserProfile userProfile) {
        this.b = c0735yi;
        this.f857a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportUserProfile(this.f857a);
    }
}
