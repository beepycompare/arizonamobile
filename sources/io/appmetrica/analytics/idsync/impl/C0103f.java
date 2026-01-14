package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.idsync.internal.model.RequestConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.idsync.impl.f  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0103f extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f468a;

    public C0103f(h hVar) {
        this.f468a = hVar;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        IdSyncConfig idSyncConfig;
        if (this.f468a.f && (idSyncConfig = this.f468a.e) != null) {
            this.f468a.getClass();
            if (h.a(idSyncConfig)) {
                List<RequestConfig> requests = idSyncConfig.getRequests();
                h hVar = this.f468a;
                for (RequestConfig requestConfig : requests) {
                    hVar.d.a(requestConfig);
                }
                h hVar2 = this.f468a;
                IHandlerExecutor iHandlerExecutor = hVar2.c;
                C0103f c0103f = hVar2.g;
                if (c0103f == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    c0103f = null;
                }
                iHandlerExecutor.executeDelayed(c0103f, this.f468a.b);
            }
        }
    }
}
