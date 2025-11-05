package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0462o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1032a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0561s1 c;

    public RunnableC0462o1(C0561s1 c0561s1, String str, List list) {
        this.c = c0561s1;
        this.f1032a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0561s1.a(this.c).reportEvent(this.f1032a, CollectionUtils.getMapFromList(this.b));
    }
}
