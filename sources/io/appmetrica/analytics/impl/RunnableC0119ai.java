package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0119ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f900a;
    public final /* synthetic */ C0300hi b;

    public RunnableC0119ai(C0300hi c0300hi, List list) {
        this.b = c0300hi;
        this.f900a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1024a, c0300hi.d, c0300hi.e).reportAnr(CollectionUtils.getMapFromList(this.f900a));
    }
}
