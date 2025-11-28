package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0310i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f921a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0310i1(C0561s1 c0561s1, AnrListener anrListener) {
        this.b = c0561s1;
        this.f921a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).a(this.f921a);
    }
}
