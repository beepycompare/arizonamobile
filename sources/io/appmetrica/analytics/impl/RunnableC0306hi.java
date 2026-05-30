package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0306hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f1018a;
    public final /* synthetic */ Ai b;

    public RunnableC0306hi(Ai ai, UserProfile userProfile) {
        this.b = ai;
        this.f1018a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f461a, ai.d, ai.e).reportUserProfile(this.f1018a);
    }
}
