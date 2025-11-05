package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.f1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0232f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f869a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0232f1(C0561s1 c0561s1, Activity activity) {
        this.b = c0561s1;
        this.f869a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1 c0561s1 = this.b;
        C0149bl c0149bl = c0561s1.h;
        Activity activity = this.f869a;
        Pa pa = c0561s1.d().f1072a;
        if (activity != null) {
            c0149bl.f.a(activity);
        }
        if (c0149bl.e.a(activity, EnumC0485p.RESUMED)) {
            pa.a(activity);
        }
    }
}
