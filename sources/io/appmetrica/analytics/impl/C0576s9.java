package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.s9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0576s9 extends AbstractC0601t9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f1057a;

    public C0576s9(List<Object> list) {
        this.f1057a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f1057a;
    }
}
