package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0489p1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1165a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0588t1 c;

    public RunnableC0489p1(C0588t1 c0588t1, String str, List list) {
        this.c = c0588t1;
        this.f1165a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1.a(this.c).reportEvent(this.f1165a, CollectionUtils.getMapFromList(this.b));
    }
}
