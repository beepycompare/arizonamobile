package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f592a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0300hi c;

    public Hh(C0300hi c0300hi, String str, List list) {
        this.c = c0300hi;
        this.f592a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.c;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).reportEvent(this.f592a, CollectionUtils.getMapFromList(this.b));
    }
}
