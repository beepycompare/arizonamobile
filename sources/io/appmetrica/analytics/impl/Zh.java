package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Zh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f889a;
    public final /* synthetic */ C0278gi b;

    public Zh(C0278gi c0278gi, List list) {
        this.b = c0278gi;
        this.f889a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).reportAnr(CollectionUtils.getMapFromList(this.f889a));
    }
}
