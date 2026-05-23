package com.miami.game.core.settings.logs;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: saveLogToDownloads.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/settings/logs/SavedToDownloads;", "", "file", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "<init>", "(Ljava/io/File;Landroid/net/Uri;)V", "getFile", "()Ljava/io/File;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavedToDownloads {
    private final File file;
    private final Uri uri;

    public static /* synthetic */ SavedToDownloads copy$default(SavedToDownloads savedToDownloads, File file, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            file = savedToDownloads.file;
        }
        if ((i & 2) != 0) {
            uri = savedToDownloads.uri;
        }
        return savedToDownloads.copy(file, uri);
    }

    public final File component1() {
        return this.file;
    }

    public final Uri component2() {
        return this.uri;
    }

    public final SavedToDownloads copy(File file, Uri uri) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new SavedToDownloads(file, uri);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SavedToDownloads) {
            SavedToDownloads savedToDownloads = (SavedToDownloads) obj;
            return Intrinsics.areEqual(this.file, savedToDownloads.file) && Intrinsics.areEqual(this.uri, savedToDownloads.uri);
        }
        return false;
    }

    public int hashCode() {
        return (this.file.hashCode() * 31) + this.uri.hashCode();
    }

    public String toString() {
        File file = this.file;
        return "SavedToDownloads(file=" + file + ", uri=" + this.uri + ")";
    }

    public SavedToDownloads(File file, Uri uri) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.file = file;
        this.uri = uri;
    }

    public final File getFile() {
        return this.file;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
