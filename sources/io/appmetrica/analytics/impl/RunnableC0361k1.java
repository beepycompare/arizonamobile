package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0361k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f964a;
    public final /* synthetic */ C0561s1 b;

    public RunnableC0361k1(C0561s1 c0561s1, List list) {
        this.b = c0561s1;
        this.f964a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f964a));
    }
}
