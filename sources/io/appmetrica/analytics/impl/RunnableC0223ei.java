package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0223ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f864a;
    public final /* synthetic */ C0404li b;

    public RunnableC0223ei(C0404li c0404li, List list) {
        this.b = c0404li;
        this.f864a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportAnr(CollectionUtils.getMapFromList(this.f864a));
    }
}
