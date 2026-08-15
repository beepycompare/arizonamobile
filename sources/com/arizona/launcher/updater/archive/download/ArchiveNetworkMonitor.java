package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
/* compiled from: ArchiveNetworkMonitor.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveNetworkMonitor;", "", "hasValidatedNetwork", "", "awaitValidatedNetwork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveNetworkMonitor {
    Object awaitValidatedNetwork(Continuation<? super Boolean> continuation);

    boolean hasValidatedNetwork();
}
