package androidx.compose.foundation.internal;

import android.os.Parcel;
import android.util.Base64;
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
/* compiled from: ClipboardUtils.android.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/internal/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", TypedValues.Custom.S_FLOAT, "", "int", "", TypedValues.Custom.S_STRING, "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
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
        if (!Color.m4079equalsimpl0(spanStyle.m6088getColor0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m570encode8_81llA(spanStyle.m6088getColor0d7_KjU());
        }
        if (!TextUnit.m6875equalsimpl0(spanStyle.m6089getFontSizeXSAIIZE(), TextUnit.Companion.m6889getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m567encodeR2X_6o(spanStyle.m6089getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle m6090getFontStyle4Lr2A7w = spanStyle.m6090getFontStyle4Lr2A7w();
        if (m6090getFontStyle4Lr2A7w != null) {
            int m6262unboximpl = m6090getFontStyle4Lr2A7w.m6262unboximpl();
            encode((byte) 4);
            m572encodenzbMABs(m6262unboximpl);
        }
        FontSynthesis m6091getFontSynthesisZQGJjVo = spanStyle.m6091getFontSynthesisZQGJjVo();
        if (m6091getFontSynthesisZQGJjVo != null) {
            int m6275unboximpl = m6091getFontSynthesisZQGJjVo.m6275unboximpl();
            encode((byte) 5);
            m569encode6p3vJLY(m6275unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m6875equalsimpl0(spanStyle.m6092getLetterSpacingXSAIIZE(), TextUnit.Companion.m6889getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m567encodeR2X_6o(spanStyle.m6092getLetterSpacingXSAIIZE());
        }
        BaselineShift m6087getBaselineShift5SSeXJ0 = spanStyle.m6087getBaselineShift5SSeXJ0();
        if (m6087getBaselineShift5SSeXJ0 != null) {
            float m6446unboximpl = m6087getBaselineShift5SSeXJ0.m6446unboximpl();
            encode((byte) 8);
            m568encode4Dl_Bck(m6446unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m4079equalsimpl0(spanStyle.m6086getBackground0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m570encode8_81llA(spanStyle.m6086getBackground0d7_KjU());
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
    public final void m570encode8_81llA(long j) {
        m571encodeVKZWuLQ(j);
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m567encodeR2X_6o(long j) {
        long m6877getTypeUIouoOA = TextUnit.m6877getTypeUIouoOA(j);
        byte b = 0;
        if (!TextUnitType.m6906equalsimpl0(m6877getTypeUIouoOA, TextUnitType.Companion.m6912getUnspecifiedUIouoOA())) {
            if (TextUnitType.m6906equalsimpl0(m6877getTypeUIouoOA, TextUnitType.Companion.m6911getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m6906equalsimpl0(m6877getTypeUIouoOA, TextUnitType.Companion.m6910getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m6906equalsimpl0(TextUnit.m6877getTypeUIouoOA(j), TextUnitType.Companion.m6912getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m6878getValueimpl(j));
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m572encodenzbMABs(int i) {
        byte b = 0;
        if (!FontStyle.m6259equalsimpl0(i, FontStyle.Companion.m6266getNormal_LCdwA()) && FontStyle.m6259equalsimpl0(i, FontStyle.Companion.m6265getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m569encode6p3vJLY(int i) {
        byte b = 0;
        if (!FontSynthesis.m6270equalsimpl0(i, FontSynthesis.Companion.m6277getNoneGVVA2EU())) {
            if (FontSynthesis.m6270equalsimpl0(i, FontSynthesis.Companion.m6276getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m6270equalsimpl0(i, FontSynthesis.Companion.m6279getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m6270equalsimpl0(i, FontSynthesis.Companion.m6278getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m568encode4Dl_Bck(float f) {
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
        m570encode8_81llA(shadow.m4404getColor0d7_KjU());
        encode(Float.intBitsToFloat((int) (shadow.m4405getOffsetF1C5BW0() >> 32)));
        encode(Float.intBitsToFloat((int) (shadow.m4405getOffsetF1C5BW0() & 4294967295L)));
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
    public final void m571encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String str) {
        this.parcel.writeString(str);
    }
}
