package ru.mrlargha.arizonaui.mobile.presentation.page.messenger;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MessengerChat.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuId;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "ADD_REMOVE_CONTACT", "CALL_CONTACT", "CLEAR_MESSAGES", "NOTIFICATIONS", "PIN_CONTACT", "BLOCK_CONTACT", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MenuId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MenuId[] $VALUES;
    private final int id;
    public static final MenuId ADD_REMOVE_CONTACT = new MenuId("ADD_REMOVE_CONTACT", 0, 1);
    public static final MenuId CALL_CONTACT = new MenuId("CALL_CONTACT", 1, 2);
    public static final MenuId CLEAR_MESSAGES = new MenuId("CLEAR_MESSAGES", 2, 3);
    public static final MenuId NOTIFICATIONS = new MenuId("NOTIFICATIONS", 3, 4);
    public static final MenuId PIN_CONTACT = new MenuId("PIN_CONTACT", 4, 5);
    public static final MenuId BLOCK_CONTACT = new MenuId("BLOCK_CONTACT", 5, 6);

    private static final /* synthetic */ MenuId[] $values() {
        return new MenuId[]{ADD_REMOVE_CONTACT, CALL_CONTACT, CLEAR_MESSAGES, NOTIFICATIONS, PIN_CONTACT, BLOCK_CONTACT};
    }

    public static EnumEntries<MenuId> getEntries() {
        return $ENTRIES;
    }

    public static MenuId valueOf(String str) {
        return (MenuId) Enum.valueOf(MenuId.class, str);
    }

    public static MenuId[] values() {
        return (MenuId[]) $VALUES.clone();
    }

    private MenuId(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        MenuId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
