package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.q1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0511q1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1176a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0610u1 c;

    public RunnableC0511q1(C0610u1 c0610u1, String str, List list) {
        this.c = c0610u1;
        this.f1176a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1.a(this.c).reportEvent(this.f1176a, CollectionUtils.getMapFromList(this.b));
    }
}
