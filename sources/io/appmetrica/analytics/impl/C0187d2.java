package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
/* renamed from: io.appmetrica.analytics.impl.d2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0187d2 implements FunctionWithThrowable {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
    public final Object apply(Object obj) {
        return ((Activity) obj).getIntent();
    }
}
