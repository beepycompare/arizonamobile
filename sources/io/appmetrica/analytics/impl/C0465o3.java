package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.buffering.AccumulatingTaskBuffer;
import io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor;
import kotlin.jvm.functions.Function1;
/* renamed from: io.appmetrica.analytics.impl.o3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0465o3 {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f1130a;
    public final DeferredBatchExecutor b = new DeferredBatchExecutor(Na.k().w().e(), new AccumulatingTaskBuffer(), new C0439n3(this), 1000, "[BufferedTempCacheWriter]");

    public C0465o3(Tn tn) {
        this.f1130a = tn;
    }
}
