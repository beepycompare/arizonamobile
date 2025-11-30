package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f509a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0301hi c;

    public Hh(C0301hi c0301hi, String str, List list) {
        this.c = c0301hi;
        this.f509a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.c;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportEvent(this.f509a, CollectionUtils.getMapFromList(this.b));
    }
}
