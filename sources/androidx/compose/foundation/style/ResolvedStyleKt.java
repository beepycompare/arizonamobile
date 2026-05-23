package androidx.compose.foundation.style;

import androidx.collection.MutableIntList;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.graphics.shadow.ShadowKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.adjust.sdk.Constants;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: ResolvedStyle.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a!\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\b\u001a(\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a(\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a&\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a9\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0010\u001a(\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a(\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a(\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a0\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\u001a\r\u0010\u0017\u001a\u00020\u0016*\u00020\u0016H\u0082\b\u001a=\u0010\u0014\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\"\u0010\u0014\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0002\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u0014\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001c\u0010$\u001a\u00020%*\u00020%2\u0006\u0010&\u001a\u00020%H\u0080\b¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010$\u001a\u00020)*\u00020)2\u0006\u0010&\u001a\u00020)H\u0080\b¢\u0006\u0004\b*\u0010+\u001a\u001c\u0010$\u001a\u00020,*\u00020,2\u0006\u0010&\u001a\u00020,H\u0080\b¢\u0006\u0004\b-\u0010.\u001a\u001c\u0010$\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bH\u0080\b¢\u0006\u0004\b/\u0010.\u001a\u0019\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0016H\u0080\b\u001a!\u00103\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0016H\u0080\b\u001a\u001d\u00105\u001a\u00020\u0016*\u00020\u00162\u0006\u00104\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u0016H\u0080\b\u001a%\u00107\u001a\u00020\u0016*\u00020\u00162\u0006\u00104\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016H\u0080\b\u001a\u0018\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0016H\u0002\u001a\u0018\u0010<\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0016H\u0002\u001a\u0015\u0010=\u001a\u00020>*\u00020?2\u0006\u00108\u001a\u00020\u0016H\u0082\b\u001a\r\u0010@\u001a\u00020\u0016*\u00020?H\u0082\b\u001a\f\u0010\\\u001a\u00020]*\u00020\u0003H\u0000\u001a\u0010\u0010^\u001a\u00020]2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\"\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\"X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010A\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010D\u001a\u0004\bB\u0010C\"\u000e\u0010E\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010J\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010K\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010L\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010M\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010O\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010P\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Y\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Z\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010[\u001a\u00020\u0016X\u0080T¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"lerpOuterLayout", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroidx/compose/foundation/style/ResolvedStyle;", "b", "t", "", "result", "lerpMaybeNan", "lerpInnerLayout", "lerpDraw", "lerpShadows", "", "lerpArrayShadows", "", "Landroidx/compose/ui/graphics/shadow/Shadow;", "([Landroidx/compose/ui/graphics/shadow/Shadow;[Landroidx/compose/ui/graphics/shadow/Shadow;F)[Landroidx/compose/ui/graphics/shadow/Shadow;", "lerpLayer", "lerpTextDraw", "lerpTextLayout", "lerp", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "floorToNearest100", "Landroidx/compose/ui/graphics/Brush;", "leftBrush", "leftColor", "Landroidx/compose/ui/graphics/Color;", "rightBrush", "rightColor", "lerp-wffgcV4", "(Landroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;JF)Landroidx/compose/ui/graphics/Brush;", "Landroidx/compose/ui/graphics/Shape;", "DefaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "EmptyResolvedStyle", "takeOrElse", "Landroidx/compose/ui/text/style/LineBreak;", "other", "takeOrElse-w1xZEK0", "(II)I", "Landroidx/compose/ui/text/style/BaselineShift;", "takeOrElse-y00tBZM", "(FF)F", "Landroidx/compose/ui/unit/TextUnit;", "takeOrElse-NB67dxo", "(JJ)J", "takeOrElse--OWjLjI", "applyTextEnum", TtmlNode.LEFT, TtmlNode.RIGHT, "setBitsIfNonZero", "mask", "getBits", "shift", "setBits", "value", "updateHashEnter", "hash", "key", "updateHashExit", Constants.PUSH, "", "Landroidx/collection/MutableIntList;", "pop", "TextDefaultsResolvedStyle", "getTextDefaultsResolvedStyle", "()Lkotlin/Unit;", "Lkotlin/Unit;", "FontStyleShift", "TextAlignShift", "TextDirectionShift", "HyphensShift", "FontSynthesisShift", "TextDecorationShift", "FontWeightShift", "FontStyleMask", "TextAlignMask", "TextDirectionMask", "HyphensMask", "FontSynthesisMask", "TextDecorationMask", "FontWeightMask", "InnerLayoutFlag", "DrawFlag", "LayerFlag", "OuterLayoutFlag", "AnimatedFlag", "TextLayoutFlag", "TextDrawFlag", "InheritedFlags", "AnimateGroup", "flagsAsString", "", "resolvedStyleFlagsToString", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResolvedStyleKt {
    public static final int AnimateGroup = 1318433304;
    public static final int AnimatedFlag = 16;
    public static final int DrawFlag = 2;
    private static final int FontStyleMask = 3;
    private static final int FontStyleShift = 0;
    private static final int FontSynthesisMask = 15360;
    private static final int FontSynthesisShift = 10;
    private static final int FontWeightMask = 134086656;
    private static final int FontWeightShift = 17;
    private static final int HyphensMask = 768;
    private static final int HyphensShift = 8;
    public static final int InheritedFlags = 96;
    public static final int InnerLayoutFlag = 1;
    public static final int LayerFlag = 4;
    public static final int OuterLayoutFlag = 8;
    private static final int TextAlignMask = 28;
    private static final int TextAlignShift = 2;
    private static final int TextDecorationMask = 114688;
    private static final int TextDecorationShift = 14;
    private static final Unit TextDefaultsResolvedStyle;
    private static final int TextDirectionMask = 112;
    private static final int TextDirectionShift = 4;
    public static final int TextDrawFlag = 64;
    public static final int TextLayoutFlag = 32;
    private static final SpringSpec<Float> DefaultSpringSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    private static final ResolvedStyle EmptyResolvedStyle = new ResolvedStyle();

    public static final /* synthetic */ SpringSpec access$getDefaultSpringSpec$p() {
        return DefaultSpringSpec;
    }

    public static final /* synthetic */ ResolvedStyle access$getEmptyResolvedStyle$p() {
        return EmptyResolvedStyle;
    }

    public static final /* synthetic */ int access$updateHashEnter(int i, int i2) {
        return updateHashEnter(i, i2);
    }

    public static final /* synthetic */ int access$updateHashExit(int i, int i2) {
        return updateHashExit(i, i2);
    }

    public static final int applyTextEnum(int i, int i2) {
        int i3 = i2 & 3;
        int i4 = i & (-4);
        if (i3 != 0) {
            i = i3;
        }
        int i5 = i | i4;
        int i6 = i2 & 28;
        int i7 = i5 & (-29);
        if (i6 != 0) {
            i5 = i6;
        }
        int i8 = i5 | i7;
        int i9 = i2 & TextDirectionMask;
        int i10 = i8 & (-113);
        if (i9 != 0) {
            i8 = i9;
        }
        int i11 = i8 | i10;
        int i12 = i2 & 768;
        int i13 = i11 & (-769);
        if (i12 != 0) {
            i11 = i12;
        }
        int i14 = i11 | i13;
        int i15 = i2 & FontSynthesisMask;
        int i16 = i14 & (-15361);
        if (i15 != 0) {
            i14 = i15;
        }
        int i17 = i14 | i16;
        int i18 = i2 & FontWeightMask;
        int i19 = (-134086657) & i17;
        if (i18 != 0) {
            i17 = i18;
        }
        return i17 | i19;
    }

    public static final int getBits(int i, int i2, int i3) {
        return (i & i2) >> i3;
    }

    public static final int setBits(int i, int i2, int i3, int i4) {
        return (i & (~i2)) | (i2 & (i4 << i3));
    }

    public static final int setBitsIfNonZero(int i, int i2, int i3) {
        int i4 = i2 & i3;
        int i5 = (~i3) & i;
        if (i4 != 0) {
            i = i4;
        }
        return i | i5;
    }

    /* renamed from: takeOrElse--OWjLjI */
    public static final long m1463takeOrElseOWjLjI(long j, long j2) {
        return j != 16 ? j : j2;
    }

    public static final void lerpOuterLayout(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, ResolvedStyle resolvedStyle3) {
        float externalPaddingStart$foundation = resolvedStyle.getExternalPaddingStart$foundation();
        float externalPaddingStart$foundation2 = resolvedStyle2.getExternalPaddingStart$foundation();
        boolean isNaN = Float.isNaN(externalPaddingStart$foundation);
        boolean isNaN2 = Float.isNaN(externalPaddingStart$foundation2);
        float f2 = 1.0f - f;
        float f3 = (f2 * externalPaddingStart$foundation) + (f * externalPaddingStart$foundation2);
        if (isNaN) {
            externalPaddingStart$foundation = externalPaddingStart$foundation2;
        } else if (!isNaN2) {
            externalPaddingStart$foundation = f3;
        }
        resolvedStyle3.setExternalPaddingStart$foundation(externalPaddingStart$foundation);
        float externalPaddingEnd$foundation = resolvedStyle.getExternalPaddingEnd$foundation();
        float externalPaddingEnd$foundation2 = resolvedStyle2.getExternalPaddingEnd$foundation();
        boolean isNaN3 = Float.isNaN(externalPaddingEnd$foundation);
        boolean isNaN4 = Float.isNaN(externalPaddingEnd$foundation2);
        float f4 = (f2 * externalPaddingEnd$foundation) + (f * externalPaddingEnd$foundation2);
        if (isNaN3) {
            externalPaddingEnd$foundation = externalPaddingEnd$foundation2;
        } else if (!isNaN4) {
            externalPaddingEnd$foundation = f4;
        }
        resolvedStyle3.setExternalPaddingEnd$foundation(externalPaddingEnd$foundation);
        float externalPaddingTop$foundation = resolvedStyle.getExternalPaddingTop$foundation();
        float externalPaddingTop$foundation2 = resolvedStyle2.getExternalPaddingTop$foundation();
        boolean isNaN5 = Float.isNaN(externalPaddingTop$foundation);
        boolean isNaN6 = Float.isNaN(externalPaddingTop$foundation2);
        float f5 = (f2 * externalPaddingTop$foundation) + (f * externalPaddingTop$foundation2);
        if (isNaN5) {
            externalPaddingTop$foundation = externalPaddingTop$foundation2;
        } else if (!isNaN6) {
            externalPaddingTop$foundation = f5;
        }
        resolvedStyle3.setExternalPaddingTop$foundation(externalPaddingTop$foundation);
        float externalPaddingBottom$foundation = resolvedStyle.getExternalPaddingBottom$foundation();
        float externalPaddingBottom$foundation2 = resolvedStyle2.getExternalPaddingBottom$foundation();
        boolean isNaN7 = Float.isNaN(externalPaddingBottom$foundation);
        boolean isNaN8 = Float.isNaN(externalPaddingBottom$foundation2);
        float f6 = (f2 * externalPaddingBottom$foundation) + (f * externalPaddingBottom$foundation2);
        if (isNaN7) {
            externalPaddingBottom$foundation = externalPaddingBottom$foundation2;
        } else if (!isNaN8) {
            externalPaddingBottom$foundation = f6;
        }
        resolvedStyle3.setExternalPaddingBottom$foundation(externalPaddingBottom$foundation);
        float left$foundation = resolvedStyle.getLeft$foundation();
        float left$foundation2 = resolvedStyle2.getLeft$foundation();
        boolean isNaN9 = Float.isNaN(left$foundation);
        boolean isNaN10 = Float.isNaN(left$foundation2);
        float f7 = (f2 * left$foundation) + (f * left$foundation2);
        if (isNaN9) {
            left$foundation = left$foundation2;
        } else if (!isNaN10) {
            left$foundation = f7;
        }
        resolvedStyle3.setLeft$foundation(left$foundation);
        float top$foundation = resolvedStyle.getTop$foundation();
        float top$foundation2 = resolvedStyle2.getTop$foundation();
        boolean isNaN11 = Float.isNaN(top$foundation);
        boolean isNaN12 = Float.isNaN(top$foundation2);
        float f8 = (f2 * top$foundation) + (f * top$foundation2);
        if (isNaN11) {
            top$foundation = top$foundation2;
        } else if (!isNaN12) {
            top$foundation = f8;
        }
        resolvedStyle3.setTop$foundation(top$foundation);
        float right$foundation = resolvedStyle.getRight$foundation();
        float right$foundation2 = resolvedStyle2.getRight$foundation();
        boolean isNaN13 = Float.isNaN(right$foundation);
        boolean isNaN14 = Float.isNaN(right$foundation2);
        float f9 = (f2 * right$foundation) + (f * right$foundation2);
        if (isNaN13) {
            right$foundation = right$foundation2;
        } else if (!isNaN14) {
            right$foundation = f9;
        }
        resolvedStyle3.setRight$foundation(right$foundation);
        float bottom$foundation = resolvedStyle.getBottom$foundation();
        float bottom$foundation2 = resolvedStyle2.getBottom$foundation();
        boolean isNaN15 = Float.isNaN(bottom$foundation);
        boolean isNaN16 = Float.isNaN(bottom$foundation2);
        float f10 = (f2 * bottom$foundation) + (f * bottom$foundation2);
        if (isNaN15) {
            bottom$foundation = bottom$foundation2;
        } else if (!isNaN16) {
            bottom$foundation = f10;
        }
        resolvedStyle3.setBottom$foundation(bottom$foundation);
        float width$foundation = resolvedStyle.getWidth$foundation();
        float width$foundation2 = resolvedStyle2.getWidth$foundation();
        boolean isNaN17 = Float.isNaN(width$foundation);
        boolean isNaN18 = Float.isNaN(width$foundation2);
        float f11 = (f2 * width$foundation) + (f * width$foundation2);
        if (isNaN17) {
            width$foundation = width$foundation2;
        } else if (!isNaN18) {
            width$foundation = f11;
        }
        resolvedStyle3.setWidth$foundation(width$foundation);
        float height$foundation = resolvedStyle.getHeight$foundation();
        float height$foundation2 = resolvedStyle2.getHeight$foundation();
        boolean isNaN19 = Float.isNaN(height$foundation);
        boolean isNaN20 = Float.isNaN(height$foundation2);
        float f12 = (f2 * height$foundation) + (f * height$foundation2);
        if (isNaN19) {
            height$foundation = height$foundation2;
        } else if (!isNaN20) {
            height$foundation = f12;
        }
        resolvedStyle3.setHeight$foundation(height$foundation);
        float widthFraction$foundation = resolvedStyle.getWidthFraction$foundation();
        float widthFraction$foundation2 = resolvedStyle2.getWidthFraction$foundation();
        boolean isNaN21 = Float.isNaN(widthFraction$foundation);
        boolean isNaN22 = Float.isNaN(widthFraction$foundation2);
        float f13 = (f2 * widthFraction$foundation) + (f * widthFraction$foundation2);
        if (isNaN21) {
            widthFraction$foundation = widthFraction$foundation2;
        } else if (!isNaN22) {
            widthFraction$foundation = f13;
        }
        resolvedStyle3.setWidthFraction$foundation(widthFraction$foundation);
        float heightFraction$foundation = resolvedStyle.getHeightFraction$foundation();
        float heightFraction$foundation2 = resolvedStyle2.getHeightFraction$foundation();
        boolean isNaN23 = Float.isNaN(heightFraction$foundation);
        boolean isNaN24 = Float.isNaN(heightFraction$foundation2);
        float f14 = (f2 * heightFraction$foundation) + (f * heightFraction$foundation2);
        if (isNaN23) {
            heightFraction$foundation = heightFraction$foundation2;
        } else if (!isNaN24) {
            heightFraction$foundation = f14;
        }
        resolvedStyle3.setHeightFraction$foundation(heightFraction$foundation);
        float minWidth$foundation = resolvedStyle.getMinWidth$foundation();
        float minWidth$foundation2 = resolvedStyle2.getMinWidth$foundation();
        boolean isNaN25 = Float.isNaN(minWidth$foundation);
        boolean isNaN26 = Float.isNaN(minWidth$foundation2);
        float f15 = (f2 * minWidth$foundation) + (f * minWidth$foundation2);
        if (isNaN25) {
            minWidth$foundation = minWidth$foundation2;
        } else if (!isNaN26) {
            minWidth$foundation = f15;
        }
        resolvedStyle3.setMinWidth$foundation(minWidth$foundation);
        float maxWidth$foundation = resolvedStyle.getMaxWidth$foundation();
        float maxWidth$foundation2 = resolvedStyle2.getMaxWidth$foundation();
        boolean isNaN27 = Float.isNaN(maxWidth$foundation);
        boolean isNaN28 = Float.isNaN(maxWidth$foundation2);
        float f16 = (f2 * maxWidth$foundation) + (f * maxWidth$foundation2);
        if (isNaN27) {
            maxWidth$foundation = maxWidth$foundation2;
        } else if (!isNaN28) {
            maxWidth$foundation = f16;
        }
        resolvedStyle3.setMaxWidth$foundation(maxWidth$foundation);
        float minHeight$foundation = resolvedStyle.getMinHeight$foundation();
        float minHeight$foundation2 = resolvedStyle2.getMinHeight$foundation();
        boolean isNaN29 = Float.isNaN(minHeight$foundation);
        boolean isNaN30 = Float.isNaN(minHeight$foundation2);
        float f17 = (f2 * minHeight$foundation) + (f * minHeight$foundation2);
        if (isNaN29) {
            minHeight$foundation = minHeight$foundation2;
        } else if (!isNaN30) {
            minHeight$foundation = f17;
        }
        resolvedStyle3.setMinHeight$foundation(minHeight$foundation);
        float maxHeight$foundation = resolvedStyle.getMaxHeight$foundation();
        float maxHeight$foundation2 = resolvedStyle2.getMaxHeight$foundation();
        boolean isNaN31 = Float.isNaN(maxHeight$foundation);
        boolean isNaN32 = Float.isNaN(maxHeight$foundation2);
        float f18 = (f2 * maxHeight$foundation) + (f * maxHeight$foundation2);
        if (isNaN31) {
            maxHeight$foundation = maxHeight$foundation2;
        } else if (!isNaN32) {
            maxHeight$foundation = f18;
        }
        resolvedStyle3.setMaxHeight$foundation(maxHeight$foundation);
    }

    public static final float lerpMaybeNan(float f, float f2, float f3) {
        return Float.isNaN(f) ? f2 : Float.isNaN(f2) ? f : ((1.0f - f3) * f) + (f3 * f2);
    }

    public static final void lerpInnerLayout(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, ResolvedStyle resolvedStyle3) {
        resolvedStyle3.setContentPaddingStart$foundation(MathHelpersKt.lerp(resolvedStyle.getContentPaddingStart$foundation(), resolvedStyle2.getContentPaddingStart$foundation(), f));
        resolvedStyle3.setContentPaddingEnd$foundation(MathHelpersKt.lerp(resolvedStyle.getContentPaddingEnd$foundation(), resolvedStyle2.getContentPaddingEnd$foundation(), f));
        resolvedStyle3.setContentPaddingTop$foundation(MathHelpersKt.lerp(resolvedStyle.getContentPaddingTop$foundation(), resolvedStyle2.getContentPaddingTop$foundation(), f));
        resolvedStyle3.setContentPaddingBottom$foundation(MathHelpersKt.lerp(resolvedStyle.getContentPaddingBottom$foundation(), resolvedStyle2.getContentPaddingBottom$foundation(), f));
    }

    public static final void lerpDraw(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, ResolvedStyle resolvedStyle3) {
        resolvedStyle3.setBorderWidth$foundation(MathHelpersKt.lerp(resolvedStyle.getBorderWidth$foundation(), resolvedStyle2.getBorderWidth$foundation(), f));
        resolvedStyle3.m1445setBorderColor8_81llA$foundation(ColorKt.m5399lerpjxsXWHM(resolvedStyle.m1415getBorderColor0d7_KjU$foundation(), resolvedStyle2.m1415getBorderColor0d7_KjU$foundation(), f));
        resolvedStyle3.setBorderBrush$foundation(m1462lerpwffgcV4(resolvedStyle.getBorderBrush$foundation(), resolvedStyle.m1415getBorderColor0d7_KjU$foundation(), resolvedStyle2.getBorderBrush$foundation(), resolvedStyle2.m1415getBorderColor0d7_KjU$foundation(), f));
        resolvedStyle3.m1443setBackgroundColor8_81llA$foundation(ColorKt.m5399lerpjxsXWHM(resolvedStyle.m1413getBackgroundColor0d7_KjU$foundation(), resolvedStyle2.m1413getBackgroundColor0d7_KjU$foundation(), f));
        resolvedStyle3.setBackgroundBrush$foundation(m1462lerpwffgcV4(resolvedStyle.getBackgroundBrush$foundation(), resolvedStyle.m1413getBackgroundColor0d7_KjU$foundation(), resolvedStyle2.getBackgroundBrush$foundation(), resolvedStyle2.m1413getBackgroundColor0d7_KjU$foundation(), f));
        resolvedStyle3.setForegroundBrush$foundation(m1462lerpwffgcV4(resolvedStyle.getForegroundBrush$foundation(), Color.Companion.m5384getUnspecified0d7_KjU(), resolvedStyle2.getForegroundBrush$foundation(), Color.Companion.m5384getUnspecified0d7_KjU(), f));
        resolvedStyle3.setInnerShadow$foundation(lerpShadows(resolvedStyle.getInnerShadow$foundation(), resolvedStyle2.getInnerShadow$foundation(), f));
        resolvedStyle3.setDropShadow$foundation(lerpShadows(resolvedStyle.getDropShadow$foundation(), resolvedStyle2.getDropShadow$foundation(), f));
    }

    public static final Object lerpShadows(Object obj, Object obj2, float f) {
        Shadow[] shadowArr;
        Shadow[] shadowArr2;
        if (obj == null && obj2 == null) {
            return null;
        }
        boolean z = obj instanceof Object[];
        boolean z2 = obj2 instanceof Object[];
        if (!z && !z2) {
            return ShadowKt.lerp(obj instanceof Shadow ? (Shadow) obj : null, obj2 instanceof Shadow ? (Shadow) obj2 : null, f);
        }
        if (z) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<androidx.compose.ui.graphics.shadow.Shadow>");
            shadowArr = (Shadow[]) obj;
        } else {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.graphics.shadow.Shadow");
            shadowArr = new Shadow[]{obj};
        }
        if (z2) {
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<androidx.compose.ui.graphics.shadow.Shadow>");
            shadowArr2 = (Shadow[]) obj2;
        } else {
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.graphics.shadow.Shadow");
            shadowArr2 = new Shadow[]{obj2};
        }
        return lerpArrayShadows(shadowArr, shadowArr2, f);
    }

    public static final Shadow[] lerpArrayShadows(Shadow[] shadowArr, Shadow[] shadowArr2, float f) {
        int max = Math.max(shadowArr.length, shadowArr2.length);
        Shadow[] shadowArr3 = new Shadow[max];
        for (int i = 0; i < max; i++) {
            shadowArr3[i] = null;
        }
        for (int i2 = 0; i2 < max; i2++) {
            shadowArr3[i2] = ShadowKt.lerp((Shadow) ArraysKt.getOrNull(shadowArr, i2), (Shadow) ArraysKt.getOrNull(shadowArr2, i2), f);
        }
        return shadowArr3;
    }

    public static final void lerpLayer(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, ResolvedStyle resolvedStyle3) {
        resolvedStyle3.setAlpha$foundation(MathHelpersKt.lerp(resolvedStyle.getAlpha$foundation(), resolvedStyle2.getAlpha$foundation(), f));
        resolvedStyle3.setScaleX$foundation(MathHelpersKt.lerp(resolvedStyle.getScaleX$foundation(), resolvedStyle2.getScaleX$foundation(), f));
        resolvedStyle3.setScaleY$foundation(MathHelpersKt.lerp(resolvedStyle.getScaleY$foundation(), resolvedStyle2.getScaleY$foundation(), f));
        resolvedStyle3.setTranslationX$foundation(MathHelpersKt.lerp(resolvedStyle.getTranslationX$foundation(), resolvedStyle2.getTranslationX$foundation(), f));
        resolvedStyle3.setTranslationY$foundation(MathHelpersKt.lerp(resolvedStyle.getTranslationY$foundation(), resolvedStyle2.getTranslationY$foundation(), f));
        resolvedStyle3.setRotationX$foundation(MathHelpersKt.lerp(resolvedStyle.getRotationX$foundation(), resolvedStyle2.getRotationX$foundation(), f));
        resolvedStyle3.setRotationY$foundation(MathHelpersKt.lerp(resolvedStyle.getRotationY$foundation(), resolvedStyle2.getRotationY$foundation(), f));
        resolvedStyle3.setRotationZ$foundation(MathHelpersKt.lerp(resolvedStyle.getRotationZ$foundation(), resolvedStyle2.getRotationZ$foundation(), f));
        resolvedStyle3.m1452setTransformOrigin__ExYCQ$foundation(TransformOriginKt.TransformOrigin(MathHelpersKt.lerp(TransformOrigin.m5756getPivotFractionXimpl(resolvedStyle.m1427getTransformOriginSzJe1aQ$foundation()), TransformOrigin.m5756getPivotFractionXimpl(resolvedStyle2.m1427getTransformOriginSzJe1aQ$foundation()), f), MathHelpersKt.lerp(TransformOrigin.m5757getPivotFractionYimpl(resolvedStyle.m1427getTransformOriginSzJe1aQ$foundation()), TransformOrigin.m5757getPivotFractionYimpl(resolvedStyle2.m1427getTransformOriginSzJe1aQ$foundation()), f)));
        resolvedStyle3.setZIndex$foundation(MathHelpersKt.lerp(resolvedStyle.getZIndex$foundation(), resolvedStyle2.getZIndex$foundation(), f));
        resolvedStyle3.setShape$foundation(lerp(resolvedStyle.getShape$foundation(), resolvedStyle2.getShape$foundation(), f));
        resolvedStyle3.setClip$foundation(f < 0.5f ? resolvedStyle.getClip$foundation() : resolvedStyle2.getClip$foundation());
    }

    public static final void lerpTextDraw(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, ResolvedStyle resolvedStyle3) {
        resolvedStyle3.m1446setContentColor8_81llA$foundation(ColorKt.m5399lerpjxsXWHM(resolvedStyle.m1416getContentColor0d7_KjU$foundation(), resolvedStyle2.m1416getContentColor0d7_KjU$foundation(), f));
        resolvedStyle3.setContentBrush$foundation(m1462lerpwffgcV4(resolvedStyle.getContentBrush$foundation(), resolvedStyle.m1416getContentColor0d7_KjU$foundation(), resolvedStyle2.getContentBrush$foundation(), resolvedStyle2.m1416getContentColor0d7_KjU$foundation(), f));
    }

    public static final void lerpTextLayout(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, ResolvedStyle resolvedStyle3) {
        if (!(TextUnit.m8352getRawTypeimpl(resolvedStyle.m1417getFontSizeXSAIIZE$foundation()) == 0)) {
            if (!(TextUnit.m8352getRawTypeimpl(resolvedStyle2.m1417getFontSizeXSAIIZE$foundation()) == 0)) {
                resolvedStyle3.m1447setFontSizeR2X_6o$foundation(TextUnitKt.m8374lerpC3pnCVY(resolvedStyle.m1417getFontSizeXSAIIZE$foundation(), resolvedStyle2.m1417getFontSizeXSAIIZE$foundation(), f));
            }
        }
        if (!(TextUnit.m8352getRawTypeimpl(resolvedStyle.m1424getLineHeightXSAIIZE$foundation()) == 0)) {
            if (!(TextUnit.m8352getRawTypeimpl(resolvedStyle2.m1424getLineHeightXSAIIZE$foundation()) == 0)) {
                resolvedStyle3.m1451setLineHeightR2X_6o$foundation(TextUnitKt.m8374lerpC3pnCVY(resolvedStyle.m1424getLineHeightXSAIIZE$foundation(), resolvedStyle2.m1424getLineHeightXSAIIZE$foundation(), f));
            }
        }
        if (!(TextUnit.m8352getRawTypeimpl(resolvedStyle.m1422getLetterSpacingXSAIIZE$foundation()) == 0)) {
            if (!(TextUnit.m8352getRawTypeimpl(resolvedStyle2.m1422getLetterSpacingXSAIIZE$foundation()) == 0)) {
                resolvedStyle3.m1449setLetterSpacingR2X_6o$foundation(TextUnitKt.m8374lerpC3pnCVY(resolvedStyle.m1422getLetterSpacingXSAIIZE$foundation(), resolvedStyle2.m1422getLetterSpacingXSAIIZE$foundation(), f));
            }
        }
        int i = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
        resolvedStyle3.setFontFamily$foundation(i < 0 ? resolvedStyle.getFontFamily$foundation() : resolvedStyle2.getFontFamily$foundation());
        resolvedStyle3.setTextIndent$foundation(i < 0 ? resolvedStyle.getTextIndent$foundation() : resolvedStyle2.getTextIndent$foundation());
        resolvedStyle3.m1444setBaselineShift4Dl_Bck$foundation(i < 0 ? resolvedStyle.m1414getBaselineShifty9eOQZs$foundation() : resolvedStyle2.m1414getBaselineShifty9eOQZs$foundation());
        resolvedStyle3.m1450setLineBreakCZqVlQI$foundation(i < 0 ? resolvedStyle.m1423getLineBreakrAG3T2k$foundation() : resolvedStyle2.m1423getLineBreakrAG3T2k$foundation());
        resolvedStyle3.setTextEnums$foundation(i < 0 ? resolvedStyle.getTextEnums$foundation() : resolvedStyle2.getTextEnums$foundation());
        int textEnums$foundation = (resolvedStyle.getTextEnums$foundation() & FontWeightMask) >> 17;
        int textEnums$foundation2 = (resolvedStyle2.getTextEnums$foundation() & FontWeightMask) >> 17;
        if (textEnums$foundation <= 0 || textEnums$foundation2 <= 0) {
            return;
        }
        resolvedStyle3.setTextEnums$foundation(((((MathHelpersKt.lerp(textEnums$foundation, textEnums$foundation2, f) / 100) * 100) << 17) & FontWeightMask) | (resolvedStyle3.getTextEnums$foundation() & (-134086657)));
    }

    public static final void lerp(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, float f, int i, ResolvedStyle resolvedStyle3) {
        int i2 = resolvedStyle.flags | resolvedStyle2.flags;
        resolvedStyle3.flags = i2;
        int i3 = i & i2;
        if ((i3 & 8) != 0) {
            lerpOuterLayout(resolvedStyle, resolvedStyle2, f, resolvedStyle3);
        }
        if ((i3 & 1) != 0) {
            lerpInnerLayout(resolvedStyle, resolvedStyle2, f, resolvedStyle3);
        }
        if ((i3 & 2) != 0) {
            lerpDraw(resolvedStyle, resolvedStyle2, f, resolvedStyle3);
        }
        if ((i3 & 4) != 0) {
            lerpLayer(resolvedStyle, resolvedStyle2, f, resolvedStyle3);
        }
        if ((i3 & 64) != 0) {
            lerpTextDraw(resolvedStyle, resolvedStyle2, f, resolvedStyle3);
        }
        if ((i3 & 32) != 0) {
            lerpTextLayout(resolvedStyle, resolvedStyle2, f, resolvedStyle3);
        }
    }

    private static final int floorToNearest100(int i) {
        return (i / 100) * 100;
    }

    /* renamed from: lerp-wffgcV4 */
    private static final Brush m1462lerpwffgcV4(Brush brush, long j, Brush brush2, long j2, float f) {
        if (brush == null && brush2 == null) {
            return null;
        }
        if (brush == null) {
            brush = new SolidColor(j, null);
        } else if (brush2 == null) {
            brush2 = new SolidColor(j2, null);
        }
        Object lerp = Interpolatable.Companion.lerp(brush, brush2, f);
        if (lerp instanceof Brush) {
            return (Brush) lerp;
        }
        return null;
    }

    private static final Brush lerp(Brush brush, Brush brush2, float f) {
        Object lerp = Interpolatable.Companion.lerp(brush, brush2, f);
        if (lerp instanceof Brush) {
            return (Brush) lerp;
        }
        return null;
    }

    private static final Shape lerp(Shape shape, Shape shape2, float f) {
        Object lerp = Interpolatable.Companion.lerp(shape, shape2, f);
        Shape shape3 = lerp instanceof Shape ? (Shape) lerp : null;
        return shape3 == null ? RectangleShapeKt.getRectangleShape() : shape3;
    }

    static {
        StyleScopeKt.apply(new ResolvedStyle(), new Style() { // from class: androidx.compose.foundation.style.ResolvedStyleKt$$ExternalSyntheticLambda0
            @Override // androidx.compose.foundation.style.Style
            public final void applyStyle(StyleScope styleScope) {
                ResolvedStyleKt.TextDefaultsResolvedStyle$lambda$0(styleScope);
            }
        });
        TextDefaultsResolvedStyle = Unit.INSTANCE;
    }

    /* renamed from: takeOrElse-y00tBZM */
    public static final float m1466takeOrElsey00tBZM(float f, float f2) {
        return BaselineShift.m7903equalsimpl0(f, BaselineShift.Companion.m7914getUnspecifiedy9eOQZs()) ? f : f2;
    }

    public static final int updateHashEnter(int i, int i2) {
        return Integer.rotateLeft(i, 3) ^ i2;
    }

    public static final int updateHashExit(int i, int i2) {
        return Integer.rotateRight(i ^ i2, 3);
    }

    private static final boolean push(MutableIntList mutableIntList, int i) {
        return mutableIntList.add(i);
    }

    private static final int pop(MutableIntList mutableIntList) {
        return mutableIntList.removeAt(mutableIntList._size - 1);
    }

    public static final Unit getTextDefaultsResolvedStyle() {
        return TextDefaultsResolvedStyle;
    }

    public static final void TextDefaultsResolvedStyle$lambda$0(StyleScope styleScope) {
        styleScope.mo1409fontSizeR2X_6o(TextUnitKt.getSp(14));
        styleScope.mo1431letterSpacingR2X_6o(TextUnitKt.getSp(0));
        styleScope.mo1390contentColor8_81llA(Color.Companion.m5374getBlack0d7_KjU());
        styleScope.fontWeight(FontWeight.Companion.getNormal());
        styleScope.mo1410fontStylenzbMABs(FontStyle.Companion.m7727getNormal_LCdwA());
        styleScope.mo1411fontSynthesis6p3vJLY(FontSynthesis.Companion.m7737getAllGVVA2EU());
        styleScope.fontFamily(FontFamily.Companion.getDefault());
        styleScope.mo1384baselineShift4Dl_Bck(BaselineShift.Companion.m7911getNoney9eOQZs());
        styleScope.textDecoration(TextDecoration.Companion.getNone());
    }

    public static final String flagsAsString(ResolvedStyle resolvedStyle) {
        return resolvedStyleFlagsToString(resolvedStyle.flags);
    }

    public static final String resolvedStyleFlagsToString(int i) {
        StringBuilder sb = new StringBuilder();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if ((i & 1) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "InnerLayoutFlag");
        }
        if ((i & 2) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "DrawFlag");
        }
        if ((i & 4) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "LayerFlag");
        }
        if ((i & 8) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "OuterLayoutFlag");
        }
        if ((i & 16) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "AnimatedFlag");
        }
        if ((i & 32) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "TextLayoutFlag");
        }
        if ((i & 64) != 0) {
            resolvedStyleFlagsToString$lambda$0$emit(booleanRef, sb, "TextDrawFlag");
        }
        return sb.toString();
    }

    private static final void resolvedStyleFlagsToString$lambda$0$emit(Ref.BooleanRef booleanRef, StringBuilder sb, String str) {
        if (!booleanRef.element) {
            sb.append(", ");
        }
        booleanRef.element = false;
        sb.append(str);
    }

    /* renamed from: takeOrElse-w1xZEK0 */
    public static final int m1465takeOrElsew1xZEK0(int i, int i2) {
        return !LineBreak.m7942equalsimpl0(i, LineBreak.Companion.m7956getUnspecifiedrAG3T2k()) ? i : i2;
    }

    /* renamed from: takeOrElse-NB67dxo */
    public static final long m1464takeOrElseNB67dxo(long j, long j2) {
        return !((TextUnit.m8352getRawTypeimpl(j) > 0L ? 1 : (TextUnit.m8352getRawTypeimpl(j) == 0L ? 0 : -1)) == 0) ? j : j2;
    }
}
