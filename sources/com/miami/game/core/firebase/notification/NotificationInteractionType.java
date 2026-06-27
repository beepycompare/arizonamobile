package com.miami.game.core.firebase.notification;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NotificationInteractionEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/firebase/notification/NotificationInteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "RECEIVED", "DISPLAYED", "OPENED", "GAME_LAUNCHED", "firebase-notification"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationInteractionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NotificationInteractionType[] $VALUES;
    public static final NotificationInteractionType RECEIVED = new NotificationInteractionType("RECEIVED", 0);
    public static final NotificationInteractionType DISPLAYED = new NotificationInteractionType("DISPLAYED", 1);
    public static final NotificationInteractionType OPENED = new NotificationInteractionType("OPENED", 2);
    public static final NotificationInteractionType GAME_LAUNCHED = new NotificationInteractionType("GAME_LAUNCHED", 3);

    private static final /* synthetic */ NotificationInteractionType[] $values() {
        return new NotificationInteractionType[]{RECEIVED, DISPLAYED, OPENED, GAME_LAUNCHED};
    }

    public static EnumEntries<NotificationInteractionType> getEntries() {
        return $ENTRIES;
    }

    public static NotificationInteractionType valueOf(String str) {
        return (NotificationInteractionType) Enum.valueOf(NotificationInteractionType.class, str);
    }

    public static NotificationInteractionType[] values() {
        return (NotificationInteractionType[]) $VALUES.clone();
    }

    private NotificationInteractionType(String str, int i) {
    }

    static {
        NotificationInteractionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
