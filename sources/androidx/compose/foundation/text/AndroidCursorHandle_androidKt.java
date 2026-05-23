package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: AndroidCursorHandle.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0014\u001a\u001b\u0010\u0015\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\u001a"}, d2 = {"Sqrt2", "", "CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "CursorHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "CursorHandle-USBMPiE", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCursorHandle", "handleColor", "Landroidx/compose/ui/graphics/Color;", "drawCursorHandle-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidCursorHandle_androidKt {
    private static final float CursorHandleHeight;
    private static final float CursorHandleWidth;
    private static final float Sqrt2 = 1.4142135f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CursorHandle_USBMPiE$lambda$2(OffsetProvider offsetProvider, Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m1474CursorHandleUSBMPiE(offsetProvider, modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DefaultCursorHandle$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        DefaultCursorHandle(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final float getCursorHandleHeight() {
        return CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return CursorHandleWidth;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
        if ((r14 & 4) != 0) goto L61;
     */
    /* renamed from: CursorHandle-USBMPiE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1474CursorHandleUSBMPiE(final OffsetProvider offsetProvider, final Modifier modifier, final long j, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1776202187);
        ComposerKt.sourceInformation(startRestartGroup, "C(CursorHandle)N(offsetProvider,modifier,minTouchTargetSize:c#ui.unit.DpSize)53@2207L305,62@2608L492,62@2517L583:AndroidCursorHandle.android.kt#423gt5");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(offsetProvider) : startRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j)) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 4) != 0) {
                    j = DpSize.Companion.m8267getUnspecifiedMYxV2XQ();
                    i3 &= -897;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1776202187, i3, -1, "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:51)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1828290780, "CC(remember):AndroidCursorHandle.android.kt#9igjgp");
                int i4 = i3 & 14;
                boolean z = i4 == 4 || ((i3 & 8) != 0 && startRestartGroup.changedInstance(offsetProvider));
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CursorHandle_USBMPiE$lambda$0$0;
                            CursorHandle_USBMPiE$lambda$0$0 = AndroidCursorHandle_androidKt.CursorHandle_USBMPiE$lambda$0$0(OffsetProvider.this, (SemanticsPropertyReceiver) obj);
                            return CursorHandle_USBMPiE$lambda$0$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue, 1, null);
                AndroidSelectionHandles_androidKt.HandlePopup(offsetProvider, Alignment.Companion.getTopCenter(), ComposableLambdaKt.rememberComposableLambda(-1653527038, true, new Function2() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidCursorHandle_androidKt.CursorHandle_USBMPiE$lambda$1(j, semantics$default, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, startRestartGroup, 54), startRestartGroup, i4 | 432);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final long j2 = j;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidCursorHandle_androidKt.CursorHandle_USBMPiE$lambda$2(OffsetProvider.this, modifier, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CursorHandle_USBMPiE$lambda$0$0(OffsetProvider offsetProvider, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, offsetProvider.mo1489provideF1C5BW0(), SelectionHandleAnchor.Middle, true, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CursorHandle_USBMPiE$lambda$1(long j, Modifier modifier, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AndroidCursorHandle.android.kt#423gt5");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1653527038, i, -1, "androidx.compose.foundation.text.CursorHandle.<anonymous> (AndroidCursorHandle.android.kt:63)");
            }
            if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
                composer.startReplaceGroup(-1244013944);
                ComposerKt.sourceInformation(composer, "64@2668L352");
                Modifier m1113requiredSizeInqDBjuR0$default = SizeKt.m1113requiredSizeInqDBjuR0$default(modifier, DpSize.m8258getWidthD9Ej5fM(j), DpSize.m8256getHeightD9Ej5fM(j), 0.0f, 0.0f, 12, null);
                Alignment topCenter = Alignment.Companion.getTopCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topCenter, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m1113requiredSizeInqDBjuR0$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m4467constructorimpl = Updater.m4467constructorimpl(composer);
                Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 922244333, "C72@2985L21:AndroidCursorHandle.android.kt#423gt5");
                DefaultCursorHandle(null, composer, 0, 1);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1243644858);
                ComposerKt.sourceInformation(composer, "75@3050L34");
                DefaultCursorHandle(modifier, composer, 0, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void DefaultCursorHandle(final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(694251107);
        ComposerKt.sourceInformation(startRestartGroup, "C(DefaultCursorHandle)N(modifier)86@3345L7,83@3208L163:AndroidCursorHandle.android.kt#423gt5");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694251107, i3, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
            }
            Modifier m1119sizeVpY3zN4 = SizeKt.m1119sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SpacerKt.Spacer(m1475drawCursorHandle4WTKRHQ(m1119sizeVpY3zN4, ((TextSelectionColors) consume).m2121getHandleColor0d7_KjU()), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidCursorHandle_androidKt.DefaultCursorHandle$lambda$0(Modifier.this, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: drawCursorHandle-4WTKRHQ  reason: not valid java name */
    private static final Modifier m1475drawCursorHandle4WTKRHQ(Modifier modifier, final long j) {
        return DrawModifierKt.drawWithCache(modifier, new Function1() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AndroidCursorHandle_androidKt.drawCursorHandle_4WTKRHQ$lambda$0(j, (CacheDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DrawResult drawCursorHandle_4WTKRHQ$lambda$0(long j, CacheDrawScope cacheDrawScope) {
        final float intBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.m4883getSizeNHjbRc() >> 32)) / 2.0f;
        final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, intBitsToFloat);
        final ColorFilter m5389tintxETnrds$default = ColorFilter.Companion.m5389tintxETnrds$default(ColorFilter.Companion, j, 0, 2, null);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit drawCursorHandle_4WTKRHQ$lambda$0$0;
                drawCursorHandle_4WTKRHQ$lambda$0$0 = AndroidCursorHandle_androidKt.drawCursorHandle_4WTKRHQ$lambda$0$0(intBitsToFloat, createHandleImage, m5389tintxETnrds$default, (ContentDrawScope) obj);
                return drawCursorHandle_4WTKRHQ$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawCursorHandle_4WTKRHQ$lambda$0$0(float f, ImageBitmap imageBitmap, ColorFilter colorFilter, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            DrawTransform.translate$default(transform, f, 0.0f, 2, null);
            transform.mo5849rotateUv8p0NA(45.0f, Offset.Companion.m5119getZeroF1C5BW0());
            DrawScope.m5906drawImagegbVJVH8$default(contentDrawScope2, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
            drawContext.getCanvas().restore();
            drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
            throw th;
        }
    }

    static {
        float m8160constructorimpl = Dp.m8160constructorimpl(25.0f);
        CursorHandleHeight = m8160constructorimpl;
        CursorHandleWidth = Dp.m8160constructorimpl(Dp.m8160constructorimpl(m8160constructorimpl * 2.0f) / 2.4142137f);
    }
}
