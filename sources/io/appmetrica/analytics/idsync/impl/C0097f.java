package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0097f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f428a;

    public C0097f(h hVar) {
        this.f428a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f428a.f && (idSyncConfig = this.f428a.e) != null) {
            this.f428a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f428a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f428a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                C0097f c0097f = hVar2.g;
                if (c0097f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0097f = null;
                }
                iHandlerExecutor.executeDelayed(c0097f, this.f428a.b);
            }
        }
    }
}
