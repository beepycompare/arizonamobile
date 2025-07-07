package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.SpannedExtensions_androidKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\n\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001cH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002\u001a\u0016\u0010 \u001a\u00020\u0006*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidParagraph_androidKt {
    public static final /* synthetic */ CharSequence access$attachIndentationFixSpan(CharSequence charSequence) {
        return attachIndentationFixSpan(charSequence);
    }

    public static final /* synthetic */ int access$numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        return numberOfLinesThatFitMaxHeight(textLayout, i);
    }

    public static final /* synthetic */ boolean access$shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return shouldAttachIndentationFixSpan(textStyle, z);
    }

    /* renamed from: access$toLayoutAlign-aXe7zB0  reason: not valid java name */
    public static final /* synthetic */ int m5964access$toLayoutAlignaXe7zB0(int i) {
        return m5970toLayoutAlignaXe7zB0(i);
    }

    /* renamed from: access$toLayoutBreakStrategy-xImikfE  reason: not valid java name */
    public static final /* synthetic */ int m5965access$toLayoutBreakStrategyxImikfE(int i) {
        return m5971toLayoutBreakStrategyxImikfE(i);
    }

    /* renamed from: access$toLayoutHyphenationFrequency--3fSNIE  reason: not valid java name */
    public static final /* synthetic */ int m5966access$toLayoutHyphenationFrequency3fSNIE(int i) {
        return m5972toLayoutHyphenationFrequency3fSNIE(i);
    }

    /* renamed from: access$toLayoutLineBreakStyle-hpcqdu8  reason: not valid java name */
    public static final /* synthetic */ int m5967access$toLayoutLineBreakStylehpcqdu8(int i) {
        return m5973toLayoutLineBreakStylehpcqdu8(i);
    }

    /* renamed from: access$toLayoutLineBreakWordStyle-wPN0Rpw  reason: not valid java name */
    public static final /* synthetic */ int m5968access$toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return m5974toLayoutLineBreakWordStylewPN0Rpw(i);
    }

    /* renamed from: access$toLayoutTextGranularity-duNsdkg  reason: not valid java name */
    public static final /* synthetic */ int m5969access$toLayoutTextGranularityduNsdkg(int i) {
        return m5975toLayoutTextGranularityduNsdkg(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-aXe7zB0  reason: not valid java name */
    public static final int m5970toLayoutAlignaXe7zB0(int i) {
        if (TextAlign.m6564equalsimpl0(i, TextAlign.Companion.m6571getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m6564equalsimpl0(i, TextAlign.Companion.m6572getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m6564equalsimpl0(i, TextAlign.Companion.m6568getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m6564equalsimpl0(i, TextAlign.Companion.m6573getStarte0LSkKk()) && TextAlign.m6564equalsimpl0(i, TextAlign.Companion.m6569getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency--3fSNIE  reason: not valid java name */
    public static final int m5972toLayoutHyphenationFrequency3fSNIE(int i) {
        if (Hyphens.m6462equalsimpl0(i, Hyphens.Companion.m6466getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m6462equalsimpl0(i, Hyphens.Companion.m6467getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-xImikfE  reason: not valid java name */
    public static final int m5971toLayoutBreakStrategyxImikfE(int i) {
        if (LineBreak.Strategy.m6493equalsimpl0(i, LineBreak.Strategy.Companion.m6499getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m6493equalsimpl0(i, LineBreak.Strategy.Companion.m6498getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m6493equalsimpl0(i, LineBreak.Strategy.Companion.m6497getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-hpcqdu8  reason: not valid java name */
    public static final int m5973toLayoutLineBreakStylehpcqdu8(int i) {
        if (LineBreak.Strictness.m6504equalsimpl0(i, LineBreak.Strictness.Companion.m6508getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m6504equalsimpl0(i, LineBreak.Strictness.Companion.m6509getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m6504equalsimpl0(i, LineBreak.Strictness.Companion.m6510getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m6504equalsimpl0(i, LineBreak.Strictness.Companion.m6511getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-wPN0Rpw  reason: not valid java name */
    public static final int m5974toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return (!LineBreak.WordBreak.m6516equalsimpl0(i, LineBreak.WordBreak.Companion.m6520getDefaultjp8hJ3c()) && LineBreak.WordBreak.m6516equalsimpl0(i, LineBreak.WordBreak.Companion.m6521getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return (!z || TextUnit.m6875equalsimpl0(textStyle.m6183getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m6875equalsimpl0(textStyle.m6183getLetterSpacingXSAIIZE(), TextUnit.Companion.m6889getUnspecifiedXSAIIZE()) || TextAlign.m6564equalsimpl0(textStyle.m6188getTextAligne0LSkKk(), TextAlign.Companion.m6574getUnspecifiede0LSkKk()) || TextAlign.m6564equalsimpl0(textStyle.m6188getTextAligne0LSkKk(), TextAlign.Companion.m6573getStarte0LSkKk()) || TextAlign.m6564equalsimpl0(textStyle.m6188getTextAligne0LSkKk(), TextAlign.Companion.m6570getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannableString == null) {
            spannableString = new SpannableString(charSequence);
        }
        if (!SpannedExtensions_androidKt.hasSpan(spannableString, IndentationFixSpan.class)) {
            SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutTextGranularity-duNsdkg  reason: not valid java name */
    public static final int m5975toLayoutTextGranularityduNsdkg(int i) {
        return (!TextGranularity.m6105equalsimpl0(i, TextGranularity.Companion.m6109getCharacterDRrd7Zo()) && TextGranularity.m6105equalsimpl0(i, TextGranularity.Companion.m6110getWordDRrd7Zo())) ? 1 : 0;
    }
}
