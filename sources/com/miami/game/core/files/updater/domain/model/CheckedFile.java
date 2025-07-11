package com.miami.game.core.files.updater.domain.model;

import com.miami.game.core.domain.model.GameInfoFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CheckedFile.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/miami/game/core/files/updater/domain/model/CheckedFile;", "", "gameInfoFile", "Lcom/miami/game/core/domain/model/GameInfoFile;", "<init>", "(Lcom/miami/game/core/domain/model/GameInfoFile;)V", "getGameInfoFile", "()Lcom/miami/game/core/domain/model/GameInfoFile;", "isDownloadedAndChecked", "", "()Z", "setDownloadedAndChecked", "(Z)V", "isNewDownloaded", "setNewDownloaded", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "files-updater_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckedFile {
    private final GameInfoFile gameInfoFile;
    private boolean isDownloadedAndChecked;
    private boolean isNewDownloaded;

    public static /* synthetic */ CheckedFile copy$default(CheckedFile checkedFile, GameInfoFile gameInfoFile, int i, Object obj) {
        if ((i & 1) != 0) {
            gameInfoFile = checkedFile.gameInfoFile;
        }
        return checkedFile.copy(gameInfoFile);
    }

    public final GameInfoFile component1() {
        return this.gameInfoFile;
    }

    public final CheckedFile copy(GameInfoFile gameInfoFile) {
        Intrinsics.checkNotNullParameter(gameInfoFile, "gameInfoFile");
        return new CheckedFile(gameInfoFile);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CheckedFile) && Intrinsics.areEqual(this.gameInfoFile, ((CheckedFile) obj).gameInfoFile);
    }

    public int hashCode() {
        return this.gameInfoFile.hashCode();
    }

    public String toString() {
        return "CheckedFile(gameInfoFile=" + this.gameInfoFile + ")";
    }

    public CheckedFile(GameInfoFile gameInfoFile) {
        Intrinsics.checkNotNullParameter(gameInfoFile, "gameInfoFile");
        this.gameInfoFile = gameInfoFile;
    }

    public final GameInfoFile getGameInfoFile() {
        return this.gameInfoFile;
    }

    public final boolean isDownloadedAndChecked() {
        return this.isDownloadedAndChecked;
    }

    public final void setDownloadedAndChecked(boolean z) {
        this.isDownloadedAndChecked = z;
    }

    public final boolean isNewDownloaded() {
        return this.isNewDownloaded;
    }

    public final void setNewDownloaded(boolean z) {
        this.isNewDownloaded = z;
    }
}
