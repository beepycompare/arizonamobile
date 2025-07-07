package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u001a \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0015\u001a\"\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a*\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a*\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001d\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\fH\u0001¢\u0006\u0002\u00107\u001a%\u00108\u001a\u00020\u0006*\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:H\u0086\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u001f\u0010=\u001a\u00020\u0006*\u00020\u00072\u0006\u0010>\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u0010=\u001a\u00020\u0006*\u00020\f2\u0006\u0010>\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010#\u001a\u001f\u0010=\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010>\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\r\u001a\u0004\b\n\u0010\u000e\"\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\u001f\u0010\u0012\u001a\u00020\u0013*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u001f\u0010\u0018\u001a\u00020\u0013*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000e\"\u001e\u0010\u001b\u001a\u00020\u0006*\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "em", "Landroidx/compose/ui/unit/TextUnit;", "", "getEm$annotations", "(D)V", "getEm", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "sp", "getSp$annotations", "getSp", "TextUnit", "value", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "checkArithmetic", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", TtmlNode.START, "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "pack", "unitType", "v", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static /* synthetic */ void getSp$annotations(double d) {
    }

    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* renamed from: isSpecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m6895isSpecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: isUnspecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m6897isUnspecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: TextUnit-anM5pPY  reason: not valid java name */
    public static final long m6890TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* renamed from: isUnspecified--R2X_6o  reason: not valid java name */
    public static final boolean m6896isUnspecifiedR2X_6o(long j) {
        return TextUnit.m6876getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, i);
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m6901timesmpE4wyQ(float f, long j) {
        m6891checkArithmeticR2X_6o(j);
        return pack(TextUnit.m6876getRawTypeimpl(j), f * TextUnit.m6878getValueimpl(j));
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m6900timesmpE4wyQ(double d, long j) {
        m6891checkArithmeticR2X_6o(j);
        return pack(TextUnit.m6876getRawTypeimpl(j), ((float) d) * TextUnit.m6878getValueimpl(j));
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m6902timesmpE4wyQ(int i, long j) {
        m6891checkArithmeticR2X_6o(j);
        return pack(TextUnit.m6876getRawTypeimpl(j), i * TextUnit.m6878getValueimpl(j));
    }

    public static final long pack(long j, float f) {
        return TextUnit.m6870constructorimpl(j | (Float.floatToRawIntBits(f) & 4294967295L));
    }

    /* renamed from: lerp-C3pnCVY  reason: not valid java name */
    public static final long m6898lerpC3pnCVY(long j, long j2, float f) {
        m6892checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m6876getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m6878getValueimpl(j), TextUnit.m6878getValueimpl(j2), f));
    }

    /* renamed from: isSpecified--R2X_6o  reason: not valid java name */
    public static final boolean m6894isSpecifiedR2X_6o(long j) {
        return !(TextUnit.m6876getRawTypeimpl(j) == 0);
    }

    /* renamed from: takeOrElse-eAf_CNQ  reason: not valid java name */
    public static final long m6899takeOrElseeAf_CNQ(long j, Function0<TextUnit> function0) {
        return !((TextUnit.m6876getRawTypeimpl(j) > 0L ? 1 : (TextUnit.m6876getRawTypeimpl(j) == 0L ? 0 : -1)) == 0) ? j : function0.invoke().m6887unboximpl();
    }

    /* renamed from: checkArithmetic--R2X_6o  reason: not valid java name */
    public static final void m6891checkArithmeticR2X_6o(long j) {
        if (TextUnit.m6876getRawTypeimpl(j) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* renamed from: checkArithmetic-NB67dxo  reason: not valid java name */
    public static final void m6892checkArithmeticNB67dxo(long j, long j2) {
        if (!((TextUnit.m6876getRawTypeimpl(j) == 0 || TextUnit.m6876getRawTypeimpl(j2) == 0) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m6906equalsimpl0(TextUnit.m6877getTypeUIouoOA(j), TextUnit.m6877getTypeUIouoOA(j2))) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m6908toStringimpl(TextUnit.m6877getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m6908toStringimpl(TextUnit.m6877getTypeUIouoOA(j2))));
    }

    /* renamed from: checkArithmetic-vU-0ePk  reason: not valid java name */
    public static final void m6893checkArithmeticvU0ePk(long j, long j2, long j3) {
        boolean z = true;
        if (!((TextUnit.m6876getRawTypeimpl(j) == 0 || TextUnit.m6876getRawTypeimpl(j2) == 0 || TextUnit.m6876getRawTypeimpl(j3) == 0) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (!TextUnitType.m6906equalsimpl0(TextUnit.m6877getTypeUIouoOA(j), TextUnit.m6877getTypeUIouoOA(j2)) || !TextUnitType.m6906equalsimpl0(TextUnit.m6877getTypeUIouoOA(j2), TextUnit.m6877getTypeUIouoOA(j3))) {
            z = false;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m6908toStringimpl(TextUnit.m6877getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m6908toStringimpl(TextUnit.m6877getTypeUIouoOA(j2))));
    }
}
