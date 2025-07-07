package com.miami.game.core.error.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NetworkErrorType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/error/model/NetworkErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "SSL", "CONNECTION", "UNKNOWN", "error_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkErrorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetworkErrorType[] $VALUES;
    public static final NetworkErrorType SSL = new NetworkErrorType("SSL", 0);
    public static final NetworkErrorType CONNECTION = new NetworkErrorType("CONNECTION", 1);
    public static final NetworkErrorType UNKNOWN = new NetworkErrorType("UNKNOWN", 2);

    private static final /* synthetic */ NetworkErrorType[] $values() {
        return new NetworkErrorType[]{SSL, CONNECTION, UNKNOWN};
    }

    public static EnumEntries<NetworkErrorType> getEntries() {
        return $ENTRIES;
    }

    private NetworkErrorType(String str, int i) {
    }

    static {
        NetworkErrorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static NetworkErrorType valueOf(String str) {
        return (NetworkErrorType) Enum.valueOf(NetworkErrorType.class, str);
    }

    public static NetworkErrorType[] values() {
        return (NetworkErrorType[]) $VALUES.clone();
    }
}
