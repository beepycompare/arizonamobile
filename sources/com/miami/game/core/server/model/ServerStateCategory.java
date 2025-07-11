package com.miami.game.core.server.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ServersState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/server/model/ServerStateCategory;", "", "<init>", "(Ljava/lang/String;I)V", "Mobile", "Desktop", "Favorite", "server_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerStateCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ServerStateCategory[] $VALUES;
    public static final ServerStateCategory Mobile = new ServerStateCategory("Mobile", 0);
    public static final ServerStateCategory Desktop = new ServerStateCategory("Desktop", 1);
    public static final ServerStateCategory Favorite = new ServerStateCategory("Favorite", 2);

    private static final /* synthetic */ ServerStateCategory[] $values() {
        return new ServerStateCategory[]{Mobile, Desktop, Favorite};
    }

    public static EnumEntries<ServerStateCategory> getEntries() {
        return $ENTRIES;
    }

    public static ServerStateCategory valueOf(String str) {
        return (ServerStateCategory) Enum.valueOf(ServerStateCategory.class, str);
    }

    public static ServerStateCategory[] values() {
        return (ServerStateCategory[]) $VALUES.clone();
    }

    private ServerStateCategory(String str, int i) {
    }

    static {
        ServerStateCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
