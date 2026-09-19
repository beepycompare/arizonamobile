package ru.mrlargha.commonui.elements.donate.presentation.models;

import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "LOCKED", "AVAILABLE", "RECEIVED", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassTierStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonatePayPassTierStatus[] $VALUES;
    public static final Companion Companion;
    private final String wireValue;
    public static final DonatePayPassTierStatus LOCKED = new DonatePayPassTierStatus("LOCKED", 0, "locked");
    public static final DonatePayPassTierStatus AVAILABLE = new DonatePayPassTierStatus("AVAILABLE", 1, "available");
    public static final DonatePayPassTierStatus RECEIVED = new DonatePayPassTierStatus("RECEIVED", 2, NotificationStatsPayloadFactory.API_EVENT_RECEIVED);

    private static final /* synthetic */ DonatePayPassTierStatus[] $values() {
        return new DonatePayPassTierStatus[]{LOCKED, AVAILABLE, RECEIVED};
    }

    public static EnumEntries<DonatePayPassTierStatus> getEntries() {
        return $ENTRIES;
    }

    public static DonatePayPassTierStatus valueOf(String str) {
        return (DonatePayPassTierStatus) Enum.valueOf(DonatePayPassTierStatus.class, str);
    }

    public static DonatePayPassTierStatus[] values() {
        return (DonatePayPassTierStatus[]) $VALUES.clone();
    }

    private DonatePayPassTierStatus(String str, int i, String str2) {
        this.wireValue = str2;
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    static {
        DonatePayPassTierStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: DonatePayPassState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus$Companion;", "", "<init>", "()V", "fromWire", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;", "value", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DonatePayPassTierStatus fromWire(String str) {
            Object obj;
            Iterator<E> it = DonatePayPassTierStatus.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((DonatePayPassTierStatus) obj).getWireValue(), str)) {
                    break;
                }
            }
            return (DonatePayPassTierStatus) obj;
        }
    }
}
