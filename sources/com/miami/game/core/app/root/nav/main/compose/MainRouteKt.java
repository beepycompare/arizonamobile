package com.miami.game.core.app.root.nav.main.compose;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.windowsizeclass.WindowSizeClass;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.extensions.compose.stack.ChildrenKt;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation;
import com.miami.game.core.app.root.MainScaffoldKt;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.compose.NoNetworkErrorDialogKt;
import com.miami.game.feature.download.dialog.ui.error.fromactivity.ErrorDialogFromActivityKt;
import com.miami.game.feature.download.dialog.ui.repair.RepairGameDialogKt;
import com.miami.game.feature.download.dialog.ui.repair.RepairGameErrorKt;
import com.miami.game.feature.download.dialog.ui.repair.RepairGameSuccessKt;
import com.miami.game.feature.download.dialog.ui.setup.SetupDialogKt;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.download.screen.ui.compose.DownloadScreenKt;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.home.ui.compose.HomeScreenKt;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import com.miami.game.feature.notifications.presentation.NotificationsScreentKt;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.select.server.ui.compose.SelectServerScreenKt;
import com.miami.game.feature.settings.ui.SettingsComponent;
import com.miami.game.feature.settings.ui.compose.SettingsScreenKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: MainRoute.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"MainRoute", "", "component", "Lcom/miami/game/core/app/root/nav/main/MainComponent;", "windowSizeClass", "Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Landroidx/compose/material3/windowsizeclass/WindowSizeClass;Landroidx/compose/runtime/Composer;I)V", "Children", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Landroidx/compose/material3/windowsizeclass/WindowSizeClass;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app-root_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MainRouteKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$35(MainComponent mainComponent, WindowSizeClass windowSizeClass, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Children(mainComponent, windowSizeClass, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainRoute$lambda$0(MainComponent mainComponent, WindowSizeClass windowSizeClass, int i, Composer composer, int i2) {
        MainRoute(mainComponent, windowSizeClass, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MainRoute(MainComponent component, WindowSizeClass windowSizeClass, Composer composer, final int i) {
        int i2;
        final MainComponent mainComponent;
        final WindowSizeClass windowSizeClass2;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(windowSizeClass, "windowSizeClass");
        Composer startRestartGroup = composer.startRestartGroup(-990346649);
        ComposerKt.sourceInformation(startRestartGroup, "C(MainRoute)28@1437L89:MainRoute.kt#v8698m");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(windowSizeClass) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            mainComponent = component;
            windowSizeClass2 = windowSizeClass;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-990346649, i2, -1, "com.miami.game.core.app.root.nav.main.compose.MainRoute (MainRoute.kt:26)");
            }
            mainComponent = component;
            windowSizeClass2 = windowSizeClass;
            Children(mainComponent, windowSizeClass2, null, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MainRoute$lambda$0;
                    MainRoute$lambda$0 = MainRouteKt.MainRoute$lambda$0(MainComponent.this, windowSizeClass2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MainRoute$lambda$0;
                }
            });
        }
    }

    private static final void Children(final MainComponent mainComponent, final WindowSizeClass windowSizeClass, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1274878273);
        ComposerKt.sourceInformation(startRestartGroup, "C(Children)P(!1,2)43@1750L4730,40@1675L4805:MainRoute.kt#v8698m");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(mainComponent) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 131) != 130, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1274878273, i3, -1, "com.miami.game.core.app.root.nav.main.compose.Children (MainRoute.kt:39)");
            }
            MainScaffoldKt.MainScaffold(WindowInsetsPadding_androidKt.imePadding(modifier), null, null, null, ComposableLambdaKt.rememberComposableLambda(-254427970, true, new Function3() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Children$lambda$34;
                    Children$lambda$34 = MainRouteKt.Children$lambda$34(MainComponent.this, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Children$lambda$34;
                }
            }, startRestartGroup, 54), startRestartGroup, 24576, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Children$lambda$35;
                    Children$lambda$35 = MainRouteKt.Children$lambda$35(MainComponent.this, windowSizeClass, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return Children$lambda$35;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$34(final MainComponent mainComponent, PaddingValues it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "C48@1881L2310,44@1760L2431,102@4328L2146,98@4201L2273:MainRoute.kt#v8698m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254427970, i, -1, "com.miami.game.core.app.root.nav.main.compose.Children.<anonymous> (MainRoute.kt:44)");
            }
            ChildrenKt.Children(mainComponent.getStack(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(-1130363621, true, new Function3() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Children$lambda$34$lambda$15;
                    Children$lambda$34$lambda$15 = MainRouteKt.Children$lambda$34$lambda$15(MainComponent.this, (Child.Created) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Children$lambda$34$lambda$15;
                }
            }, composer, 54), composer, 3120, 4);
            ChildrenKt.Children(mainComponent.getStackDialog(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(-326115246, true, new Function3() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Children$lambda$34$lambda$33;
                    Children$lambda$34$lambda$33 = MainRouteKt.Children$lambda$34$lambda$33(MainComponent.this, (Child.Created) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Children$lambda$34$lambda$33;
                }
            }, composer, 54), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$34$lambda$15(MainComponent mainComponent, Child.Created it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "C:MainRoute.kt#v8698m");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1130363621, i, -1, "com.miami.game.core.app.root.nav.main.compose.Children.<anonymous>.<anonymous> (MainRoute.kt:49)");
        }
        MainComponent.Child child = (MainComponent.Child) it.getInstance();
        if (child instanceof MainComponent.Child.Home) {
            composer.startReplaceGroup(-2118916536);
            ComposerKt.sourceInformation(composer, "53@2106L29,54@2187L34,55@2274L35,56@2359L32,57@2444L35,58@2536L44,59@2631L39,51@1997L695");
            HomeComponent component = ((MainComponent.Child.Home) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 347293336, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MainRouteKt$Children$1$1$1$1(mainComponent);
                composer.updateRememberedValue(rememberedValue);
            }
            KFunction kFunction = (KFunction) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347295933, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$2$1 rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MainRouteKt$Children$1$1$2$1(mainComponent);
                composer.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction2 = (KFunction) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347298718, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$3$1 rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MainRouteKt$Children$1$1$3$1(mainComponent);
                composer.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction3 = (KFunction) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347301435, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance4 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$4$1 rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MainRouteKt$Children$1$1$4$1(mainComponent);
                composer.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction4 = (KFunction) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347304158, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance5 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$5$1 rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MainRouteKt$Children$1$1$5$1(mainComponent);
                composer.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction5 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347307111, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance6 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$6$1 rememberedValue6 = composer.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MainRouteKt$Children$1$1$6$1(mainComponent);
                composer.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction6 = (KFunction) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347310146, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance7 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$7$1 rememberedValue7 = composer.rememberedValue();
            if (changedInstance7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new MainRouteKt$Children$1$1$7$1(mainComponent);
                composer.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            HomeScreenKt.HomeRoute(component, (Function0) kFunction, (Function0) kFunction2, (Function0) kFunction6, (Function1) kFunction3, (Function0) kFunction5, (Function2) kFunction4, (Function0) ((KFunction) rememberedValue7), composer, HomeComponent.$stable);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.SelectServer) {
            composer.startReplaceGroup(-2118147519);
            ComposerKt.sourceInformation(composer, "66@2900L25,64@2789L158");
            SelectServerComponent component2 = ((MainComponent.Child.SelectServer) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 347318740, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance8 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$8$1 rememberedValue8 = composer.rememberedValue();
            if (changedInstance8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new MainRouteKt$Children$1$1$8$1(mainComponent);
                composer.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SelectServerScreenKt.SelectServerRoute((Function0) ((KFunction) rememberedValue8), component2, composer, SelectServerComponent.$stable << 3);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.Settings) {
            composer.startReplaceGroup(-2117888018);
            ComposerKt.sourceInformation(composer, "73@3146L23,74@3216L35,75@3299L44,76@3389L42,77@3478L37,71@3040L497");
            SettingsComponent component3 = ((MainComponent.Child.Settings) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 347326610, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance9 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$9$1 rememberedValue9 = composer.rememberedValue();
            if (changedInstance9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new MainRouteKt$Children$1$1$9$1(mainComponent);
                composer.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction7 = (KFunction) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347328862, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance10 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$10$1 rememberedValue10 = composer.rememberedValue();
            if (changedInstance10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new MainRouteKt$Children$1$1$10$1(mainComponent);
                composer.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction8 = (KFunction) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347331527, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance11 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$11$1 rememberedValue11 = composer.rememberedValue();
            if (changedInstance11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new MainRouteKt$Children$1$1$11$1(mainComponent);
                composer.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction9 = (KFunction) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347334405, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance12 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$12$1 rememberedValue12 = composer.rememberedValue();
            if (changedInstance12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new MainRouteKt$Children$1$1$12$1(mainComponent);
                composer.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction10 = (KFunction) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 347337248, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance13 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$13$1 rememberedValue13 = composer.rememberedValue();
            if (changedInstance13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new MainRouteKt$Children$1$1$13$1(mainComponent);
                composer.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsScreenKt.SettingsRoute(component3, (Function0) kFunction7, (Function0) kFunction9, (Function0) kFunction10, (Function0) kFunction8, (Function1) ((KFunction) rememberedValue13), composer, SettingsComponent.$stable);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.DownloadScreen) {
            composer.startReplaceGroup(-2117304288);
            ComposerKt.sourceInformation(composer, "82@3636L255");
            DownloadScreenKt.DownloadScreenRoute(((MainComponent.Child.DownloadScreen) child).getComponent(), composer, DownloadScreenComponent.$stable);
            composer.endReplaceGroup();
        } else if (!(child instanceof MainComponent.Child.Notification)) {
            composer.startReplaceGroup(347288841);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(-2116958018);
            ComposerKt.sourceInformation(composer, "92@4102L25,90@3988L161");
            NotificationsComponent component4 = ((MainComponent.Child.Notification) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 347357204, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance14 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$14$1 rememberedValue14 = composer.rememberedValue();
            if (changedInstance14 || rememberedValue14 == Composer.Companion.getEmpty()) {
                rememberedValue14 = new MainRouteKt$Children$1$1$14$1(mainComponent);
                composer.updateRememberedValue(rememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NotificationsScreentKt.NotificationsScreent((Function0) ((KFunction) rememberedValue14), component4, composer, NotificationsComponent.$stable << 3);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$34$lambda$33(MainComponent mainComponent, Child.Created it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "C:MainRoute.kt#v8698m");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-326115246, i, -1, "com.miami.game.core.app.root.nav.main.compose.Children.<anonymous>.<anonymous> (MainRoute.kt:103)");
        }
        MainComponent.DialogChild dialogChild = (MainComponent.DialogChild) it.getInstance();
        if (Intrinsics.areEqual(dialogChild, MainComponent.DialogChild.EMPTY.INSTANCE)) {
            composer.startReplaceGroup(-83170987);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.DownloadCache) {
            composer.startReplaceGroup(-83041841);
            ComposerKt.sourceInformation(composer, "111@4680L29,112@4762L35,109@4571L249");
            CommonDialogComponent component = ((MainComponent.DialogChild.DownloadCache) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 135872495, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MainRouteKt$Children$1$2$1$1(mainComponent);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) rememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 135875125, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$2$1 rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MainRouteKt$Children$1$2$2$1(mainComponent);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SetupDialogKt.SetupDialogRoute(component, function0, (Function0) ((KFunction) rememberedValue2), composer, CommonDialogComponent.$stable);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.RepairGameError) {
            composer.startReplaceGroup(-82691014);
            ComposerKt.sourceInformation(composer, "118@5044L29,119@5111L29,116@4925L238");
            CommonDialogComponent component2 = ((MainComponent.DialogChild.RepairGameError) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 135884143, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$3$1 rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MainRouteKt$Children$1$2$3$1(mainComponent);
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, 135886287, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance4 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$4$1 rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MainRouteKt$Children$1$2$4$1(mainComponent);
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RepairGameErrorKt.RepairGameErrorDialogRoute(component2, function02, (Function0) ((KFunction) rememberedValue4), composer, CommonDialogComponent.$stable);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.RepairGameSuccess) {
            composer.startReplaceGroup(-82348712);
            ComposerKt.sourceInformation(composer, "125@5391L29,126@5458L29,123@5270L240");
            CommonDialogComponent component3 = ((MainComponent.DialogChild.RepairGameSuccess) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 135895247, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance5 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$5$1 rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MainRouteKt$Children$1$2$5$1(mainComponent);
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function03 = (Function0) ((KFunction) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composer, 135897391, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance6 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$6$1 rememberedValue6 = composer.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MainRouteKt$Children$1$2$6$1(mainComponent);
                composer.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RepairGameSuccessKt.RepairGameSuccessDialogRoute(component3, function03, (Function0) ((KFunction) rememberedValue6), composer, CommonDialogComponent.$stable);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.ErrorNoNetwork) {
            composer.startReplaceGroup(-82008890);
            ComposerKt.sourceInformation(composer, "132@5732L2,133@5770L16,130@5614L194");
            ErrorDialogComponent component4 = ((MainComponent.DialogChild.ErrorNoNetwork) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 135906132, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue7 = composer.rememberedValue();
            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda4
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
            ComposerKt.sourceInformationMarkerStart(composer, 135907362, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance7 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$8$1 rememberedValue8 = composer.rememberedValue();
            if (changedInstance7 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new MainRouteKt$Children$1$2$8$1(mainComponent);
                composer.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NoNetworkErrorDialogKt.NoNetworkErrorDialogRoute(component4, function04, (Function0) ((KFunction) rememberedValue8), composer, ErrorDialogComponent.$stable | 48);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.RepairGameDialog) {
            composer.startReplaceGroup(-81707787);
            ComposerKt.sourceInformation(composer, "140@6029L29,141@6096L35,142@6166L2,138@5915L275");
            ErrorDialogComponent component5 = ((MainComponent.DialogChild.RepairGameDialog) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 135915663, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance8 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$9$1 rememberedValue9 = composer.rememberedValue();
            if (changedInstance8 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new MainRouteKt$Children$1$2$9$1(mainComponent);
                composer.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function05 = (Function0) ((KFunction) rememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer, 135917813, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance9 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$10$1 rememberedValue10 = composer.rememberedValue();
            if (changedInstance9 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new MainRouteKt$Children$1$2$10$1(mainComponent);
                composer.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function06 = (Function0) ((KFunction) rememberedValue10);
            ComposerKt.sourceInformationMarkerStart(composer, 135920020, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue11 = composer.rememberedValue();
            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda5
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
            RepairGameDialogKt.RepairGameDialogRoute(component5, function05, function06, (Function0) rememberedValue11, composer, ErrorDialogComponent.$stable | 3072);
            composer.endReplaceGroup();
        } else if (!(dialogChild instanceof MainComponent.DialogChild.ErrorActivity)) {
            composer.startReplaceGroup(135863772);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(-81337027);
            ComposerKt.sourceInformation(composer, "148@6389L3,149@6428L3,147@6293L139");
            ErrorDialogComponent component6 = ((MainComponent.DialogChild.ErrorActivity) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 135927157, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue12 = composer.rememberedValue();
            if (rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda6
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
            ComposerKt.sourceInformationMarkerStart(composer, 135928405, "CC(remember):MainRoute.kt#9igjgp");
            Object rememberedValue13 = composer.rememberedValue();
            if (rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new Function0() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda7
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
            ErrorDialogFromActivityKt.ErrorDialogFromActivityRoute(component6, function07, (Function0) rememberedValue13, composer, ErrorDialogComponent.$stable | 432, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
