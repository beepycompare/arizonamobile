package androidx.compose.material3;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: DragHandle.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"VerticalDragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "colors", "Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DragHandleSizes;Landroidx/compose/material3/DragHandleColors;Landroidx/compose/material3/DragHandleShapes;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "pressable", "onPressed", "Lkotlin/Function0;", "onReleasedOrCancelled", "material3", "isDragged", "", "isPressed"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragHandleKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDragHandle$lambda$16(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        VerticalDragHandle(modifier, dragHandleSizes, dragHandleColors, dragHandleShapes, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VerticalDragHandle(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        DragHandleSizes dragHandleSizes2;
        final DragHandleColors dragHandleColors2;
        final DragHandleShapes dragHandleShapes2;
        Object obj2;
        final DragHandleSizes dragHandleSizes3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        final DragHandleSizes dragHandleSizes4;
        MutableInteractionSource mutableInteractionSource2;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1693656835);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalDragHandle)N(modifier,sizes,colors,shapes,interactionSource)81@3988L25,82@4035L34,88@4262L20,88@4284L21,89@4338L307,98@4670L796,115@5495L299,83@4074L1783:DragHandle.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                dragHandleSizes2 = dragHandleSizes;
                if (startRestartGroup.changed(dragHandleSizes2)) {
                    i6 = 32;
                    i3 |= i6;
                }
            } else {
                dragHandleSizes2 = dragHandleSizes;
            }
            i6 = 16;
            i3 |= i6;
        } else {
            dragHandleSizes2 = dragHandleSizes;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                dragHandleColors2 = dragHandleColors;
                if (startRestartGroup.changed(dragHandleColors2)) {
                    i5 = 256;
                    i3 |= i5;
                }
            } else {
                dragHandleColors2 = dragHandleColors;
            }
            i5 = 128;
            i3 |= i5;
        } else {
            dragHandleColors2 = dragHandleColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                dragHandleShapes2 = dragHandleShapes;
                if (startRestartGroup.changed(dragHandleShapes2)) {
                    i4 = 2048;
                    i3 |= i4;
                }
            } else {
                dragHandleShapes2 = dragHandleShapes;
            }
            i4 = 1024;
            i3 |= i4;
        } else {
            dragHandleShapes2 = dragHandleShapes;
        }
        int i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            obj2 = mutableInteractionSource;
            i3 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
            boolean z = true;
            if (startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                dragHandleSizes3 = dragHandleSizes2;
            } else {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "75@3689L8,76@3757L8");
                if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i7 != 0 ? Modifier.Companion : obj;
                    if ((i2 & 2) != 0) {
                        dragHandleSizes4 = VerticalDragHandleDefaults.INSTANCE.sizes();
                        i3 &= -113;
                    } else {
                        dragHandleSizes4 = dragHandleSizes2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        dragHandleColors2 = VerticalDragHandleDefaults.INSTANCE.colors(startRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        dragHandleShapes2 = VerticalDragHandleDefaults.INSTANCE.shapes(startRestartGroup, 6);
                    }
                    if (i8 != 0) {
                        obj2 = null;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    companion = obj;
                    dragHandleSizes4 = dragHandleSizes2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1693656835, i3, -1, "androidx.compose.material3.VerticalDragHandle (DragHandle.kt:78)");
                }
                if (obj2 == null) {
                    startRestartGroup.startReplaceGroup(-1544610024);
                    ComposerKt.sourceInformation(startRestartGroup, "80@3909L39");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188373462, "CC(remember):DragHandle.kt#9igjgp");
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-188374113);
                    startRestartGroup.endReplaceGroup();
                    mutableInteractionSource2 = obj2;
                }
                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                final State<Boolean> collectIsDraggedAsState = DragInteractionKt.collectIsDraggedAsState(mutableInteractionSource3, startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188369435, "CC(remember):DragHandle.kt#9igjgp");
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState = (MutableState) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier modifier2 = companion;
                Modifier hoverable$default = HoverableKt.hoverable$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion), mutableInteractionSource2, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188362185, "CC(remember):DragHandle.kt#9igjgp");
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DragHandleKt.VerticalDragHandle$lambda$6$lambda$5(MutableState.this);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Function0 function0 = (Function0) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188361480, "CC(remember):DragHandle.kt#9igjgp");
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DragHandleKt.VerticalDragHandle$lambda$8$lambda$7(MutableState.this);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier pressable = pressable(hoverable$default, mutableInteractionSource2, function0, (Function0) rememberedValue4);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188359466, "CC(remember):DragHandle.kt#9igjgp");
                boolean changed = startRestartGroup.changed(collectIsDraggedAsState) | ((((i3 & 7168) ^ 3072) > 2048 && startRestartGroup.changed(dragHandleShapes2)) || (i3 & 3072) == 2048);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return DragHandleKt.VerticalDragHandle$lambda$10$lambda$9(DragHandleShapes.this, collectIsDraggedAsState, mutableState, (GraphicsLayerScope) obj3);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(pressable, (Function1) rememberedValue5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188348353, "CC(remember):DragHandle.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(collectIsDraggedAsState) | ((((i3 & 112) ^ 48) > 32 && startRestartGroup.changed(dragHandleSizes4)) || (i3 & 48) == 32);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function3() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return DragHandleKt.VerticalDragHandle$lambda$13$lambda$12(DragHandleSizes.this, collectIsDraggedAsState, mutableState, (MeasureScope) obj3, (Measurable) obj4, (Constraints) obj5);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier layout = LayoutModifierKt.layout(graphicsLayer, (Function3) rememberedValue6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -188322450, "CC(remember):DragHandle.kt#9igjgp");
                boolean changed3 = startRestartGroup.changed(collectIsDraggedAsState);
                if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !startRestartGroup.changed(dragHandleColors2)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                    z = false;
                }
                boolean z2 = changed3 | z;
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return DragHandleKt.VerticalDragHandle$lambda$15$lambda$14(DragHandleColors.this, collectIsDraggedAsState, mutableState, (DrawScope) obj3);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                BoxKt.Box(IndicationKt.indication(DrawModifierKt.drawBehind(layout, (Function1) rememberedValue7), mutableInteractionSource3, RippleKt.m2402rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dragHandleSizes3 = dragHandleSizes4;
                obj = modifier2;
            }
            final DragHandleColors dragHandleColors3 = dragHandleColors2;
            final MutableInteractionSource mutableInteractionSource4 = obj2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = obj;
                final DragHandleShapes dragHandleShapes3 = dragHandleShapes2;
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return DragHandleKt.VerticalDragHandle$lambda$16(Modifier.this, dragHandleSizes3, dragHandleColors3, dragHandleShapes3, mutableInteractionSource4, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj2 = mutableInteractionSource;
        boolean z3 = true;
        if (startRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        final DragHandleColors dragHandleColors32 = dragHandleColors2;
        final MutableInteractionSource mutableInteractionSource42 = obj2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean VerticalDragHandle$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VerticalDragHandle$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDragHandle$lambda$6$lambda$5(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDragHandle$lambda$8$lambda$7(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDragHandle$lambda$10$lambda$9(DragHandleShapes dragHandleShapes, State state, MutableState mutableState, GraphicsLayerScope graphicsLayerScope) {
        Shape pressedShape;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedShape = dragHandleShapes.getDraggedShape();
        } else {
            pressedShape = VerticalDragHandle$lambda$3(mutableState) ? dragHandleShapes.getPressedShape() : dragHandleShapes.getShape();
        }
        graphicsLayerScope.setShape(pressedShape);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MeasureResult VerticalDragHandle$lambda$13$lambda$12(DragHandleSizes dragHandleSizes, State state, MutableState mutableState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long m2045getPressedSizeMYxV2XQ;
        if (VerticalDragHandle$lambda$1(state)) {
            m2045getPressedSizeMYxV2XQ = dragHandleSizes.m2044getDraggedSizeMYxV2XQ();
        } else {
            m2045getPressedSizeMYxV2XQ = VerticalDragHandle$lambda$3(mutableState) ? dragHandleSizes.m2045getPressedSizeMYxV2XQ() : dragHandleSizes.m2046getSizeMYxV2XQ();
        }
        long j = measureScope.mo406toSizeXkaWNTQ(m2045getPressedSizeMYxV2XQ);
        final Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(Constraints.Companion.m7518fixedJhjzzOo(Math.round(Float.intBitsToFloat((int) (j >> 32))), Math.round(Float.intBitsToFloat((int) (j & 4294967295L)))));
        return MeasureScope.layout$default(measureScope, mo6216measureBRTryo0.getWidth(), mo6216measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragHandleKt.VerticalDragHandle$lambda$13$lambda$12$lambda$11(Placeable.this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDragHandle$lambda$13$lambda$12$lambda$11(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VerticalDragHandle$lambda$15$lambda$14(DragHandleColors dragHandleColors, State state, MutableState mutableState, DrawScope drawScope) {
        long m2043getPressedColor0d7_KjU;
        if (VerticalDragHandle$lambda$1(state)) {
            m2043getPressedColor0d7_KjU = dragHandleColors.m2042getDraggedColor0d7_KjU();
        } else {
            m2043getPressedColor0d7_KjU = VerticalDragHandle$lambda$3(mutableState) ? dragHandleColors.m2043getPressedColor0d7_KjU() : dragHandleColors.m2041getColor0d7_KjU();
        }
        DrawScope.m5340drawRectnJ9OG0$default(drawScope, m2043getPressedColor0d7_KjU, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    private static final Modifier pressable(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mutableInteractionSource, new PointerInputEventHandler() { // from class: androidx.compose.material3.DragHandleKt$pressable$1

            /* compiled from: DragHandle.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DragHandleKt$pressable$1$1", f = "DragHandle.kt", i = {0}, l = {341, 343}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            /* renamed from: androidx.compose.material3.DragHandleKt$pressable$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onPressed;
                final /* synthetic */ Function0<Unit> $onReleasedOrCancelled;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Function0<Unit> function0, Function0<Unit> function02, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onPressed = function0;
                    this.$onReleasedOrCancelled = function02;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onPressed, this.$onReleasedOrCancelled, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
                    if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, androidx.compose.ui.input.pointer.PointerEventPass.Initial, r10) == r0) goto L14;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope2;
                        this.label = 1;
                        if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, PointerEventPass.Initial, this, 1, null) != coroutine_suspended) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            this.$onReleasedOrCancelled.invoke();
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    this.$onPressed.invoke();
                    this.L$0 = null;
                    this.label = 2;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(function0, function02, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    private static final boolean VerticalDragHandle$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
