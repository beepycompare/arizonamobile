package com.miami.game.core.connection.resolver;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FirebaseServerHandler.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/miami/game/core/connection/resolver/FirebaseConfigLinks;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "MAIN_RESOURCE", "RESERVE_RESOURCE", "SERVER_API", "RESERVE_SERVER_API", "MAIN_SOUND", "RESERVE_SOUND", "MAIN_HUD_PING", "RESERVE_HUD_PING", "connection-resolver"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirebaseConfigLinks {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FirebaseConfigLinks[] $VALUES;
    private final String key;
    public static final FirebaseConfigLinks MAIN_RESOURCE = new FirebaseConfigLinks("MAIN_RESOURCE", 0, "main_resource");
    public static final FirebaseConfigLinks RESERVE_RESOURCE = new FirebaseConfigLinks("RESERVE_RESOURCE", 1, "reserve_resource");
    public static final FirebaseConfigLinks SERVER_API = new FirebaseConfigLinks("SERVER_API", 2, "server_api");
    public static final FirebaseConfigLinks RESERVE_SERVER_API = new FirebaseConfigLinks("RESERVE_SERVER_API", 3, "reserve_server_api");
    public static final FirebaseConfigLinks MAIN_SOUND = new FirebaseConfigLinks("MAIN_SOUND", 4, "main_sound");
    public static final FirebaseConfigLinks RESERVE_SOUND = new FirebaseConfigLinks("RESERVE_SOUND", 5, "reserve_sound");
    public static final FirebaseConfigLinks MAIN_HUD_PING = new FirebaseConfigLinks("MAIN_HUD_PING", 6, "main_hud_ping");
    public static final FirebaseConfigLinks RESERVE_HUD_PING = new FirebaseConfigLinks("RESERVE_HUD_PING", 7, "reserve_hud_ping");

    private static final /* synthetic */ FirebaseConfigLinks[] $values() {
        return new FirebaseConfigLinks[]{MAIN_RESOURCE, RESERVE_RESOURCE, SERVER_API, RESERVE_SERVER_API, MAIN_SOUND, RESERVE_SOUND, MAIN_HUD_PING, RESERVE_HUD_PING};
    }

    public static EnumEntries<FirebaseConfigLinks> getEntries() {
        return $ENTRIES;
    }

    public static FirebaseConfigLinks valueOf(String str) {
        return (FirebaseConfigLinks) Enum.valueOf(FirebaseConfigLinks.class, str);
    }

    public static FirebaseConfigLinks[] values() {
        return (FirebaseConfigLinks[]) $VALUES.clone();
    }

    private FirebaseConfigLinks(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        FirebaseConfigLinks[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
