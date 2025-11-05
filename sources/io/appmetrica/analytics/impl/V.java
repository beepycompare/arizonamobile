package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final C0733yn f725a;
    public final List b;
    public final String c;

    public V(C0733yn c0733yn, ArrayList arrayList, String str) {
        this.f725a = c0733yn;
        this.b = arrayList == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(arrayList);
        this.c = str;
    }
}
