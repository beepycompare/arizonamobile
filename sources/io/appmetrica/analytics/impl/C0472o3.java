package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.buffering.AccumulatingTaskBuffer;
import io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.o3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0472o3 {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1124a;
    public final DeferredBatchExecutor b = new DeferredBatchExecutor(Na.k().w().e(), new AccumulatingTaskBuffer(), new C0446n3(this), 1000, "[BufferedTempCacheWriter]");

    public C0472o3(Tn tn) {
        this.f1124a = tn;
    }
}
