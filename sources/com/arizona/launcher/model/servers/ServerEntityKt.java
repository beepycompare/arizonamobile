package com.arizona.launcher.model.servers;

import com.arizona.launcher.model.servers.SAMPServerInfo;
import java.net.InetAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: ServerEntity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toEntity", "Lcom/arizona/launcher/model/servers/ServerEntity;", "Lcom/arizona/launcher/model/servers/SAMPServerInfo;", "toUi", "app_arizonaRelease_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerEntityKt {
    public static final ServerEntity toEntity(SAMPServerInfo sAMPServerInfo) {
        Intrinsics.checkNotNullParameter(sAMPServerInfo, "<this>");
        int id = sAMPServerInfo.getId();
        String hostAddress = sAMPServerInfo.getAddress().getHostAddress();
        if (hostAddress == null) {
            hostAddress = "";
        }
        int port = sAMPServerInfo.getPort();
        boolean hasPassword = sAMPServerInfo.getHasPassword();
        int currentPlayerCount = sAMPServerInfo.getCurrentPlayerCount();
        int maxPlayerCount = sAMPServerInfo.getMaxPlayerCount();
        String serverName = sAMPServerInfo.getServerName();
        String tg = sAMPServerInfo.getTg();
        String vk = sAMPServerInfo.getVk();
        String inst = sAMPServerInfo.getInst();
        boolean favorite = sAMPServerInfo.getFavorite();
        ServerType serverType = sAMPServerInfo.getServerType();
        int ping = sAMPServerInfo.getPing();
        String stringJson = StringKt.toStringJson(sAMPServerInfo.getPlotPoints());
        String serverIcon = sAMPServerInfo.getServerIcon();
        if (serverIcon == null) {
            serverIcon = "";
        }
        return new ServerEntity(id, hostAddress, port, hasPassword, currentPlayerCount, maxPlayerCount, serverName, tg, vk, inst, favorite, serverType, ping, stringJson, serverIcon);
    }

    public static final SAMPServerInfo toUi(ServerEntity serverEntity) {
        Intrinsics.checkNotNullParameter(serverEntity, "<this>");
        int id = serverEntity.getId();
        InetAddress byName = InetAddress.getByName(serverEntity.getAddress());
        Intrinsics.checkNotNullExpressionValue(byName, "getByName(...)");
        return new SAMPServerInfo(id, byName, serverEntity.getPort(), serverEntity.getHasPassword(), serverEntity.getCurrentPlayerCount(), serverEntity.getMaxPlayerCount(), serverEntity.getServerName(), serverEntity.getTg(), serverEntity.getVk(), serverEntity.getInst(), serverEntity.getFavorite(), serverEntity.getServerType(), serverEntity.getPing(), MapperKt.toListModel(serverEntity.getPlotPoints(), SAMPServerInfo.PlotPoint.class), serverEntity.getServerIcon());
    }
}
