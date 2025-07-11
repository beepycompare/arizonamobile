package com.arizona.launcher.model.servers;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ServerType.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/model/servers/ServerType;", "", "serverName", "", "backendLaunchCode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getServerName", "()Ljava/lang/String;", "getBackendLaunchCode", "()I", "ARIZONA", "RODINA", "RODINA_MOBILE", "ARIZONA_MOBILE", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ServerType[] $VALUES;
    private final int backendLaunchCode;
    private final String serverName;
    public static final ServerType ARIZONA = new ServerType("ARIZONA", 0, "Arizona", 0);
    public static final ServerType RODINA = new ServerType("RODINA", 1, "Rodina\nRolePlay", 1);
    public static final ServerType RODINA_MOBILE = new ServerType("RODINA_MOBILE", 2, "Rodina Mobile", 2);
    public static final ServerType ARIZONA_MOBILE = new ServerType("ARIZONA_MOBILE", 3, "Arizona\nMobile", 4);

    private static final /* synthetic */ ServerType[] $values() {
        return new ServerType[]{ARIZONA, RODINA, RODINA_MOBILE, ARIZONA_MOBILE};
    }

    public static EnumEntries<ServerType> getEntries() {
        return $ENTRIES;
    }

    public static ServerType valueOf(String str) {
        return (ServerType) Enum.valueOf(ServerType.class, str);
    }

    public static ServerType[] values() {
        return (ServerType[]) $VALUES.clone();
    }

    private ServerType(String str, int i, String str2, int i2) {
        this.serverName = str2;
        this.backendLaunchCode = i2;
    }

    /* synthetic */ ServerType(String str, int i, String str2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i3 & 2) != 0 ? 0 : i2);
    }

    public final String getServerName() {
        return this.serverName;
    }

    public final int getBackendLaunchCode() {
        return this.backendLaunchCode;
    }

    static {
        ServerType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
