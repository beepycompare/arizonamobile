package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.f  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0102f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f472a;

    public C0102f(h hVar) {
        this.f472a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f472a.f && (idSyncConfig = this.f472a.e) != null) {
            this.f472a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f472a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f472a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                C0102f c0102f = hVar2.g;
                if (c0102f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0102f = null;
                }
                iHandlerExecutor.executeDelayed(c0102f, this.f472a.b);
            }
        }
    }
}
