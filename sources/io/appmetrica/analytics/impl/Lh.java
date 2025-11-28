package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Lh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f577a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0404li c;

    public Lh(C0404li c0404li, String str, List list) {
        this.c = c0404li;
        this.f577a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.c;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).reportEvent(this.f577a, CollectionUtils.getMapFromList(this.b));
    }
}
