package com.miami.game.core.gamefiles.info.data.store.model;

import com.miami.game.core.domain.model.GameInfoFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameInfoFilePrefModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toDomain", "Lcom/miami/game/core/domain/model/GameInfoFile;", "Lcom/miami/game/core/gamefiles/info/data/store/model/GameInfoFilePrefModel;", "toPrefsModel", "gamefiles-info_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GameInfoFilePrefModelKt {
    public static final GameInfoFile toDomain(GameInfoFilePrefModel gameInfoFilePrefModel) {
        Intrinsics.checkNotNullParameter(gameInfoFilePrefModel, "<this>");
        return new GameInfoFile(gameInfoFilePrefModel.getPath(), gameInfoFilePrefModel.getName(), gameInfoFilePrefModel.getSize(), gameInfoFilePrefModel.getHash(), gameInfoFilePrefModel.getDateChange(), gameInfoFilePrefModel.getGpuType(), gameInfoFilePrefModel.isHashChecked());
    }

    public static final GameInfoFilePrefModel toPrefsModel(GameInfoFile gameInfoFile) {
        Intrinsics.checkNotNullParameter(gameInfoFile, "<this>");
        return new GameInfoFilePrefModel(gameInfoFile.getPath(), gameInfoFile.getName(), gameInfoFile.getSize(), gameInfoFile.getHash(), gameInfoFile.getDateChange(), gameInfoFile.getGpuType(), gameInfoFile.isHashChecked());
    }
}
