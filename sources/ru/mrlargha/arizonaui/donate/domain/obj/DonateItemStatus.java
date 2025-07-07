package ru.mrlargha.arizonaui.donate.domain.obj;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateItem.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/arizonaui/donate/domain/obj/DonateItemStatus;", "", NotificationCompat.CATEGORY_STATUS, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "AVAILABLE", "PURCHASED", "DISABLED", "RESERVED", "COOLDOWN", "WAITING", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateItemStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonateItemStatus[] $VALUES;
    private final String status;
    public static final DonateItemStatus AVAILABLE = new DonateItemStatus("AVAILABLE", 0, "available");
    public static final DonateItemStatus PURCHASED = new DonateItemStatus("PURCHASED", 1, "purchased");
    public static final DonateItemStatus DISABLED = new DonateItemStatus("DISABLED", 2, "disabled");
    public static final DonateItemStatus RESERVED = new DonateItemStatus("RESERVED", 3, "reserved");
    public static final DonateItemStatus COOLDOWN = new DonateItemStatus("COOLDOWN", 4, "cooldown");
    public static final DonateItemStatus WAITING = new DonateItemStatus("WAITING", 5, "waiting");

    private static final /* synthetic */ DonateItemStatus[] $values() {
        return new DonateItemStatus[]{AVAILABLE, PURCHASED, DISABLED, RESERVED, COOLDOWN, WAITING};
    }

    public static EnumEntries<DonateItemStatus> getEntries() {
        return $ENTRIES;
    }

    private DonateItemStatus(String str, int i, String str2) {
        this.status = str2;
    }

    public final String getStatus() {
        return this.status;
    }

    static {
        DonateItemStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DonateItemStatus valueOf(String str) {
        return (DonateItemStatus) Enum.valueOf(DonateItemStatus.class, str);
    }

    public static DonateItemStatus[] values() {
        return (DonateItemStatus[]) $VALUES.clone();
    }
}
