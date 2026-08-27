package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ULong;
/* compiled from: AndroidClipboardManager.android.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\r\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\rJ\u0006\u0010\u0011\u001a\u00020\u0012J\r\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u000f\u0010(\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010\rJ\b\u0010+\u001a\u00020,H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010.\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", TypedValues.Custom.S_STRING, "", "<init>", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeByte", "", "decodeInt", "", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "decodeFloat", "", "decodeString", "dataAvailable", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DecodeHelper {
    public static final int $stable = 8;
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel obtain = Parcel.obtain();
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte decodeByte = decodeByte();
            if (decodeByte != 1) {
                if (decodeByte != 2) {
                    if (decodeByte != 3) {
                        if (decodeByte != 4) {
                            if (decodeByte != 5) {
                                if (decodeByte != 6) {
                                    if (decodeByte != 7) {
                                        if (decodeByte != 8) {
                                            if (decodeByte != 9) {
                                                if (decodeByte != 10) {
                                                    if (decodeByte != 11) {
                                                        if (decodeByte == 12) {
                                                            if (dataAvailable() < 20) {
                                                                break;
                                                            }
                                                            mutableSpanStyle.setShadow(decodeShadow());
                                                        } else {
                                                            continue;
                                                        }
                                                    } else if (dataAvailable() < 4) {
                                                        break;
                                                    } else {
                                                        mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                                    }
                                                } else if (dataAvailable() < 8) {
                                                    break;
                                                } else {
                                                    mutableSpanStyle.m7335setBackground8_81llA(m7288decodeColor0d7_KjU());
                                                }
                                            } else if (dataAvailable() < 8) {
                                                break;
                                            } else {
                                                mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                            }
                                        } else if (dataAvailable() < 4) {
                                            break;
                                        } else {
                                            mutableSpanStyle.m7336setBaselineShift_isdbwI(BaselineShift.m7900boximpl(m7286decodeBaselineShifty9eOQZs()));
                                        }
                                    } else if (dataAvailable() < 5) {
                                        break;
                                    } else {
                                        mutableSpanStyle.m7341setLetterSpacingR2X_6o(m7291decodeTextUnitXSAIIZE());
                                    }
                                } else {
                                    mutableSpanStyle.setFontFeatureSettings(decodeString());
                                }
                            } else if (dataAvailable() < 1) {
                                break;
                            } else {
                                mutableSpanStyle.m7340setFontSynthesistDdu0R4(FontSynthesis.m7728boximpl(m7290decodeFontSynthesisGVVA2EU()));
                            }
                        } else if (dataAvailable() < 1) {
                            break;
                        } else {
                            mutableSpanStyle.m7339setFontStylemLjRB2g(FontStyle.m7717boximpl(m7289decodeFontStyle_LCdwA()));
                        }
                    } else if (dataAvailable() < 4) {
                        break;
                    } else {
                        mutableSpanStyle.setFontWeight(decodeFontWeight());
                    }
                } else if (dataAvailable() < 5) {
                    break;
                } else {
                    mutableSpanStyle.m7338setFontSizeR2X_6o(m7291decodeTextUnitXSAIIZE());
                }
            } else if (dataAvailable() < 8) {
                break;
            } else {
                mutableSpanStyle.m7337setColor8_81llA(m7288decodeColor0d7_KjU());
            }
        }
        return mutableSpanStyle.toSpanStyle();
    }

    /* renamed from: decodeColor-0d7_KjU  reason: not valid java name */
    public final long m7288decodeColor0d7_KjU() {
        return AndroidColor_androidKt.fromColorLong(Color.Companion, this.parcel.readLong());
    }

    /* renamed from: decodeTextUnit-XSAIIZE  reason: not valid java name */
    public final long m7291decodeTextUnitXSAIIZE() {
        long m8388getUnspecifiedUIouoOA;
        byte decodeByte = decodeByte();
        if (decodeByte == 1) {
            m8388getUnspecifiedUIouoOA = TextUnitType.Companion.m8387getSpUIouoOA();
        } else if (decodeByte == 2) {
            m8388getUnspecifiedUIouoOA = TextUnitType.Companion.m8386getEmUIouoOA();
        } else {
            m8388getUnspecifiedUIouoOA = TextUnitType.Companion.m8388getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m8382equalsimpl0(m8388getUnspecifiedUIouoOA, TextUnitType.Companion.m8388getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m8365getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m8366TextUnitanM5pPY(decodeFloat(), m8388getUnspecifiedUIouoOA);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* renamed from: decodeFontStyle-_-LCdwA  reason: not valid java name */
    public final int m7289decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontStyle.Companion.m7727getNormal_LCdwA();
        }
        if (decodeByte == 1) {
            return FontStyle.Companion.m7726getItalic_LCdwA();
        }
        return FontStyle.Companion.m7727getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU  reason: not valid java name */
    public final int m7290decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontSynthesis.Companion.m7738getNoneGVVA2EU();
        }
        if (decodeByte == 1) {
            return FontSynthesis.Companion.m7737getAllGVVA2EU();
        }
        if (decodeByte == 3) {
            return FontSynthesis.Companion.m7739getStyleGVVA2EU();
        }
        if (decodeByte == 2) {
            return FontSynthesis.Companion.m7740getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m7738getNoneGVVA2EU();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs  reason: not valid java name */
    private final float m7286decodeBaselineShifty9eOQZs() {
        return BaselineShift.m7901constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        return TextDecoration.Companion.valueOf(decodeInt());
    }

    private final Shadow decodeShadow() {
        long m7288decodeColor0d7_KjU = m7288decodeColor0d7_KjU();
        float decodeFloat = decodeFloat();
        float decodeFloat2 = decodeFloat();
        return new Shadow(m7288decodeColor0d7_KjU, Offset.m5095constructorimpl((Float.floatToRawIntBits(decodeFloat2) & 4294967295L) | (Float.floatToRawIntBits(decodeFloat) << 32)), decodeFloat(), null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* renamed from: decodeULong-s-VKNKU  reason: not valid java name */
    private final long m7287decodeULongsVKNKU() {
        return ULong.m10099constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
