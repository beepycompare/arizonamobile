package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard;

import kotlin.Metadata;
/* compiled from: EmojiKeyboardAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"REGIONAL_INDICATOR_SEPARATOR", "", "isRegionalIndicatorSymbol", "", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmojiKeyboardAdapterKt {
    private static final String REGIONAL_INDICATOR_SEPARATOR = "\u200c";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRegionalIndicatorSymbol(int i) {
        return 127462 <= i && i < 127488;
    }
}
