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
    public final /* synthetic */ h f463a;

    public f(h hVar) {
        this.f463a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f463a.f && (idSyncConfig = this.f463a.e) != null) {
            this.f463a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f463a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f463a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                f fVar = hVar2.g;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    fVar = null;
                }
                iHandlerExecutor.executeDelayed(fVar, this.f463a.b);
            }
        }
    }
}
