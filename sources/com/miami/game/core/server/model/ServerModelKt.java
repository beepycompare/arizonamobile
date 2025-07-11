package com.miami.game.core.server.model;

import com.miami.game.core.api.model.response.servers.ServersApiModelItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ServerModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"toDomain", "Lcom/miami/game/core/server/model/ServerModel;", "Lcom/miami/game/core/api/model/response/servers/ServersApiModelItem;", "isMobile", "", "isArizona", "server_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerModelKt {
    public static final ServerModel toDomain(ServersApiModelItem serversApiModelItem, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(serversApiModelItem, "<this>");
        return new ServerModel(serversApiModelItem.getNumber(), serversApiModelItem.getName(), serversApiModelItem.getIp(), serversApiModelItem.getPort(), serversApiModelItem.getOnline(), serversApiModelItem.getMaxplayers(), serversApiModelItem.getPassword(), serversApiModelItem.getVk(), serversApiModelItem.getTg(), serversApiModelItem.getInst(), serversApiModelItem.getIcon(), serversApiModelItem.getAdditionalIps(), serversApiModelItem.getPlotPoints(), serversApiModelItem.getXdonate(), serversApiModelItem.getXpayday(), serversApiModelItem.isTop(), serversApiModelItem.isNew(), false, z, z2, 131072, null);
    }
}
