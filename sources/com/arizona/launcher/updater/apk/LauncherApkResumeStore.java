package com.arizona.launcher.updater.apk;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
/* compiled from: LauncherApkResumeStore.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkResumeStore;", "", "sidecarFile", "Ljava/io/File;", "partialFile", "temporarySidecarFile", "load", "Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "save", "", TtmlNode.TAG_METADATA, "delete", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LauncherApkResumeStore {
    boolean delete(File file) throws IOException;

    LauncherApkResumeMetadata load(File file);

    void save(File file, LauncherApkResumeMetadata launcherApkResumeMetadata) throws IOException;

    File sidecarFile(File file);

    File temporarySidecarFile(File file);
}
