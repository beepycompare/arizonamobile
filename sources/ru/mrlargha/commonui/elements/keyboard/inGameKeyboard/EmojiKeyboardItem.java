package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.StringKt;
/* compiled from: EmojiKeyboardAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardItem;", "", "tag", "", "codePoint", "", "<init>", "(Ljava/lang/String;I)V", "getTag", "()Ljava/lang/String;", "getCodePoint", "()I", "displayText", "getDisplayText", "inputText", "getInputText", "sendText", "getSendText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmojiKeyboardItem {
    private final int codePoint;
    private final String displayText;
    private final String inputText;
    private final String sendText;
    private final String tag;

    public static /* synthetic */ EmojiKeyboardItem copy$default(EmojiKeyboardItem emojiKeyboardItem, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = emojiKeyboardItem.tag;
        }
        if ((i2 & 2) != 0) {
            i = emojiKeyboardItem.codePoint;
        }
        return emojiKeyboardItem.copy(str, i);
    }

    public final String component1() {
        return this.tag;
    }

    public final int component2() {
        return this.codePoint;
    }

    public final EmojiKeyboardItem copy(String tag, int i) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new EmojiKeyboardItem(tag, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmojiKeyboardItem) {
            EmojiKeyboardItem emojiKeyboardItem = (EmojiKeyboardItem) obj;
            return Intrinsics.areEqual(this.tag, emojiKeyboardItem.tag) && this.codePoint == emojiKeyboardItem.codePoint;
        }
        return false;
    }

    public int hashCode() {
        return (this.tag.hashCode() * 31) + Integer.hashCode(this.codePoint);
    }

    public String toString() {
        String str = this.tag;
        return "EmojiKeyboardItem(tag=" + str + ", codePoint=" + this.codePoint + ")";
    }

    public EmojiKeyboardItem(String tag, int i) {
        boolean isRegionalIndicatorSymbol;
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.codePoint = i;
        String emojiByUnicode = StringKt.getEmojiByUnicode(i);
        this.displayText = emojiByUnicode;
        isRegionalIndicatorSymbol = EmojiKeyboardAdapterKt.isRegionalIndicatorSymbol(i);
        this.inputText = isRegionalIndicatorSymbol ? "\u200c" + emojiByUnicode + "\u200c" : emojiByUnicode;
        this.sendText = StringUtils.PROCESS_POSTFIX_DELIMITER + tag + StringUtils.PROCESS_POSTFIX_DELIMITER;
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getCodePoint() {
        return this.codePoint;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final String getInputText() {
        return this.inputText;
    }

    public final String getSendText() {
        return this.sendText;
    }
}
