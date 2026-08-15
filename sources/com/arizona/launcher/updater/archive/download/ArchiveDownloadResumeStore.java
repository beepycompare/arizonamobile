package com.arizona.launcher.updater.archive.download;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import kotlin.Metadata;
/* compiled from: ArchiveDownloadResumeSidecar.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeStore;", "", "sidecarFile", "Ljava/io/File;", FirebaseAnalytics.Param.DESTINATION, "load", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadResumeMetadata;", "save", "", TtmlNode.TAG_METADATA, "delete", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveDownloadResumeStore {
    void delete(File file);

    ArchiveDownloadResumeMetadata load(File file);

    void save(File file, ArchiveDownloadResumeMetadata archiveDownloadResumeMetadata);

    File sidecarFile(File file);
}
