package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0412m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1000a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0412m1(C0611u1 c0611u1, List list) {
        this.b = c0611u1;
        this.f1000a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f1000a));
    }
}
