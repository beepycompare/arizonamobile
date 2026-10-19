package com.arizona.launcher.updater.archive.orchestrator;

import java.io.IOException;
import kotlin.Metadata;
/* compiled from: ViceCityArchiveContentManager.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ViceCityArchiveDeleteMarker;", "", "isPending", "", "markPending", "", "clearPending", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ViceCityArchiveDeleteMarker {
    void clearPending() throws IOException;

    boolean isPending() throws IOException;

    void markPending() throws IOException;
}
