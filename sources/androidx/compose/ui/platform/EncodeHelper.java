package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.graphics.AndroidColor_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.ULong;
/* compiled from: AndroidClipboardManager.android.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.¢\u0006\u0004\b/\u0010\u0010J\u000e\u0010\n\u001a\u00020\u00072\u0006\u00100\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "reset", "", "encodedString", "", "encode", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "byte", "", "int", "", TypedValues.Custom.S_FLOAT, "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", TypedValues.Custom.S_STRING, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EncodeHelper {
    public static final int $stable = 8;
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        if (!Color.m5281equalsimpl0(spanStyle.m7399getColor0d7_KjU(), Color.Companion.m5316getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m7139encode8_81llA(spanStyle.m7399getColor0d7_KjU());
        }
        if (!TextUnit.m8187equalsimpl0(spanStyle.m7400getFontSizeXSAIIZE(), TextUnit.Companion.m8201getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m7136encodeR2X_6o(spanStyle.m7400getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle m7401getFontStyle4Lr2A7w = spanStyle.m7401getFontStyle4Lr2A7w();
        if (m7401getFontStyle4Lr2A7w != null) {
            int m7574unboximpl = m7401getFontStyle4Lr2A7w.m7574unboximpl();
            encode((byte) 4);
            m7141encodenzbMABs(m7574unboximpl);
        }
        FontSynthesis m7402getFontSynthesisZQGJjVo = spanStyle.m7402getFontSynthesisZQGJjVo();
        if (m7402getFontSynthesisZQGJjVo != null) {
            int m7587unboximpl = m7402getFontSynthesisZQGJjVo.m7587unboximpl();
            encode((byte) 5);
            m7138encode6p3vJLY(m7587unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m8187equalsimpl0(spanStyle.m7403getLetterSpacingXSAIIZE(), TextUnit.Companion.m8201getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m7136encodeR2X_6o(spanStyle.m7403getLetterSpacingXSAIIZE());
        }
        BaselineShift m7398getBaselineShift5SSeXJ0 = spanStyle.m7398getBaselineShift5SSeXJ0();
        if (m7398getBaselineShift5SSeXJ0 != null) {
            float m7758unboximpl = m7398getBaselineShift5SSeXJ0.m7758unboximpl();
            encode((byte) 8);
            m7137encode4Dl_Bck(m7758unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m5281equalsimpl0(spanStyle.m7397getBackground0d7_KjU(), Color.Companion.m5316getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m7139encode8_81llA(spanStyle.m7397getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode(Ascii.VT);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode(Ascii.FF);
            encode(shadow);
        }
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m7139encode8_81llA(long j) {
        m7140encodeVKZWuLQ(ULong.m10083constructorimpl(AndroidColor_androidKt.m5144toColorLong8_81llA(j)));
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m7136encodeR2X_6o(long j) {
        long m8189getTypeUIouoOA = TextUnit.m8189getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m8218equalsimpl0(m8189getTypeUIouoOA, TextUnitType.Companion.m8224getUnspecifiedUIouoOA())) {
            if (TextUnitType.m8218equalsimpl0(m8189getTypeUIouoOA, TextUnitType.Companion.m8223getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m8218equalsimpl0(m8189getTypeUIouoOA, TextUnitType.Companion.m8222getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m8218equalsimpl0(TextUnit.m8189getTypeUIouoOA(j), TextUnitType.Companion.m8224getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m8190getValueimpl(j));
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m7141encodenzbMABs(int i) {
        byte b = 0;
        if (!FontStyle.m7571equalsimpl0(i, FontStyle.Companion.m7578getNormal_LCdwA()) && FontStyle.m7571equalsimpl0(i, FontStyle.Companion.m7577getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m7138encode6p3vJLY(int i) {
        byte b = 0;
        if (!FontSynthesis.m7582equalsimpl0(i, FontSynthesis.Companion.m7589getNoneGVVA2EU())) {
            if (FontSynthesis.m7582equalsimpl0(i, FontSynthesis.Companion.m7588getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m7582equalsimpl0(i, FontSynthesis.Companion.m7591getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m7582equalsimpl0(i, FontSynthesis.Companion.m7590getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m7137encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m7139encode8_81llA(shadow.m5620getColor0d7_KjU());
        encode(Float.intBitsToFloat((int) (shadow.m5621getOffsetF1C5BW0() >> 32)));
        encode(Float.intBitsToFloat((int) (shadow.m5621getOffsetF1C5BW0() & 4294967295L)));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m7140encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String str) {
        this.parcel.writeString(str);
    }
}
