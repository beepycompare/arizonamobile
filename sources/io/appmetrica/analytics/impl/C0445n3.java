package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0445n3 implements BatchProcessor, FunctionAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0471o3 f1109a;

    public C0445n3(C0471o3 c0471o3) {
        this.f1109a = c0471o3;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof BatchProcessor) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f1109a, C0471o3.class, "processTasks", "processTasks(Ljava/util/List;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor
    public final void processBatch(List list) {
        C0471o3 c0471o3 = this.f1109a;
        c0471o3.getClass();
        try {
            c0471o3.f1127a.invoke(list);
        } catch (Exception unused) {
        }
    }
}
