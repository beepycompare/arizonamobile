package com.miami.game.core.files;

import android.content.Context;
import android.net.Uri;
import androidx.core.net.UriKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: AndroidFiles.kt */
@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/files/AndroidFiles;", "Lcom/miami/game/core/files/Files;", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "externalFilesDir", "Ljava/io/File;", "safeGetFileByUri", "uri", "Landroid/net/Uri;", "safeGetDirectoryAllFiles", "", "safeDelete", "", "file", "getDestinationUri", "subPath", "", "setDestinationFromBase", TtmlNode.RUBY_BASE, "files_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidFiles implements Files {
    private final Context applicationContext;
    private final File externalFilesDir;

    @Inject
    public AndroidFiles(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        File file = null;
        try {
            file = applicationContext.getExternalFilesDir(null);
        } catch (Exception e) {
            Timber.Forest.e(e);
        }
        this.externalFilesDir = file;
    }

    @Override // com.miami.game.core.files.Files
    public File safeGetFileByUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            return UriKt.toFile(uri);
        } catch (Exception e) {
            Timber.Forest.e(e);
            return null;
        }
    }

    @Override // com.miami.game.core.files.Files
    public List<File> safeGetDirectoryAllFiles() {
        List<File> list;
        try {
            File file = this.externalFilesDir;
            Intrinsics.checkNotNull(file);
            File[] listFiles = file.listFiles();
            if (listFiles != null && (list = ArraysKt.toList(listFiles)) != null) {
                return list;
            }
            return CollectionsKt.emptyList();
        } catch (Exception e) {
            Timber.Forest.e(e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.miami.game.core.files.Files
    public void safeDelete(File file) {
        if (file != null) {
            try {
                file.delete();
            } catch (Exception e) {
                Timber.Forest.e(e);
            }
        }
    }

    @Override // com.miami.game.core.files.Files
    public Uri getDestinationUri(String str) {
        return setDestinationFromBase(this.externalFilesDir, str);
    }

    private final Uri setDestinationFromBase(File file, String str) {
        if (file == null || str == null) {
            throw new NullPointerException("base or subPath cannot be null");
        }
        Uri withAppendedPath = Uri.withAppendedPath(Uri.fromFile(file), str);
        Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(...)");
        return withAppendedPath;
    }
}
