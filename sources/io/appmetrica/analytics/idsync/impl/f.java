package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f363a;

    public f(h hVar) {
        this.f363a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f363a.f && (idSyncConfig = this.f363a.e) != null) {
            this.f363a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f363a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f363a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                f fVar = hVar2.g;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    fVar = null;
                }
                iHandlerExecutor.executeDelayed(fVar, this.f363a.b);
            }
        }
    }
}
