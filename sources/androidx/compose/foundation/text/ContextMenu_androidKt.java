package androidx.compose.foundation.text;

import androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: ContextMenu.android.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\f\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\r2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\b\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0018\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\rH\u0080@¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"ContextMenuArea", "", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "enabled", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TextItem", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/contextmenu/ContextMenuState;", Constants.ScionAnalytics.PARAM_LABEL, "Landroidx/compose/foundation/text/TextContextMenuItems;", "operation", "getContextMenuItemsAvailability", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenu_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7 */
    public static final void ContextMenuArea(final TextFieldSelectionManager textFieldSelectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(-1985516685);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuArea)P(1)44@1908L31,45@1965L24,46@2022L55,50@2183L17,53@2353L186,48@2123L450:ContextMenu.android.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985516685, i2, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:43)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181406995, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ContextMenuState(null, 1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181410667, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.Companion.m1135getNoneJKCFgKw()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181415781, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function0 = (Function0) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function1<ContextMenuScope, Unit> contextMenuBuilder = TextFieldSelectionManager_androidKt.contextMenuBuilder(textFieldSelectionManager, contextMenuState, mutableState);
            boolean enabled = textFieldSelectionManager.getEnabled();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181421390, "CC(remember):ContextMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(textFieldSelectionManager);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: ContextMenu.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$2$1$1", f = "ContextMenu.android.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$2$1$1  reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TextFieldSelectionManager $manager;
                        final /* synthetic */ MutableState<MenuItemsAvailability> $menuItemsAvailability;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(MutableState<MenuItemsAvailability> mutableState, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$menuItemsAvailability = mutableState;
                            this.$manager = textFieldSelectionManager;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$menuItemsAvailability, this.$manager, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.MutableState] */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            MutableState<MenuItemsAvailability> mutableState;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                MutableState<MenuItemsAvailability> mutableState2 = this.$menuItemsAvailability;
                                this.L$0 = mutableState2;
                                this.label = 1;
                                Object contextMenuItemsAvailability = ContextMenu_androidKt.getContextMenuItemsAvailability(this.$manager, this);
                                if (contextMenuItemsAvailability == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutableState = mutableState2;
                                obj = contextMenuItemsAvailability;
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                mutableState = (MutableState) this.L$0;
                                ResultKt.throwOnFailure(obj);
                            }
                            mutableState.setValue(obj);
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(mutableState, textFieldSelectionManager, null), 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function22 = function2;
            ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, function0, contextMenuBuilder, null, enabled, rememberedValue5, function22, startRestartGroup, ((i2 << 15) & 3670016) | 54, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ContextMenu_androidKt.ContextMenuArea(TextFieldSelectionManager.this, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void ContextMenuArea(final TextFieldSelectionState textFieldSelectionState, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(2103477555);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuArea)P(2,1)68@2749L31,69@2806L24,70@2863L55,75@3098L497,90@3711L17,93@3828L193,88@3651L404:ContextMenu.android.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2103477555, i2, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:67)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181433907, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ContextMenuState(null, 1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181437579, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.Companion.m1135getNoneJKCFgKw()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            MutableState mutableState2 = mutableState;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181445541, "CC(remember):ContextMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = (Function2) new Function2<TextFieldSelectionState, TextContextMenuItems, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: ContextMenu.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1", f = "ContextMenu.android.kt", i = {}, l = {79, 80, 81}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1  reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TextContextMenuItems $item;
                        final /* synthetic */ TextFieldSelectionState $this_contextMenuBuilder;
                        int label;

                        /* compiled from: ContextMenu.android.kt */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        /* renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1$WhenMappings */
                        /* loaded from: classes.dex */
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[TextContextMenuItems.values().length];
                                try {
                                    iArr[TextContextMenuItems.Cut.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[TextContextMenuItems.Copy.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                try {
                                    iArr[TextContextMenuItems.Paste.ordinal()] = 3;
                                } catch (NoSuchFieldError unused3) {
                                }
                                try {
                                    iArr[TextContextMenuItems.SelectAll.ordinal()] = 4;
                                } catch (NoSuchFieldError unused4) {
                                }
                                try {
                                    iArr[TextContextMenuItems.Autofill.ordinal()] = 5;
                                } catch (NoSuchFieldError unused5) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TextContextMenuItems textContextMenuItems, TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$item = textContextMenuItems;
                            this.$this_contextMenuBuilder = textFieldSelectionState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$item, this.$this_contextMenuBuilder, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
                            if (r5.$this_contextMenuBuilder.paste(r5) == r0) goto L24;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
                            if (r5.$this_contextMenuBuilder.copy(false, r5) == r0) goto L24;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
                            if (r5.$this_contextMenuBuilder.cut(r5) == r0) goto L24;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
                            return r0;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                int i2 = WhenMappings.$EnumSwitchMapping$0[this.$item.ordinal()];
                                if (i2 == 1) {
                                    this.label = 1;
                                } else if (i2 == 2) {
                                    this.label = 2;
                                } else if (i2 == 3) {
                                    this.label = 3;
                                } else if (i2 == 4) {
                                    this.$this_contextMenuBuilder.selectAll();
                                } else if (i2 == 5) {
                                    this.$this_contextMenuBuilder.autofill();
                                }
                            } else if (i != 1 && i != 2 && i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldSelectionState textFieldSelectionState2, TextContextMenuItems textContextMenuItems) {
                        invoke2(textFieldSelectionState2, textContextMenuItems);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldSelectionState textFieldSelectionState2, TextContextMenuItems textContextMenuItems) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(textContextMenuItems, textFieldSelectionState2, null), 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Function1<ContextMenuScope, Unit> contextMenuBuilder = TextFieldSelectionState_androidKt.contextMenuBuilder(textFieldSelectionState, contextMenuState, mutableState2, (Function2) rememberedValue4);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181464677, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function0 = (Function0) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181468597, "CC(remember):ContextMenu.android.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(textFieldSelectionState);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: ContextMenu.android.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1$1", f = "ContextMenu.android.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1$1  reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<MenuItemsAvailability> $menuItemsAvailability;
                        final /* synthetic */ TextFieldSelectionState $selectionState;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(MutableState<MenuItemsAvailability> mutableState, TextFieldSelectionState textFieldSelectionState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$menuItemsAvailability = mutableState;
                            this.$selectionState = textFieldSelectionState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$menuItemsAvailability, this.$selectionState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.MutableState] */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            MutableState<MenuItemsAvailability> mutableState;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                MutableState<MenuItemsAvailability> mutableState2 = this.$menuItemsAvailability;
                                this.L$0 = mutableState2;
                                this.label = 1;
                                Object contextMenuItemsAvailability = ContextMenu_androidKt.getContextMenuItemsAvailability(this.$selectionState, this);
                                if (contextMenuItemsAvailability == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutableState = mutableState2;
                                obj = contextMenuItemsAvailability;
                            } else if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                mutableState = (MutableState) this.L$0;
                                ResultKt.throwOnFailure(obj);
                            }
                            mutableState.setValue(obj);
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(mutableState, textFieldSelectionState, null), 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function22 = function2;
            z2 = z;
            ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, function0, contextMenuBuilder, null, z2, (Function0) rememberedValue6, function22, startRestartGroup, ((i2 << 9) & 57344) | 54 | ((i2 << 12) & 3670016), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            z2 = z;
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ContextMenu_androidKt.ContextMenuArea(TextFieldSelectionState.this, z2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void ContextMenuArea(final SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer startRestartGroup = composer.startRestartGroup(605522716);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContextMenuArea)P(1)104@4185L31,107@4321L17,105@4261L180:ContextMenu.android.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(selectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(605522716, i2, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:103)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181479859, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ContextMenuState(null, 1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 181484197, "CC(remember):ContextMenu.android.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$7$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            function22 = function2;
            ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, (Function0) rememberedValue2, SelectionManager_androidKt.contextMenuBuilder(selectionManager, contextMenuState), null, false, null, function22, startRestartGroup, ((i2 << 15) & 3670016) | 54, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function22 = function2;
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$8
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ContextMenu_androidKt.ContextMenuArea(SelectionManager.this, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextItem(ContextMenuScope contextMenuScope, final ContextMenuState contextMenuState, TextContextMenuItems textContextMenuItems, boolean z, final Function0<Unit> function0) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                    ContextMenuState_androidKt.close(contextMenuState);
                }
            }, 14, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getContextMenuItemsAvailability(TextFieldSelectionState textFieldSelectionState, Continuation<? super MenuItemsAvailability> continuation) {
        ContextMenu_androidKt$getContextMenuItemsAvailability$1 contextMenu_androidKt$getContextMenuItemsAvailability$1;
        int i;
        TextFieldSelectionState textFieldSelectionState2;
        boolean z;
        if (continuation instanceof ContextMenu_androidKt$getContextMenuItemsAvailability$1) {
            contextMenu_androidKt$getContextMenuItemsAvailability$1 = (ContextMenu_androidKt$getContextMenuItemsAvailability$1) continuation;
            if ((contextMenu_androidKt$getContextMenuItemsAvailability$1.label & Integer.MIN_VALUE) != 0) {
                contextMenu_androidKt$getContextMenuItemsAvailability$1.label -= Integer.MIN_VALUE;
                Object obj = contextMenu_androidKt$getContextMenuItemsAvailability$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = contextMenu_androidKt$getContextMenuItemsAvailability$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean canCopy = textFieldSelectionState.canCopy();
                    contextMenu_androidKt$getContextMenuItemsAvailability$1.L$0 = textFieldSelectionState;
                    contextMenu_androidKt$getContextMenuItemsAvailability$1.Z$0 = canCopy;
                    contextMenu_androidKt$getContextMenuItemsAvailability$1.label = 1;
                    Object canPaste = textFieldSelectionState.canPaste(contextMenu_androidKt$getContextMenuItemsAvailability$1);
                    if (canPaste == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    textFieldSelectionState2 = textFieldSelectionState;
                    z = canCopy;
                    obj = canPaste;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    z = contextMenu_androidKt$getContextMenuItemsAvailability$1.Z$0;
                    textFieldSelectionState2 = (TextFieldSelectionState) contextMenu_androidKt$getContextMenuItemsAvailability$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z, ((Boolean) obj).booleanValue(), textFieldSelectionState2.canCut(), textFieldSelectionState2.canSelectAll(), textFieldSelectionState2.canAutofill()));
            }
        }
        contextMenu_androidKt$getContextMenuItemsAvailability$1 = new ContextMenu_androidKt$getContextMenuItemsAvailability$1(continuation);
        Object obj2 = contextMenu_androidKt$getContextMenuItemsAvailability$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = contextMenu_androidKt$getContextMenuItemsAvailability$1.label;
        if (i != 0) {
        }
        return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z, ((Boolean) obj2).booleanValue(), textFieldSelectionState2.canCut(), textFieldSelectionState2.canSelectAll(), textFieldSelectionState2.canAutofill()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5  */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object getContextMenuItemsAvailability(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super MenuItemsAvailability> continuation) {
        ContextMenu_androidKt$getContextMenuItemsAvailability$2 contextMenu_androidKt$getContextMenuItemsAvailability$2;
        int i;
        boolean z;
        ?? r2;
        int i2;
        int i3;
        TextFieldSelectionManager textFieldSelectionManager2;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i8;
        ClipEntry clipEntry;
        if (continuation instanceof ContextMenu_androidKt$getContextMenuItemsAvailability$2) {
            contextMenu_androidKt$getContextMenuItemsAvailability$2 = (ContextMenu_androidKt$getContextMenuItemsAvailability$2) continuation;
            if ((contextMenu_androidKt$getContextMenuItemsAvailability$2.label & Integer.MIN_VALUE) != 0) {
                contextMenu_androidKt$getContextMenuItemsAvailability$2.label -= Integer.MIN_VALUE;
                Object obj = contextMenu_androidKt$getContextMenuItemsAvailability$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = contextMenu_androidKt$getContextMenuItemsAvailability$2.label;
                z = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    r2 = textFieldSelectionManager.getVisualTransformation$foundation_release() instanceof PasswordVisualTransformation;
                    boolean m6141getCollapsedimpl = TextRange.m6141getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE());
                    i2 = !m6141getCollapsedimpl ? 1 : 0;
                    i3 = (m6141getCollapsedimpl || r2 != 0) ? 0 : 1;
                    if (textFieldSelectionManager.getEditable()) {
                        Clipboard clipboard$foundation_release = textFieldSelectionManager.getClipboard$foundation_release();
                        i7 = r2;
                        i6 = i3;
                        if (clipboard$foundation_release != null) {
                            contextMenu_androidKt$getContextMenuItemsAvailability$2.L$0 = textFieldSelectionManager;
                            contextMenu_androidKt$getContextMenuItemsAvailability$2.I$0 = r2;
                            contextMenu_androidKt$getContextMenuItemsAvailability$2.I$1 = i2;
                            contextMenu_androidKt$getContextMenuItemsAvailability$2.I$2 = i3 == 1 ? 1 : 0;
                            contextMenu_androidKt$getContextMenuItemsAvailability$2.label = 1;
                            Object clipEntry2 = clipboard$foundation_release.getClipEntry(contextMenu_androidKt$getContextMenuItemsAvailability$2);
                            if (clipEntry2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            textFieldSelectionManager2 = textFieldSelectionManager;
                            i4 = i3 == 1 ? 1 : 0;
                            obj = clipEntry2;
                            i5 = i2;
                            i8 = r2;
                        }
                        z2 = false;
                        r2 = i7;
                        i3 = i6;
                        if (z2) {
                            z3 = true;
                            z5 = r2;
                            z4 = i3;
                            boolean z6 = i2 == 0 && textFieldSelectionManager.getEditable() && !z5;
                            boolean z7 = TextRange.m6143getLengthimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()) != textFieldSelectionManager.getValue$foundation_release().getText().length();
                            if (textFieldSelectionManager.getEditable() && TextRange.m6141getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE())) {
                                z = true;
                            }
                            return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z4, z3, z6, z7, z));
                        }
                    }
                    z3 = false;
                    z5 = r2;
                    z4 = i3;
                    if (i2 == 0) {
                    }
                    if (TextRange.m6143getLengthimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()) != textFieldSelectionManager.getValue$foundation_release().getText().length()) {
                    }
                    if (textFieldSelectionManager.getEditable()) {
                        z = true;
                    }
                    return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z4, z3, z6, z7, z));
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    i4 = contextMenu_androidKt$getContextMenuItemsAvailability$2.I$2;
                    i5 = contextMenu_androidKt$getContextMenuItemsAvailability$2.I$1;
                    int i9 = contextMenu_androidKt$getContextMenuItemsAvailability$2.I$0;
                    textFieldSelectionManager2 = (TextFieldSelectionManager) contextMenu_androidKt$getContextMenuItemsAvailability$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    i8 = i9;
                }
                clipEntry = (ClipEntry) obj;
                if (clipEntry != null || !ClipboardUtils_androidKt.hasText(clipEntry)) {
                    i6 = i4;
                    textFieldSelectionManager = textFieldSelectionManager2;
                    i2 = i5;
                    i7 = i8;
                    z2 = false;
                    r2 = i7;
                    i3 = i6;
                    if (z2) {
                    }
                    z3 = false;
                    z5 = r2;
                    z4 = i3;
                    if (i2 == 0) {
                    }
                    if (TextRange.m6143getLengthimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()) != textFieldSelectionManager.getValue$foundation_release().getText().length()) {
                    }
                    if (textFieldSelectionManager.getEditable()) {
                    }
                    return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z4, z3, z6, z7, z));
                }
                i3 = i4;
                textFieldSelectionManager = textFieldSelectionManager2;
                i2 = i5;
                z2 = true;
                r2 = i8;
                if (z2) {
                }
                z3 = false;
                z5 = r2;
                z4 = i3;
                if (i2 == 0) {
                }
                if (TextRange.m6143getLengthimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()) != textFieldSelectionManager.getValue$foundation_release().getText().length()) {
                }
                if (textFieldSelectionManager.getEditable()) {
                }
                return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z4, z3, z6, z7, z));
            }
        }
        contextMenu_androidKt$getContextMenuItemsAvailability$2 = new ContextMenu_androidKt$getContextMenuItemsAvailability$2(continuation);
        Object obj2 = contextMenu_androidKt$getContextMenuItemsAvailability$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = contextMenu_androidKt$getContextMenuItemsAvailability$2.label;
        z = false;
        if (i != 0) {
        }
        clipEntry = (ClipEntry) obj2;
        if (clipEntry != null) {
        }
        i6 = i4;
        textFieldSelectionManager = textFieldSelectionManager2;
        i2 = i5;
        i7 = i8;
        z2 = false;
        r2 = i7;
        i3 = i6;
        if (z2) {
        }
        z3 = false;
        z5 = r2;
        z4 = i3;
        if (i2 == 0) {
        }
        if (TextRange.m6143getLengthimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()) != textFieldSelectionManager.getValue$foundation_release().getText().length()) {
        }
        if (textFieldSelectionManager.getEditable()) {
        }
        return MenuItemsAvailability.m1122boximpl(MenuItemsAvailability.m1124constructorimpl(z4, z3, z6, z7, z));
    }
}
