package com.arizona.launcher.updater.archive.orchestrator;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamer;", "", "stream", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeStreamResult;", "request", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;", "consumer", "Lkotlin/Function1;", "Ljava/io/InputStream;", "", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveByteRangeStreamer {
    Object stream(ArchiveByteRangeRequest archiveByteRangeRequest, Function1<? super InputStream, Unit> function1, Continuation<? super ArchiveByteRangeStreamResult> continuation);
}
