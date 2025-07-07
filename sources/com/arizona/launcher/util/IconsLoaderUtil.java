package com.arizona.launcher.util;

import com.arizona.launcher.model.servers.SAMPServerInfo;
import com.arizona.launcher.model.servers.ServerType;
import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IconsLoaderUtil.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/util/IconsLoaderUtil;", "", "<init>", "()V", "getPathForServerIcon", "", "sampServerInfo", "Lcom/arizona/launcher/model/servers/SAMPServerInfo;", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IconsLoaderUtil {
    public static final int $stable = 0;
    public static final IconsLoaderUtil INSTANCE = new IconsLoaderUtil();

    private IconsLoaderUtil() {
    }

    public final String getPathForServerIcon(SAMPServerInfo sampServerInfo) {
        Intrinsics.checkNotNullParameter(sampServerInfo, "sampServerInfo");
        ServerType serverType = sampServerInfo.getServerType();
        return "file:///android_asset/servers_icons/" + serverType + RemoteSettings.FORWARD_SLASH_STRING + sampServerInfo.getId() + ".png";
    }
}
