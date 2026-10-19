package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C0439n3 implements BatchProcessor, FunctionAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0465o3 f1112a;

    public C0439n3(C0465o3 c0465o3) {
        this.f1112a = c0465o3;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof BatchProcessor) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.f1112a, C0465o3.class, "processTasks", "processTasks(Ljava/util/List;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor
    public final void processBatch(List list) {
        C0465o3 c0465o3 = this.f1112a;
        c0465o3.getClass();
        try {
            c0465o3.f1130a.invoke(list);
        } catch (Exception unused) {
        }
    }
}
