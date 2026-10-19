package com.miami.game.ui.app.root;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.extensions.compose.stack.ChildrenKt;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation;
import com.miami.game.core.app.root.MainScaffoldKt;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.settings.ui.SettingsComponent;
import com.miami.game.ui.classic.dialogs.ClassicDialogsRoutesKt;
import com.miami.game.ui.classic.download.screen.ClassicDownloadScreenRouteKt;
import com.miami.game.ui.classic.home.ClassicHomeRouteKt;
import com.miami.game.ui.classic.notifications.ClassicNotificationsRouteKt;
import com.miami.game.ui.classic.select.server.ClassicSelectServerRouteKt;
import com.miami.game.ui.classic.settings.ClassicSettingsRouteKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
/* compiled from: MainRoute.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032-\u0010\u0004\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052/\u0010\n\u001a+\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u00052-\u0010\r\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052-\u0010\u000e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010\u000f\u001aï\u0001\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032-\u0010\u0004\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052/\u0010\n\u001a+\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u00052-\u0010\r\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052-\u0010\u000e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0003b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"MainRoute", "", "component", "Lcom/miami/game/core/app/root/nav/main/MainComponent;", "onViceCityEnable", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onComplete", "onViceCityInspectBeforeDisable", "", "onResult", "onViceCityKeep", "onViceCityDelete", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "Children", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app-root"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Children$lambda$1(MainComponent mainComponent, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Children(mainComponent, function1, function12, function13, function14, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MainRoute$lambda$0(MainComponent mainComponent, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Composer composer, int i2) {
        MainRoute(mainComponent, function1, function12, function13, function14, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MainRoute(final MainComponent component, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityEnable, final Function1<? super Function1<? super Long, Unit>, Unit> onViceCityInspectBeforeDisable, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityKeep, final Function1<? super Function1<? super Boolean, Unit>, Unit> onViceCityDelete, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(onViceCityEnable, "onViceCityEnable");
        Intrinsics.checkNotNullParameter(onViceCityInspectBeforeDisable, "onViceCityInspectBeforeDisable");
        Intrinsics.checkNotNullParameter(onViceCityKeep, "onViceCityKeep");
        Intrinsics.checkNotNullParameter(onViceCityDelete, "onViceCityDelete");
        Composer startRestartGroup = composer.startRestartGroup(327198693);
        ComposerKt.sourceInformation(startRestartGroup, "C(MainRoute)N(component,onViceCityEnable,onViceCityInspectBeforeDisable,onViceCityKeep,onViceCityDelete)29@1498L250:MainRoute.kt#bpdw87");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityEnable) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityInspectBeforeDisable) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityKeep) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(onViceCityDelete) ? 16384 : 8192;
        }
        if (!startRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(327198693, i2, -1, "com.miami.game.ui.app.root.MainRoute (MainRoute.kt:28)");
            }
            Children(component, onViceCityEnable, onViceCityInspectBeforeDisable, onViceCityKeep, onViceCityDelete, null, startRestartGroup, (i2 & 57344) | MainComponent.$stable | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168), 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainRouteKt.MainRoute$lambda$0(MainComponent.this, onViceCityEnable, onViceCityInspectBeforeDisable, onViceCityKeep, onViceCityDelete, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Children(final MainComponent mainComponent, final Function1<? super Function1<? super Boolean, Unit>, Unit> function1, final Function1<? super Function1<? super Long, Unit>, Unit> function12, final Function1<? super Function1<? super Boolean, Unit>, Unit> function13, final Function1<? super Function1<? super Boolean, Unit>, Unit> function14, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-438220615);
        ComposerKt.sourceInformation(startRestartGroup, "C(Children)N(component,onViceCityEnable,onViceCityInspectBeforeDisable,onViceCityKeep,onViceCityDelete,modifier)50@2194L4922,47@2119L4997:MainRoute.kt#bpdw87");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(mainComponent) : startRestartGroup.changedInstance(mainComponent) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            obj = function1;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
        } else {
            obj = function1;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = function12;
            i3 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
        } else {
            obj2 = function12;
        }
        if ((i & 3072) == 0) {
            obj3 = function13;
            i3 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
        } else {
            obj3 = function13;
        }
        if ((i & 24576) == 0) {
            obj4 = function14;
            i3 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
        } else {
            obj4 = function14;
        }
        int i4 = i2 & 32;
        if (i4 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((196608 & i) == 0) {
            obj5 = modifier;
            i3 |= startRestartGroup.changed(obj5) ? 131072 : 65536;
            if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                modifier2 = obj5;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-438220615, i3, -1, "com.miami.game.ui.app.root.Children (MainRoute.kt:46)");
                }
                final Function1<? super Function1<? super Boolean, Unit>, Unit> function15 = obj;
                final Function1<? super Function1<? super Long, Unit>, Unit> function16 = obj2;
                final Function1<? super Function1<? super Boolean, Unit>, Unit> function17 = obj3;
                final Function1<? super Function1<? super Boolean, Unit>, Unit> function18 = obj4;
                MainScaffoldKt.MainScaffold(WindowInsetsPadding_androidKt.imePadding(companion), null, null, null, ComposableLambdaKt.rememberComposableLambda(-2092676260, true, new Function3() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj6, Object obj7, Object obj8) {
                        return MainRouteKt.Children$lambda$0(MainComponent.this, function15, function16, function17, function18, (PaddingValues) obj6, (Composer) obj7, ((Integer) obj8).intValue());
                    }
                }, startRestartGroup, 54), startRestartGroup, 24576, 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj6, Object obj7) {
                        return MainRouteKt.Children$lambda$1(MainComponent.this, function1, function12, function13, function14, modifier2, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj5 = modifier;
        if (startRestartGroup.shouldExecute((74899 & i3) == 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Children$lambda$0(final MainComponent mainComponent, final Function1 function1, final Function1 function12, final Function1 function13, final Function1 function14, PaddingValues it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)55@2325L2452,51@2204L2573,111@4914L2196,107@4787L2323:MainRoute.kt#bpdw87");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2092676260, i, -1, "com.miami.game.ui.app.root.Children.<anonymous> (MainRoute.kt:51)");
            }
            ChildrenKt.Children(mainComponent.getStack(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(22656287, true, new Function3() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Children$lambda$0$0;
                    Children$lambda$0$0 = MainRouteKt.Children$lambda$0$0(MainComponent.this, function1, function12, function13, function14, (Child.Created) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Children$lambda$0$0;
                }
            }, composer, 54), composer, 3120, 4);
            ChildrenKt.Children(mainComponent.getStackDialog(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(-2114632632, true, new Function3() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Children$lambda$0$1;
                    Children$lambda$0$1 = MainRouteKt.Children$lambda$0$1(MainComponent.this, (Child.Created) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Children$lambda$0$1;
                }
            }, composer, 54), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$0$0(MainComponent mainComponent, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Child.Created it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):MainRoute.kt#bpdw87");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(22656287, i, -1, "com.miami.game.ui.app.root.Children.<anonymous>.<anonymous> (MainRoute.kt:56)");
        }
        MainComponent.Child child = (MainComponent.Child) it.getInstance();
        if (child instanceof MainComponent.Child.Home) {
            composer.startReplaceGroup(643717381);
            ComposerKt.sourceInformation(composer, "60@2557L29,61@2638L34,62@2725L35,63@2810L32,64@2895L35,65@2987L44,66@3082L39,58@2441L702");
            HomeComponent component = ((MainComponent.Child.Home) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 297862780, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MainRouteKt$Children$1$1$1$1(mainComponent);
                composer.updateRememberedValue(rememberedValue);
            }
            KFunction kFunction = (KFunction) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297865377, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$2$1 rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MainRouteKt$Children$1$1$2$1(mainComponent);
                composer.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction2 = (KFunction) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297868162, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$3$1 rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MainRouteKt$Children$1$1$3$1(mainComponent);
                composer.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction3 = (KFunction) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297870879, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance4 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$4$1 rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MainRouteKt$Children$1$1$4$1(mainComponent);
                composer.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction4 = (KFunction) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297873602, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance5 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$5$1 rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MainRouteKt$Children$1$1$5$1(mainComponent);
                composer.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction5 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297876555, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance6 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$6$1 rememberedValue6 = composer.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MainRouteKt$Children$1$1$6$1(mainComponent);
                composer.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction6 = (KFunction) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297879590, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance7 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$7$1 rememberedValue7 = composer.rememberedValue();
            if (changedInstance7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new MainRouteKt$Children$1$1$7$1(mainComponent);
                composer.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicHomeRouteKt.ClassicHomeRoute(component, (Function0) kFunction, (Function0) kFunction2, (Function0) kFunction6, (Function1) kFunction3, (Function0) kFunction5, (Function2) kFunction4, (Function0) ((KFunction) rememberedValue7), composer, HomeComponent.$stable);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.SelectServer) {
            composer.startReplaceGroup(644493342);
            ComposerKt.sourceInformation(composer, "73@3358L25,71@3240L165");
            SelectServerComponent component2 = ((MainComponent.Child.SelectServer) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 297888408, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance8 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$8$1 rememberedValue8 = composer.rememberedValue();
            if (changedInstance8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new MainRouteKt$Children$1$1$8$1(mainComponent);
                composer.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicSelectServerRouteKt.ClassicSelectServerRoute((Function0) ((KFunction) rememberedValue8), component2, composer, SelectServerComponent.$stable << 3);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.Settings) {
            composer.startReplaceGroup(644768126);
            ComposerKt.sourceInformation(composer, "80@3611L23,81@3681L35,82@3764L44,83@3854L42,84@3943L37,78@3498L773");
            SettingsComponent component3 = ((MainComponent.Child.Settings) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 297896502, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance9 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$9$1 rememberedValue9 = composer.rememberedValue();
            if (changedInstance9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new MainRouteKt$Children$1$1$9$1(mainComponent);
                composer.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction7 = (KFunction) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297898754, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance10 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$10$1 rememberedValue10 = composer.rememberedValue();
            if (changedInstance10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new MainRouteKt$Children$1$1$10$1(mainComponent);
                composer.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction8 = (KFunction) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297901419, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance11 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$11$1 rememberedValue11 = composer.rememberedValue();
            if (changedInstance11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new MainRouteKt$Children$1$1$11$1(mainComponent);
                composer.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction9 = (KFunction) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297904297, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance12 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$12$1 rememberedValue12 = composer.rememberedValue();
            if (changedInstance12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new MainRouteKt$Children$1$1$12$1(mainComponent);
                composer.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction10 = (KFunction) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 297907140, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance13 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$13$1 rememberedValue13 = composer.rememberedValue();
            if (changedInstance13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new MainRouteKt$Children$1$1$13$1(mainComponent);
                composer.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicSettingsRouteKt.ClassicSettingsRoute(component3, (Function0) kFunction7, (Function0) kFunction9, (Function0) kFunction10, (Function0) kFunction8, (Function1) ((KFunction) rememberedValue13), function1, function12, function13, function14, composer, SettingsComponent.$stable);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.DownloadScreen) {
            composer.startReplaceGroup(645591765);
            ComposerKt.sourceInformation(composer, "93@4370L102");
            ClassicDownloadScreenRouteKt.ClassicDownloadScreenRoute(((MainComponent.Child.DownloadScreen) child).getComponent(), composer, DownloadScreenComponent.$stable);
            composer.endReplaceGroup();
        } else if (!(child instanceof MainComponent.Child.Notification)) {
            composer.startReplaceGroup(297858203);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(645811741);
            ComposerKt.sourceInformation(composer, "101@4688L25,99@4569L166");
            NotificationsComponent component4 = ((MainComponent.Child.Notification) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 297930968, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance14 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$14$1 rememberedValue14 = composer.rememberedValue();
            if (changedInstance14 || rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = new MainRouteKt$Children$1$1$14$1(mainComponent);
                composer.updateRememberedValue(rememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicNotificationsRouteKt.ClassicNotificationsRoute((Function0) ((KFunction) rememberedValue14), component4, composer, NotificationsComponent.$stable << 3);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$0$1(MainComponent mainComponent, Child.Created it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):MainRoute.kt#bpdw87");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2114632632, i, -1, "com.miami.game.ui.app.root.Children.<anonymous>.<anonymous> (MainRoute.kt:112)");
        }
        MainComponent.DialogChild dialogChild = (MainComponent.DialogChild) it.getInstance();
        if (Intrinsics.areEqual(dialogChild, MainComponent.DialogChild.EMPTY.INSTANCE)) {
            composer.startReplaceGroup(1559655623);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.DownloadCache) {
            composer.startReplaceGroup(1559746546);
            ComposerKt.sourceInformation(composer, "119@5233L29,120@5315L35,117@5117L256");
            CommonDialogComponent component = ((MainComponent.DialogChild.DownloadCache) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -642418107, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MainRouteKt$Children$1$2$1$1(mainComponent);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) rememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -642415477, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$2$1 rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MainRouteKt$Children$1$2$2$1(mainComponent);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicDialogsRoutesKt.ClassicSetupDialogRoute(component, function0, (Function0) ((KFunction) rememberedValue2), composer, CommonDialogComponent.$stable);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.RepairGameError) {
            composer.startReplaceGroup(1560104317);
            ComposerKt.sourceInformation(composer, "126@5604L29,127@5671L29,124@5478L245");
            CommonDialogComponent component2 = ((MainComponent.DialogChild.RepairGameError) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -642406235, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$3$1 rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MainRouteKt$Children$1$2$3$1(mainComponent);
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, -642404091, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance4 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$4$1 rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MainRouteKt$Children$1$2$4$1(mainComponent);
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicDialogsRoutesKt.ClassicRepairGameErrorDialogRoute(component2, function02, (Function0) ((KFunction) rememberedValue4), composer, CommonDialogComponent.$stable);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.RepairGameSuccess) {
            composer.startReplaceGroup(1560453563);
            ComposerKt.sourceInformation(composer, "133@5958L29,134@6025L29,131@5830L247");
            CommonDialogComponent component3 = ((MainComponent.DialogChild.RepairGameSuccess) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -642394907, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance5 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$5$1 rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MainRouteKt$Children$1$2$5$1(mainComponent);
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function03 = (Function0) ((KFunction) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composer, -642392763, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance6 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$6$1 rememberedValue6 = composer.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MainRouteKt$Children$1$2$6$1(mainComponent);
                composer.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicDialogsRoutesKt.ClassicRepairGameSuccessDialogRoute(component3, function03, (Function0) ((KFunction) rememberedValue6), composer, CommonDialogComponent.$stable);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.ErrorNoNetwork) {
            composer.startReplaceGroup(1560800329);
            ComposerKt.sourceInformation(composer, "140@6306L2,141@6344L16,138@6181L201");
            ErrorDialogComponent component4 = ((MainComponent.DialogChild.ErrorNoNetwork) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -642383798, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue7 = composer.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue7);
            }
            Function0 function04 = (Function0) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -642382568, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance7 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$8$1 rememberedValue8 = composer.rememberedValue();
            if (changedInstance7 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new MainRouteKt$Children$1$2$8$1(mainComponent);
                composer.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicDialogsRoutesKt.ClassicNoNetworkErrorDialogRoute(component4, function04, (Function0) ((KFunction) rememberedValue8), composer, ErrorDialogComponent.$stable | 48);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.RepairGameDialog) {
            composer.startReplaceGroup(1561108407);
            ComposerKt.sourceInformation(composer, "148@6610L29,149@6677L35,150@6748L2,146@6489L283");
            ErrorDialogComponent component5 = ((MainComponent.DialogChild.RepairGameDialog) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -642374043, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance8 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$9$1 rememberedValue9 = composer.rememberedValue();
            if (changedInstance8 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new MainRouteKt$Children$1$2$9$1(mainComponent);
                composer.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function05 = (Function0) ((KFunction) rememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer, -642371893, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance9 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$10$1 rememberedValue10 = composer.rememberedValue();
            if (changedInstance9 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new MainRouteKt$Children$1$2$10$1(mainComponent);
                composer.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function06 = (Function0) ((KFunction) rememberedValue10);
            ComposerKt.sourceInformationMarkerStart(composer, -642369654, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue11 = composer.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicDialogsRoutesKt.ClassicRepairGameDialogRoute(component5, function05, function06, (Function0) rememberedValue11, composer, ErrorDialogComponent.$stable | 3072);
            composer.endReplaceGroup();
        } else if (!(dialogChild instanceof MainComponent.DialogChild.ErrorActivity)) {
            composer.startReplaceGroup(-642425724);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(1561489490);
            ComposerKt.sourceInformation(composer, "157@7004L3,158@7043L3,155@6876L192");
            ErrorDialogComponent component6 = ((MainComponent.DialogChild.ErrorActivity) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -642361461, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue12 = composer.rememberedValue();
            if (rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue12);
            }
            Function0 function07 = (Function0) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -642360213, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue13 = composer.rememberedValue();
            if (rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new Function0() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicDialogsRoutesKt.ClassicErrorDialogFromActivityRoute(component6, function07, (Function0) rememberedValue13, composer, ErrorDialogComponent.$stable | 432, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
