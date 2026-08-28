package com.arizona.launcher.updater.archive.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: ArchiveNetworkMonitor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/AndroidArchiveNetworkMonitor;", "Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "hasValidatedNetwork", "", "awaitValidatedNetwork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveNetworkMonitor implements ArchiveNetworkMonitor {
    public static final int $stable = 8;
    private final ConnectivityManager connectivityManager;

    public AndroidArchiveNetworkMonitor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    @Override // com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitor
    public boolean hasValidatedNetwork() {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = this.connectivityManager.getActiveNetwork();
        return activeNetwork != null && (networkCapabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor$awaitValidatedNetwork$2$1, T] */
    @Override // com.arizona.launcher.updater.archive.download.ArchiveNetworkMonitor
    public Object awaitValidatedNetwork(Continuation<? super Boolean> continuation) {
        ConnectivityManager.NetworkCallback networkCallback;
        if (hasValidatedNetwork()) {
            return Boxing.boxBoolean(true);
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ConnectivityManager.NetworkCallback() { // from class: com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor$awaitValidatedNetwork$2$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                if (AndroidArchiveNetworkMonitor.this.hasValidatedNetwork()) {
                    AndroidArchiveNetworkMonitor.awaitValidatedNetwork$lambda$0$finish(atomicBoolean, AndroidArchiveNetworkMonitor.this, cancellableContinuationImpl2, objectRef, true);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
                if (networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
                    AndroidArchiveNetworkMonitor.awaitValidatedNetwork$lambda$0$finish(atomicBoolean, AndroidArchiveNetworkMonitor.this, cancellableContinuationImpl2, objectRef, true);
                }
            }
        };
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor$awaitValidatedNetwork$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ConnectivityManager.NetworkCallback networkCallback2;
                if (atomicBoolean.compareAndSet(false, true)) {
                    AndroidArchiveNetworkMonitor androidArchiveNetworkMonitor = this;
                    Ref.ObjectRef<ConnectivityManager.NetworkCallback> objectRef2 = objectRef;
                    try {
                        Result.Companion companion = Result.Companion;
                        ConnectivityManager connectivityManager = androidArchiveNetworkMonitor.connectivityManager;
                        if (objectRef2.element == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("callback");
                            networkCallback2 = null;
                        } else {
                            networkCallback2 = objectRef2.element;
                        }
                        connectivityManager.unregisterNetworkCallback(networkCallback2);
                        Result.m9920constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m9920constructorimpl(ResultKt.createFailure(th2));
                    }
                }
            }
        });
        try {
            ConnectivityManager connectivityManager = this.connectivityManager;
            if (objectRef.element == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                networkCallback = null;
            } else {
                networkCallback = (ConnectivityManager.NetworkCallback) objectRef.element;
            }
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            if (hasValidatedNetwork()) {
                awaitValidatedNetwork$lambda$0$finish(atomicBoolean, this, cancellableContinuationImpl2, objectRef, true);
            }
        } catch (SecurityException unused) {
            awaitValidatedNetwork$lambda$0$finish(atomicBoolean, this, cancellableContinuationImpl2, objectRef, false);
        } catch (RuntimeException unused2) {
            awaitValidatedNetwork$lambda$0$finish(atomicBoolean, this, cancellableContinuationImpl2, objectRef, false);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void awaitValidatedNetwork$lambda$0$finish(AtomicBoolean atomicBoolean, AndroidArchiveNetworkMonitor androidArchiveNetworkMonitor, CancellableContinuation<? super Boolean> cancellableContinuation, Ref.ObjectRef<ConnectivityManager.NetworkCallback> objectRef, boolean z) {
        ConnectivityManager.NetworkCallback networkCallback;
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                ConnectivityManager connectivityManager = androidArchiveNetworkMonitor.connectivityManager;
                if (objectRef.element == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    networkCallback = null;
                } else {
                    networkCallback = objectRef.element;
                }
                connectivityManager.unregisterNetworkCallback(networkCallback);
                Result.m9920constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            if (cancellableContinuation.isActive()) {
                Result.Companion companion3 = Result.Companion;
                cancellableContinuation.resumeWith(Result.m9920constructorimpl(Boolean.valueOf(z)));
            }
        }
    }
}
