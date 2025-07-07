package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.ye  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0739ye implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Integer fromModel(Boolean bool) {
        int i;
        if (bool == null) {
            i = -1;
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            i = 1;
        } else if (!Intrinsics.areEqual(bool, Boolean.FALSE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            i = 0;
        }
        return Integer.valueOf(i);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object toModel(Object obj) {
        return a(((Number) obj).intValue());
    }

    public final Boolean a(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return null;
    }
}
