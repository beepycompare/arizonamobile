package com.miami.game.core.api.model.response.game_info;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameInfoApiModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/api/model/response/game_info/GameInfoResponseApiModel;", "", "data", "Lcom/miami/game/core/api/model/response/game_info/GameInfoApiModel;", "<init>", "(Lcom/miami/game/core/api/model/response/game_info/GameInfoApiModel;)V", "getData", "()Lcom/miami/game/core/api/model/response/game_info/GameInfoApiModel;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api-model_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GameInfoResponseApiModel {
    @SerializedName("data")
    private final GameInfoApiModel data;

    public static /* synthetic */ GameInfoResponseApiModel copy$default(GameInfoResponseApiModel gameInfoResponseApiModel, GameInfoApiModel gameInfoApiModel, int i, Object obj) {
        if ((i & 1) != 0) {
            gameInfoApiModel = gameInfoResponseApiModel.data;
        }
        return gameInfoResponseApiModel.copy(gameInfoApiModel);
    }

    public final GameInfoApiModel component1() {
        return this.data;
    }

    public final GameInfoResponseApiModel copy(GameInfoApiModel gameInfoApiModel) {
        return new GameInfoResponseApiModel(gameInfoApiModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GameInfoResponseApiModel) && Intrinsics.areEqual(this.data, ((GameInfoResponseApiModel) obj).data);
    }

    public int hashCode() {
        GameInfoApiModel gameInfoApiModel = this.data;
        if (gameInfoApiModel == null) {
            return 0;
        }
        return gameInfoApiModel.hashCode();
    }

    public String toString() {
        return "GameInfoResponseApiModel(data=" + this.data + ")";
    }

    public GameInfoResponseApiModel(GameInfoApiModel gameInfoApiModel) {
        this.data = gameInfoApiModel;
    }

    public final GameInfoApiModel getData() {
        return this.data;
    }
}
