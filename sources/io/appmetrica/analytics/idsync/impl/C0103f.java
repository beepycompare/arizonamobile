package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0103f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f425a;

    public C0103f(h hVar) {
        this.f425a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f425a.f && (idSyncConfig = this.f425a.e) != null) {
            this.f425a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f425a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f425a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                C0103f c0103f = hVar2.g;
                if (c0103f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0103f = null;
                }
                iHandlerExecutor.executeDelayed(c0103f, this.f425a.b);
            }
        }
    }
}
