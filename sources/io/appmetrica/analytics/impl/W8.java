package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class W8 extends X8 {

    /* renamed from: a  reason: collision with root package name */
    public final List f819a;

    public W8(List<Object> list) {
        this.f819a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f819a;
    }
}
