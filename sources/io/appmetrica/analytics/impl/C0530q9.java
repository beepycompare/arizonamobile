package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.q9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0530q9 extends AbstractC0554r9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f1015a;

    public C0530q9(List<Object> list) {
        this.f1015a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f1015a;
    }
}
