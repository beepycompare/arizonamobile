package com.miami.game.core.server.data;

import com.miami.game.core.server.model.ServerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FavoriteServerEntity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toFavoriteEntity", "Lcom/miami/game/core/server/data/FavoriteServerEntity;", "Lcom/miami/game/core/server/model/ServerModel;", "server_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FavoriteServerEntityKt {
    public static final FavoriteServerEntity toFavoriteEntity(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "<this>");
        String name = serverModel.getName();
        Intrinsics.checkNotNull(name);
        Integer number = serverModel.getNumber();
        Intrinsics.checkNotNull(number);
        return new FavoriteServerEntity(number.intValue(), name);
    }
}
