package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ri  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0560ri implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1047a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0560ri(C0735yi c0735yi, List list) {
        this.b = c0735yi;
        this.f1047a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportAnr(CollectionUtils.getMapFromList(this.f1047a));
    }
}
