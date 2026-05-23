package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0446n3 implements BatchProcessor, FunctionAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0472o3 f1106a;

    public C0446n3(C0472o3 c0472o3) {
        this.f1106a = c0472o3;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof BatchProcessor) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f1106a, C0472o3.class, "processTasks", "processTasks(Ljava/util/List;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor
    public final void processBatch(List list) {
        C0472o3 c0472o3 = this.f1106a;
        c0472o3.getClass();
        try {
            c0472o3.f1124a.invoke(list);
        } catch (Exception unused) {
        }
    }
}
