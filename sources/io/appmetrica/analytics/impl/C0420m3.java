package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.buffering.AccumulatingTaskBuffer;
import io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor;
import io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.m3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0420m3 {

    /* renamed from: a  reason: collision with root package name */
    public final X8 f1092a;
    public final DeferredBatchExecutor b;

    public C0420m3(X8 x8, IHandlerExecutor iHandlerExecutor) {
        this.f1092a = x8;
        this.b = new DeferredBatchExecutor(iHandlerExecutor, new AccumulatingTaskBuffer(), new BatchProcessor() { // from class: io.appmetrica.analytics.impl.m3$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor
            public final void processBatch(List list) {
                C0420m3.a(C0420m3.this, list);
            }
        }, 1000L, "[BufferedEventsWriter]");
    }

    public static final void a(C0420m3 c0420m3, List list) {
        try {
            c0420m3.f1092a.b(list);
            c0420m3.f1092a.a(list);
        } catch (Exception unused) {
        }
    }
}
