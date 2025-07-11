package com.miami.game.core.files;

import android.net.Uri;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
/* compiled from: Files.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/files/Files;", "", "safeGetFileByUri", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "safeGetDirectoryAllFiles", "", "safeDelete", "", "file", "getDestinationUri", "subPath", "", "files_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Files {
    Uri getDestinationUri(String str) throws Exception;

    void safeDelete(File file);

    List<File> safeGetDirectoryAllFiles();

    File safeGetFileByUri(Uri uri);
}
