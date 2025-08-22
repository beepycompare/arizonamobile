package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f744a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0735yi c;

    public Yh(C0735yi c0735yi, String str, List list) {
        this.c = c0735yi;
        this.f744a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.c;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportEvent(this.f744a, CollectionUtils.getMapFromList(this.b));
    }
}
