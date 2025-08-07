package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0298h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f874a;
    public final /* synthetic */ C0497p1 b;

    public RunnableC0298h1(C0497p1 c0497p1, List list) {
        this.b = c0497p1;
        this.f874a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f874a));
    }
}
