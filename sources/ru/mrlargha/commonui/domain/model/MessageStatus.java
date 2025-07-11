package ru.mrlargha.commonui.domain.model;

import android.graphics.Color;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MessageStatus.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/domain/model/MessageStatus;", "", "value", "", "color", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getColor", "ONLINE", "OFFLINE", "AFK", "NONE", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageStatus[] $VALUES;
    public static final Companion Companion;
    private final int color;
    private final int value;
    public static final MessageStatus ONLINE = new MessageStatus("ONLINE", 0, 0, Color.parseColor("#6CCE48"));
    public static final MessageStatus OFFLINE = new MessageStatus("OFFLINE", 1, 1, Color.parseColor("#363636"));
    public static final MessageStatus AFK = new MessageStatus("AFK", 2, 2, Color.parseColor("#E18E30"));
    public static final MessageStatus NONE = new MessageStatus("NONE", 3, 3, 0);

    private static final /* synthetic */ MessageStatus[] $values() {
        return new MessageStatus[]{ONLINE, OFFLINE, AFK, NONE};
    }

    public static EnumEntries<MessageStatus> getEntries() {
        return $ENTRIES;
    }

    public static MessageStatus valueOf(String str) {
        return (MessageStatus) Enum.valueOf(MessageStatus.class, str);
    }

    public static MessageStatus[] values() {
        return (MessageStatus[]) $VALUES.clone();
    }

    private MessageStatus(String str, int i, int i2, int i3) {
        this.value = i2;
        this.color = i3;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        MessageStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    /* compiled from: MessageStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/domain/model/MessageStatus$Companion;", "", "<init>", "()V", "fromStatus", "Lru/mrlargha/commonui/domain/model/MessageStatus;", "value", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageStatus fromStatus(int i) {
            Object obj;
            Iterator<E> it = MessageStatus.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((MessageStatus) obj).getValue() == i) {
                    break;
                }
            }
            MessageStatus messageStatus = (MessageStatus) obj;
            return messageStatus == null ? MessageStatus.NONE : messageStatus;
        }
    }
}
