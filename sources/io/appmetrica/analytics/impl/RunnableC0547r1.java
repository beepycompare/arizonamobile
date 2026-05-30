package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0547r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1174a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0651v1 c;

    public RunnableC0547r1(C0651v1 c0651v1, String str, List list) {
        this.c = c0651v1;
        this.f1174a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1.a(this.c).reportEvent(this.f1174a, CollectionUtils.getMapFromList(this.b));
    }
}
