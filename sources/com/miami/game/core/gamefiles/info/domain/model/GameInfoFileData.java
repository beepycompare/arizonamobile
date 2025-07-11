package com.miami.game.core.gamefiles.info.domain.model;

import com.miami.game.core.domain.model.GameInfoFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameInfoFileData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/gamefiles/info/domain/model/GameInfoFileData;", "", "loadedGameInfoFile", "", "Lcom/miami/game/core/domain/model/GameInfoFile;", "savedGameInfoFile", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getLoadedGameInfoFile", "()Ljava/util/List;", "getSavedGameInfoFile", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "gamefiles-info_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GameInfoFileData {
    private final List<GameInfoFile> loadedGameInfoFile;
    private final List<GameInfoFile> savedGameInfoFile;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GameInfoFileData copy$default(GameInfoFileData gameInfoFileData, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gameInfoFileData.loadedGameInfoFile;
        }
        if ((i & 2) != 0) {
            list2 = gameInfoFileData.savedGameInfoFile;
        }
        return gameInfoFileData.copy(list, list2);
    }

    public final List<GameInfoFile> component1() {
        return this.loadedGameInfoFile;
    }

    public final List<GameInfoFile> component2() {
        return this.savedGameInfoFile;
    }

    public final GameInfoFileData copy(List<GameInfoFile> loadedGameInfoFile, List<GameInfoFile> savedGameInfoFile) {
        Intrinsics.checkNotNullParameter(loadedGameInfoFile, "loadedGameInfoFile");
        Intrinsics.checkNotNullParameter(savedGameInfoFile, "savedGameInfoFile");
        return new GameInfoFileData(loadedGameInfoFile, savedGameInfoFile);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameInfoFileData) {
            GameInfoFileData gameInfoFileData = (GameInfoFileData) obj;
            return Intrinsics.areEqual(this.loadedGameInfoFile, gameInfoFileData.loadedGameInfoFile) && Intrinsics.areEqual(this.savedGameInfoFile, gameInfoFileData.savedGameInfoFile);
        }
        return false;
    }

    public int hashCode() {
        return (this.loadedGameInfoFile.hashCode() * 31) + this.savedGameInfoFile.hashCode();
    }

    public String toString() {
        List<GameInfoFile> list = this.loadedGameInfoFile;
        return "GameInfoFileData(loadedGameInfoFile=" + list + ", savedGameInfoFile=" + this.savedGameInfoFile + ")";
    }

    public GameInfoFileData(List<GameInfoFile> loadedGameInfoFile, List<GameInfoFile> savedGameInfoFile) {
        Intrinsics.checkNotNullParameter(loadedGameInfoFile, "loadedGameInfoFile");
        Intrinsics.checkNotNullParameter(savedGameInfoFile, "savedGameInfoFile");
        this.loadedGameInfoFile = loadedGameInfoFile;
        this.savedGameInfoFile = savedGameInfoFile;
    }

    public final List<GameInfoFile> getLoadedGameInfoFile() {
        return this.loadedGameInfoFile;
    }

    public final List<GameInfoFile> getSavedGameInfoFile() {
        return this.savedGameInfoFile;
    }
}
