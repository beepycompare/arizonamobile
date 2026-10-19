package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KeyboardPage.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/models/KeyboardPage;", "", "<init>", "(Ljava/lang/String;I)V", "RUS", "ENG", "SYMBOLS", "OTHER_SYMBOLS", "EMOJI", "BINDERS", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class KeyboardPage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KeyboardPage[] $VALUES;
    public static final KeyboardPage RUS = new KeyboardPage("RUS", 0);
    public static final KeyboardPage ENG = new KeyboardPage("ENG", 1);
    public static final KeyboardPage SYMBOLS = new KeyboardPage("SYMBOLS", 2);
    public static final KeyboardPage OTHER_SYMBOLS = new KeyboardPage("OTHER_SYMBOLS", 3);
    public static final KeyboardPage EMOJI = new KeyboardPage("EMOJI", 4);
    public static final KeyboardPage BINDERS = new KeyboardPage("BINDERS", 5);

    private static final /* synthetic */ KeyboardPage[] $values() {
        return new KeyboardPage[]{RUS, ENG, SYMBOLS, OTHER_SYMBOLS, EMOJI, BINDERS};
    }

    public static EnumEntries<KeyboardPage> getEntries() {
        return $ENTRIES;
    }

    public static KeyboardPage valueOf(String str) {
        return (KeyboardPage) Enum.valueOf(KeyboardPage.class, str);
    }

    public static KeyboardPage[] values() {
        return (KeyboardPage[]) $VALUES.clone();
    }

    private KeyboardPage(String str, int i) {
    }

    static {
        KeyboardPage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
