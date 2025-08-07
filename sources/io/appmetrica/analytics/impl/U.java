package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class U {

    /* renamed from: a  reason: collision with root package name */
    public final C0618tn f660a;
    public final List b;
    public final String c;

    public U(C0618tn c0618tn, ArrayList arrayList, String str) {
        this.f660a = c0618tn;
        this.b = arrayList == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(arrayList);
        this.c = str;
    }
}
