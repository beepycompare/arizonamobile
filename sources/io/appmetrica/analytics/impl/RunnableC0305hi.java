package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.hi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0305hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f1020a;
    public final /* synthetic */ Ai b;

    public RunnableC0305hi(Ai ai, UserProfile userProfile) {
        this.b = ai;
        this.f1020a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f463a, ai.d, ai.e).reportUserProfile(this.f1020a);
    }
}
