package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.tn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0617tn {

    /* renamed from: a  reason: collision with root package name */
    public final String f1072a;
    public final int b;
    public final long c;
    public final String d;
    public final Integer e;
    public final List f;

    public C0617tn(String str, int i, long j, String str2, Integer num, List list) {
        this.f1072a = str;
        this.b = i;
        this.c = j;
        this.d = str2;
        this.e = num;
        this.f = list == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(list);
    }
}
