package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.profile.UserProfile;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0135ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProfile f770a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0135ai(C0613ti c0613ti, UserProfile userProfile) {
        this.b = c0613ti;
        this.f770a = userProfile;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportUserProfile(this.f770a);
    }
}
