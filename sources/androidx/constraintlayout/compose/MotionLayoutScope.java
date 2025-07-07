package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* compiled from: MotionLayout.kt */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u000223B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ#\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ%\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\rJ%\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0011J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J%\u0010 \u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\rJ\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u001f\u0010#\u001a\f\u0012\b\u0012\u00060%R\u00020\u00000$2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010&J\u001c\u0010#\u001a\u00060%R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0007JJ\u0010(\u001a\u00020)*\u00020)2\u0006\u0010*\u001a\u00020\u000126\u0010+\u001a2\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b\u000b\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b\u000b\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope;", "", "measurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/constraintlayout/compose/MotionMeasurer;Landroidx/compose/runtime/MutableFloatState;)V", "customColor", "Landroidx/compose/ui/graphics/Color;", "id", "", "name", "customColor-WaAFU9c", "(Ljava/lang/String;Ljava/lang/String;)J", "customDistance", "Landroidx/compose/ui/unit/Dp;", "customDistance-chRvn1I", "(Ljava/lang/String;Ljava/lang/String;)F", "customFloat", "", "customFontSize", "Landroidx/compose/ui/unit/TextUnit;", "customFontSize-5XXgJZs", "customInt", "", "customProperties", "Landroidx/constraintlayout/compose/MotionLayoutScope$CustomProperties;", "motionColor", "motionColor-WaAFU9c", "motionDistance", "motionDistance-chRvn1I", "motionFloat", "motionFontSize", "motionFontSize-5XXgJZs", "motionInt", "motionProperties", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tag", "onStartEndBoundsChanged", "Landroidx/compose/ui/Modifier;", "layoutId", "onBoundsChanged", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "startBounds", "endBounds", "", "CustomProperties", "MotionProperties", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionLayoutScope {
    public static final int $stable = 8;
    private final MotionMeasurer measurer;
    private final MutableFloatState motionProgress;

    public MotionLayoutScope(MotionMeasurer motionMeasurer, MutableFloatState mutableFloatState) {
        this.measurer = motionMeasurer;
        this.motionProgress = mutableFloatState;
    }

    /* compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0003J\u001b\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope$CustomProperties;", "", "id", "", "(Landroidx/constraintlayout/compose/MotionLayoutScope;Ljava/lang/String;)V", "color", "Landroidx/compose/ui/graphics/Color;", "name", "color-vNxB06k", "(Ljava/lang/String;)J", "distance", "Landroidx/compose/ui/unit/Dp;", "distance-u2uoSUM", "(Ljava/lang/String;)F", TypedValues.Custom.S_FLOAT, "", TtmlNode.ATTR_TTS_FONT_SIZE, "Landroidx/compose/ui/unit/TextUnit;", "fontSize-kPz2Gy4", "int", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class CustomProperties {
        private final String id;

        public CustomProperties(String str) {
            this.id = str;
        }

        /* renamed from: color-vNxB06k  reason: not valid java name */
        public final long m7110colorvNxB06k(String str) {
            return MotionLayoutScope.this.measurer.m7125getCustomColorXeAY9LY(this.id, str, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* renamed from: float  reason: not valid java name */
        public final float m7112float(String str) {
            return MotionLayoutScope.this.measurer.getCustomFloat(this.id, str, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* renamed from: int  reason: not valid java name */
        public final int m7114int(String str) {
            return (int) MotionLayoutScope.this.measurer.getCustomFloat(this.id, str, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* renamed from: distance-u2uoSUM  reason: not valid java name */
        public final float m7111distanceu2uoSUM(String str) {
            return Dp.m6684constructorimpl(MotionLayoutScope.this.measurer.getCustomFloat(this.id, str, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }

        /* renamed from: fontSize-kPz2Gy4  reason: not valid java name */
        public final long m7113fontSizekPz2Gy4(String str) {
            return TextUnitKt.getSp(MotionLayoutScope.this.measurer.getCustomFloat(this.id, str, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }
    }

    /* compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0003J\u001b\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "", "id", "", "tag", "(Landroidx/constraintlayout/compose/MotionLayoutScope;Ljava/lang/String;Ljava/lang/String;)V", "myId", "myTag", "color", "Landroidx/compose/ui/graphics/Color;", "name", "color-vNxB06k", "(Ljava/lang/String;)J", "distance", "Landroidx/compose/ui/unit/Dp;", "distance-u2uoSUM", "(Ljava/lang/String;)F", TypedValues.Custom.S_FLOAT, "", TtmlNode.ATTR_TTS_FONT_SIZE, "Landroidx/compose/ui/unit/TextUnit;", "fontSize-kPz2Gy4", "int", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public final class MotionProperties {
        private String myId;
        private String myTag;

        public MotionProperties(String str, String str2) {
            this.myId = str;
            this.myTag = str2;
        }

        public final String id() {
            return this.myId;
        }

        public final String tag() {
            return this.myTag;
        }

        /* renamed from: color-vNxB06k  reason: not valid java name */
        public final long m7115colorvNxB06k(String str) {
            return MotionLayoutScope.this.measurer.m7125getCustomColorXeAY9LY(this.myId, str, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* renamed from: float  reason: not valid java name */
        public final float m7117float(String str) {
            return MotionLayoutScope.this.measurer.getCustomFloat(this.myId, str, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* renamed from: int  reason: not valid java name */
        public final int m7119int(String str) {
            return (int) MotionLayoutScope.this.measurer.getCustomFloat(this.myId, str, MotionLayoutScope.this.motionProgress.getFloatValue());
        }

        /* renamed from: distance-u2uoSUM  reason: not valid java name */
        public final float m7116distanceu2uoSUM(String str) {
            return Dp.m6684constructorimpl(MotionLayoutScope.this.measurer.getCustomFloat(this.myId, str, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }

        /* renamed from: fontSize-kPz2Gy4  reason: not valid java name */
        public final long m7118fontSizekPz2Gy4(String str) {
            return TextUnitKt.getSp(MotionLayoutScope.this.measurer.getCustomFloat(this.myId, str, MotionLayoutScope.this.motionProgress.getFloatValue()));
        }
    }

    @Deprecated(message = "Unnecessary composable, name is also inconsistent for custom properties", replaceWith = @ReplaceWith(expression = "customProperties(id)", imports = {}))
    public final androidx.compose.runtime.State<MotionProperties> motionProperties(String str, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1417298021, "C(motionProperties)873@35221L59:MotionLayout.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1417298021, i, -1, "androidx.constraintlayout.compose.MotionLayoutScope.motionProperties (MotionLayout.kt:873)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2036800100, "CC(remember):MotionLayout.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new MotionProperties(str, null), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customProperties(id)", imports = {}))
    public final MotionProperties motionProperties(String str, String str2) {
        return new MotionProperties(str, str2);
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customColor(id, name)", imports = {}))
    /* renamed from: motionColor-WaAFU9c  reason: not valid java name */
    public final long m7107motionColorWaAFU9c(String str, String str2) {
        return this.measurer.m7125getCustomColorXeAY9LY(str, str2, this.motionProgress.getFloatValue());
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customFloat(id, name)", imports = {}))
    public final float motionFloat(String str, String str2) {
        return this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue());
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customInt(id, name)", imports = {}))
    public final int motionInt(String str, String str2) {
        return (int) this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue());
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customDistance(id, name)", imports = {}))
    /* renamed from: motionDistance-chRvn1I  reason: not valid java name */
    public final float m7108motionDistancechRvn1I(String str, String str2) {
        return Dp.m6684constructorimpl(this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue()));
    }

    @Deprecated(message = "Deprecated for naming consistency", replaceWith = @ReplaceWith(expression = "customFontSize(id, name)", imports = {}))
    /* renamed from: motionFontSize-5XXgJZs  reason: not valid java name */
    public final long m7109motionFontSize5XXgJZs(String str, String str2) {
        return TextUnitKt.getSp(this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue()));
    }

    public final CustomProperties customProperties(String str) {
        return new CustomProperties(str);
    }

    /* renamed from: customColor-WaAFU9c  reason: not valid java name */
    public final long m7104customColorWaAFU9c(String str, String str2) {
        return this.measurer.m7125getCustomColorXeAY9LY(str, str2, this.motionProgress.getFloatValue());
    }

    public final float customFloat(String str, String str2) {
        return this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue());
    }

    public final int customInt(String str, String str2) {
        return (int) this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue());
    }

    /* renamed from: customDistance-chRvn1I  reason: not valid java name */
    public final float m7105customDistancechRvn1I(String str, String str2) {
        return Dp.m6684constructorimpl(this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue()));
    }

    /* renamed from: customFontSize-5XXgJZs  reason: not valid java name */
    public final long m7106customFontSize5XXgJZs(String str, String str2) {
        return TextUnitKt.getSp(this.measurer.getCustomFloat(str, str2, this.motionProgress.getFloatValue()));
    }

    public final Modifier onStartEndBoundsChanged(Modifier modifier, final Object obj, final Function2<? super Rect, ? super Rect, Unit> function2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope$onStartEndBoundsChanged$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("onStartEndBoundsChanged");
                inspectorInfo.getProperties().set("layoutId", obj);
                inspectorInfo.getProperties().set("onBoundsChanged", function2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope$onStartEndBoundsChanged$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r13v0, types: [androidx.compose.runtime.Composer] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-1096247907);
                ComposerKt.sourceInformation(composer, "C714@29121L42,717@29255L30,718@29319L52,721@29461L30,722@29523L52,726@29735L2269:MotionLayout.kt#fysre8");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1096247907, i, -1, "androidx.constraintlayout.compose.MotionLayoutScope.onStartEndBoundsChanged.<anonymous> (MotionLayout.kt:714)");
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1528961896, "CC(remember):MotionLayout.kt#9igjgp");
                boolean changed = composer.changed(obj);
                Object obj2 = obj;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = obj2.toString();
                    composer.updateRememberedValue(rememberedValue);
                }
                final String str = rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528957620, "CC(remember):MotionLayout.kt#9igjgp");
                Object rememberedValue2 = composer.rememberedValue();
                int[] iArr = rememberedValue2;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int[] iArr2 = new int[4];
                    for (int i2 = 0; i2 < 4; i2++) {
                        iArr2[i2] = 0;
                    }
                    composer.updateRememberedValue(iArr2);
                    iArr = iArr2;
                }
                final int[] iArr3 = (int[]) iArr;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528955550, "CC(remember):MotionLayout.kt#9igjgp");
                Object rememberedValue3 = composer.rememberedValue();
                Ref ref = rememberedValue3;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    Ref ref2 = new Ref();
                    ref2.setValue(Rect.Companion.getZero());
                    composer.updateRememberedValue(ref2);
                    ref = ref2;
                }
                final Ref ref3 = (Ref) ref;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528951028, "CC(remember):MotionLayout.kt#9igjgp");
                Object rememberedValue4 = composer.rememberedValue();
                int[] iArr4 = rememberedValue4;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    int[] iArr5 = new int[4];
                    for (int i3 = 0; i3 < 4; i3++) {
                        iArr5[i3] = 0;
                    }
                    composer.updateRememberedValue(iArr5);
                    iArr4 = iArr5;
                }
                final int[] iArr6 = (int[]) iArr4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528949022, "CC(remember):MotionLayout.kt#9igjgp");
                Object rememberedValue5 = composer.rememberedValue();
                Ref ref4 = rememberedValue5;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    Ref ref5 = new Ref();
                    ref5.setValue(Rect.Companion.getZero());
                    composer.updateRememberedValue(ref5);
                    ref4 = ref5;
                }
                final Ref ref6 = (Ref) ref4;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1528940021, "CC(remember):MotionLayout.kt#9igjgp");
                boolean changedInstance = composer.changedInstance(this) | composer.changed(str) | composer.changedInstance(iArr3) | composer.changedInstance(ref3) | composer.changedInstance(iArr6) | composer.changedInstance(ref6) | composer.changed(function2);
                final MotionLayoutScope motionLayoutScope = this;
                final Function2<Rect, Rect, Unit> function22 = function2;
                Object rememberedValue6 = composer.rememberedValue();
                if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutScope$onStartEndBoundsChanged$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            boolean z;
                            WidgetFrame start = MotionLayoutScope.this.measurer.getTransition().getStart(str);
                            boolean z2 = true;
                            if (start.left == iArr3[0] && start.top == iArr3[1] && start.right == iArr3[2] && start.bottom == iArr3[3]) {
                                z = false;
                            } else {
                                iArr3[0] = start.left;
                                iArr3[1] = start.top;
                                iArr3[2] = start.right;
                                iArr3[3] = start.bottom;
                                Ref<Rect> ref7 = ref3;
                                int[] iArr7 = iArr3;
                                ref7.setValue(new Rect(iArr7[0], iArr7[1], iArr7[2], iArr7[3]));
                                z = true;
                            }
                            WidgetFrame end = MotionLayoutScope.this.measurer.getTransition().getEnd(str);
                            if (end.left == iArr6[0] && end.top == iArr6[1] && end.right == iArr6[2] && end.bottom == iArr6[3]) {
                                z2 = z;
                            } else {
                                iArr6[0] = end.left;
                                iArr6[1] = end.top;
                                iArr6[2] = end.right;
                                iArr6[3] = end.bottom;
                                Ref<Rect> ref8 = ref6;
                                int[] iArr8 = iArr6;
                                ref8.setValue(new Rect(iArr8[0], iArr8[1], iArr8[2], iArr8[3]));
                            }
                            if (z2) {
                                Function2<Rect, Rect, Unit> function23 = function22;
                                Rect value = ref3.getValue();
                                if (value == null) {
                                    value = Rect.Companion.getZero();
                                }
                                Rect value2 = ref6.getValue();
                                if (value2 == null) {
                                    value2 = Rect.Companion.getZero();
                                }
                                function23.invoke(value, value2);
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier onPlaced = OnPlacedModifierKt.onPlaced(modifier2, (Function1) rememberedValue6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return onPlaced;
            }
        });
    }
}
