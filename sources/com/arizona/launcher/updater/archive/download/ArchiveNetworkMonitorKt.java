package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: ArchiveNetworkMonitor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0080@¢\u0006\u0002\u0010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS", "", "awaitValidatedNetworkWithin", "", "Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;", "timeoutMs", "(Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveNetworkMonitorKt {
    public static final long ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS = 30000;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitValidatedNetworkWithin(ArchiveNetworkMonitor archiveNetworkMonitor, long j, Continuation<? super Boolean> continuation) {
        ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1 archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1;
        int i;
        if (continuation instanceof ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1) {
            archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1 = (ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1) continuation;
            if ((archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.label & Integer.MIN_VALUE) != 0) {
                archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.label -= Integer.MIN_VALUE;
                Object obj = archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (j <= 0) {
                        throw new IllegalArgumentException(("timeoutMs must be > 0, was " + j).toString());
                    }
                    archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.L$0 = SpillingKt.nullOutSpilledVariable(archiveNetworkMonitor);
                    archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.J$0 = j;
                    archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(j, new ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$3(archiveNetworkMonitor, null), archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j2 = archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.J$0;
                    ArchiveNetworkMonitor archiveNetworkMonitor2 = (ArchiveNetworkMonitor) archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Boolean bool = (Boolean) obj;
                return Boxing.boxBoolean(bool == null ? bool.booleanValue() : false);
            }
        }
        archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1 = new ArchiveNetworkMonitorKt$awaitValidatedNetworkWithin$1(continuation);
        Object obj2 = archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveNetworkMonitorKt$awaitValidatedNetworkWithin$1.label;
        if (i != 0) {
        }
        Boolean bool2 = (Boolean) obj2;
        return Boxing.boxBoolean(bool2 == null ? bool2.booleanValue() : false);
    }

    public static /* synthetic */ Object awaitValidatedNetworkWithin$default(ArchiveNetworkMonitor archiveNetworkMonitor, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ARCHIVE_NETWORK_RECONNECT_TIMEOUT_MS;
        }
        return awaitValidatedNetworkWithin(archiveNetworkMonitor, j, continuation);
    }
}
