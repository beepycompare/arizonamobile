package com.arizona.launcher.updater.archive.orchestrator;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;", "request", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveByteRangeSource {
    Object fetch(ArchiveByteRangeRequest archiveByteRangeRequest, Continuation<? super ArchiveByteRangeResult> continuation);
}
