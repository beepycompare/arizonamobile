package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.emoji2.text.EmojiCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.lang.Character;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: WordIterator.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", TtmlNode.START, "", TtmlNode.END, CommonUrlParts.LOCALE, "Ljava/util/Locale;", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "getCharSequence", "()Ljava/lang/CharSequence;", "iterator", "Ljava/text/BreakIterator;", "checkOffsetIsValid", "", TypedValues.CycleType.S_WAVE_OFFSET, "getBeginning", "getPrevWordBeginningOnTwoWordsBoundary", "", "getEnd", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterLetterOrDigitOrEmoji", "isAfterPunctuation", "isBoundary", "isHiraganaKatakanaBoundary", "isOnLetterOrDigitOrEmoji", "isOnPunctuation", "isPunctuationEndBoundary", "isPunctuationStartBoundary", "nextBoundary", "prevBoundary", "Companion", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WordIterator {
    private static final int WINDOW_WIDTH = 50;
    private final CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public WordIterator(CharSequence charSequence, int i, int i2, Locale locale) {
        this.charSequence = charSequence;
        boolean z = true;
        if (!(i >= 0 && i <= charSequence.length())) {
            InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
        }
        if (!((i2 < 0 || i2 > charSequence.length()) ? false : z)) {
            InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.iterator = wordInstance;
        this.start = Math.max(0, i - 50);
        this.end = Math.min(charSequence.length(), i2 + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i, i2));
    }

    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    public final int nextBoundary(int i) {
        checkOffsetIsValid(i);
        int following = this.iterator.following(i);
        return (isOnLetterOrDigitOrEmoji(following + (-1)) && isOnLetterOrDigitOrEmoji(following) && !isHiraganaKatakanaBoundary(following)) ? nextBoundary(following) : following;
    }

    public final int prevBoundary(int i) {
        checkOffsetIsValid(i);
        int preceding = this.iterator.preceding(i);
        return (isOnLetterOrDigitOrEmoji(preceding) && isAfterLetterOrDigitOrEmoji(preceding) && !isHiraganaKatakanaBoundary(preceding)) ? prevBoundary(preceding) : preceding;
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int i) {
        return getBeginning(i, true);
    }

    public final int getNextWordEndOnTwoWordBoundary(int i) {
        return getEnd(i, true);
    }

    public final int getPunctuationBeginning(int i) {
        checkOffsetIsValid(i);
        while (i != -1 && !isPunctuationStartBoundary(i)) {
            i = prevBoundary(i);
        }
        return i;
    }

    public final int getPunctuationEnd(int i) {
        checkOffsetIsValid(i);
        while (i != -1 && !isPunctuationEndBoundary(i)) {
            i = nextBoundary(i);
        }
        return i;
    }

    public final boolean isAfterPunctuation(int i) {
        int i2 = this.start + 1;
        if (i > this.end || i2 > i) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointBefore(this.charSequence, i));
    }

    public final boolean isOnPunctuation(int i) {
        int i2 = this.start;
        if (i >= this.end || i2 > i) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointAt(this.charSequence, i));
    }

    private final int getBeginning(int i, boolean z) {
        checkOffsetIsValid(i);
        if (isOnLetterOrDigitOrEmoji(i)) {
            return (!isBoundary(i) || (isAfterLetterOrDigitOrEmoji(i) && z)) ? prevBoundary(i) : i;
        } else if (isAfterLetterOrDigitOrEmoji(i)) {
            return prevBoundary(i);
        } else {
            return -1;
        }
    }

    private final int getEnd(int i, boolean z) {
        checkOffsetIsValid(i);
        if (isAfterLetterOrDigitOrEmoji(i)) {
            return (!isBoundary(i) || (isOnLetterOrDigitOrEmoji(i) && z)) ? nextBoundary(i) : i;
        } else if (isOnLetterOrDigitOrEmoji(i)) {
            return nextBoundary(i);
        } else {
            return -1;
        }
    }

    private final boolean isPunctuationStartBoundary(int i) {
        return isOnPunctuation(i) && !isAfterPunctuation(i);
    }

    private final boolean isPunctuationEndBoundary(int i) {
        return !isOnPunctuation(i) && isAfterPunctuation(i);
    }

    private final boolean isAfterLetterOrDigitOrEmoji(int i) {
        int i2 = this.start + 1;
        if (i > this.end || i2 > i) {
            return false;
        }
        if (Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, i))) {
            return true;
        }
        int i3 = i - 1;
        if (Character.isSurrogate(this.charSequence.charAt(i3))) {
            return true;
        }
        if (EmojiCompat.isConfigured()) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            return emojiCompat.getLoadState() == 1 && emojiCompat.getEmojiStart(this.charSequence, i3) != -1;
        }
        return false;
    }

    private final boolean isOnLetterOrDigitOrEmoji(int i) {
        int i2 = this.start;
        if (i >= this.end || i2 > i) {
            return false;
        }
        if (Character.isLetterOrDigit(Character.codePointAt(this.charSequence, i)) || Character.isSurrogate(this.charSequence.charAt(i))) {
            return true;
        }
        if (EmojiCompat.isConfigured()) {
            EmojiCompat emojiCompat = EmojiCompat.get();
            return emojiCompat.getLoadState() == 1 && emojiCompat.getEmojiStart(this.charSequence, i) != -1;
        }
        return false;
    }

    private final void checkOffsetIsValid(int i) {
        int i2 = this.start;
        boolean z = false;
        if (i <= this.end && i2 <= i) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Invalid offset: " + i + ". Valid range is [" + this.start + " , " + this.end + AbstractJsonLexerKt.END_LIST);
    }

    private final boolean isBoundary(int i) {
        checkOffsetIsValid(i);
        if (this.iterator.isBoundary(i)) {
            if (isOnLetterOrDigitOrEmoji(i) && isOnLetterOrDigitOrEmoji(i - 1) && isOnLetterOrDigitOrEmoji(i + 1)) {
                return false;
            }
            return i <= 0 || i >= this.charSequence.length() - 1 || !(isHiraganaKatakanaBoundary(i) || isHiraganaKatakanaBoundary(i + 1));
        }
        return false;
    }

    private final boolean isHiraganaKatakanaBoundary(int i) {
        int i2 = i - 1;
        if (Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(i2)), Character.UnicodeBlock.HIRAGANA) && Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(i)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(i)), Character.UnicodeBlock.HIRAGANA) && Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(i2)), Character.UnicodeBlock.KATAKANA);
    }

    /* compiled from: WordIterator.android.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPunctuation$ui_text_release(int i) {
            int type = Character.getType(i);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }
    }
}
