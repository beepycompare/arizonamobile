package com.miami.game.ui.app.root;

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
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"MainRoute", "", "component", "Lcom/miami/game/core/app/root/nav/main/MainComponent;", "windowSizeClass", "Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Landroidx/compose/material3/windowsizeclass/WindowSizeClass;Landroidx/compose/runtime/Composer;I)V", "Children", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Landroidx/compose/material3/windowsizeclass/WindowSizeClass;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app-root"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainRouteKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Children$lambda$1(MainComponent mainComponent, WindowSizeClass windowSizeClass, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Children(mainComponent, windowSizeClass, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        Composer startRestartGroup = composer.startRestartGroup(603460620);
        ComposerKt.sourceInformation(startRestartGroup, "C(MainRoute)N(component,windowSizeClass)27@1342L89:MainRoute.kt#bpdw87");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(603460620, i2, -1, "com.miami.game.ui.app.root.MainRoute (MainRoute.kt:26)");
            }
            mainComponent = component;
            windowSizeClass2 = windowSizeClass;
            Children(mainComponent, windowSizeClass2, null, startRestartGroup, MainComponent.$stable | (i2 & 14) | (i2 & 112), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainRouteKt.MainRoute$lambda$0(MainComponent.this, windowSizeClass2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Children(final MainComponent mainComponent, final WindowSizeClass windowSizeClass, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1895037070);
        ComposerKt.sourceInformation(startRestartGroup, "C(Children)N(component,windowSizeClass,modifier)42@1655L4653,39@1580L4728:MainRoute.kt#bpdw87");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(mainComponent) : startRestartGroup.changedInstance(mainComponent) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(-1895037070, i3, -1, "com.miami.game.ui.app.root.Children (MainRoute.kt:38)");
            }
            MainScaffoldKt.MainScaffold(WindowInsetsPadding_androidKt.imePadding(modifier), null, null, null, ComposableLambdaKt.rememberComposableLambda(1815020309, true, new Function3() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainRouteKt.Children$lambda$0(MainComponent.this, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, startRestartGroup, 54), startRestartGroup, 24576, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainRouteKt.Children$lambda$1(MainComponent.this, windowSizeClass, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Children$lambda$0(final MainComponent mainComponent, PaddingValues it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)47@1786L2183,43@1665L2304,99@4106L2196,95@3979L2323:MainRoute.kt#bpdw87");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1815020309, i, -1, "com.miami.game.ui.app.root.Children.<anonymous> (MainRoute.kt:43)");
            }
            ChildrenKt.Children(mainComponent.getStack(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(1864353240, true, new Function3() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Children$lambda$0$0;
                    Children$lambda$0$0 = MainRouteKt.Children$lambda$0$0(MainComponent.this, (Child.Created) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Children$lambda$0$0;
                }
            }, composer, 54), composer, 3120, 4);
            ChildrenKt.Children(mainComponent.getStackDialog(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(160235521, true, new Function3() { // from class: com.miami.game.ui.app.root.MainRouteKt$$ExternalSyntheticLambda8
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
    public static final Unit Children$lambda$0$0(MainComponent mainComponent, Child.Created it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):MainRoute.kt#bpdw87");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1864353240, i, -1, "com.miami.game.ui.app.root.Children.<anonymous>.<anonymous> (MainRoute.kt:48)");
        }
        MainComponent.Child child = (MainComponent.Child) it.getInstance();
        if (child instanceof MainComponent.Child.Home) {
            composer.startReplaceGroup(-1569562196);
            ComposerKt.sourceInformation(composer, "52@2018L29,53@2099L34,54@2186L35,55@2271L32,56@2356L35,57@2448L44,58@2543L39,50@1902L702");
            HomeComponent component = ((MainComponent.Child.Home) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 642108661, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MainRouteKt$Children$1$1$1$1(mainComponent);
                composer.updateRememberedValue(rememberedValue);
            }
            KFunction kFunction = (KFunction) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642111258, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$2$1 rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new MainRouteKt$Children$1$1$2$1(mainComponent);
                composer.updateRememberedValue(rememberedValue2);
            }
            KFunction kFunction2 = (KFunction) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642114043, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$3$1 rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MainRouteKt$Children$1$1$3$1(mainComponent);
                composer.updateRememberedValue(rememberedValue3);
            }
            KFunction kFunction3 = (KFunction) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642116760, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance4 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$4$1 rememberedValue4 = composer.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new MainRouteKt$Children$1$1$4$1(mainComponent);
                composer.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction4 = (KFunction) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642119483, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance5 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$5$1 rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MainRouteKt$Children$1$1$5$1(mainComponent);
                composer.updateRememberedValue(rememberedValue5);
            }
            KFunction kFunction5 = (KFunction) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642122436, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance6 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$6$1 rememberedValue6 = composer.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new MainRouteKt$Children$1$1$6$1(mainComponent);
                composer.updateRememberedValue(rememberedValue6);
            }
            KFunction kFunction6 = (KFunction) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642125471, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(-1568786235);
            ComposerKt.sourceInformation(composer, "65@2819L25,63@2701L165");
            SelectServerComponent component2 = ((MainComponent.Child.SelectServer) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 642134289, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(-1568519790);
            ComposerKt.sourceInformation(composer, "72@3072L23,73@3142L35,74@3225L44,75@3315L42,76@3404L37,70@2959L504");
            SettingsComponent component3 = ((MainComponent.Child.Settings) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 642142383, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance9 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$9$1 rememberedValue9 = composer.rememberedValue();
            if (changedInstance9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new MainRouteKt$Children$1$1$9$1(mainComponent);
                composer.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction7 = (KFunction) rememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642144635, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance10 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$10$1 rememberedValue10 = composer.rememberedValue();
            if (changedInstance10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new MainRouteKt$Children$1$1$10$1(mainComponent);
                composer.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction8 = (KFunction) rememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642147300, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance11 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$11$1 rememberedValue11 = composer.rememberedValue();
            if (changedInstance11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new MainRouteKt$Children$1$1$11$1(mainComponent);
                composer.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction9 = (KFunction) rememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642150178, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance12 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$12$1 rememberedValue12 = composer.rememberedValue();
            if (changedInstance12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new MainRouteKt$Children$1$1$12$1(mainComponent);
                composer.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction10 = (KFunction) rememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 642153021, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance13 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$1$13$1 rememberedValue13 = composer.rememberedValue();
            if (changedInstance13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                rememberedValue13 = new MainRouteKt$Children$1$1$13$1(mainComponent);
                composer.updateRememberedValue(rememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ClassicSettingsRouteKt.ClassicSettingsRoute(component3, (Function0) kFunction7, (Function0) kFunction9, (Function0) kFunction10, (Function0) kFunction8, (Function1) ((KFunction) rememberedValue13), composer, SettingsComponent.$stable);
            composer.endReplaceGroup();
        } else if (child instanceof MainComponent.Child.DownloadScreen) {
            composer.startReplaceGroup(-1567954660);
            ComposerKt.sourceInformation(composer, "81@3562L102");
            ClassicDownloadScreenRouteKt.ClassicDownloadScreenRoute(((MainComponent.Child.DownloadScreen) child).getComponent(), composer, DownloadScreenComponent.$stable);
            composer.endReplaceGroup();
        } else if (!(child instanceof MainComponent.Child.Notification)) {
            composer.startReplaceGroup(642103815);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(-1567734684);
            ComposerKt.sourceInformation(composer, "89@3880L25,87@3761L166");
            NotificationsComponent component4 = ((MainComponent.Child.Notification) child).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, 642168241, "CC(remember):MainRoute.kt#9igjgp");
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
            ComposerKt.traceEventStart(160235521, i, -1, "com.miami.game.ui.app.root.Children.<anonymous>.<anonymous> (MainRoute.kt:100)");
        }
        MainComponent.DialogChild dialogChild = (MainComponent.DialogChild) it.getInstance();
        if (Intrinsics.areEqual(dialogChild, MainComponent.DialogChild.EMPTY.INSTANCE)) {
            composer.startReplaceGroup(1867838062);
            composer.endReplaceGroup();
        } else if (dialogChild instanceof MainComponent.DialogChild.DownloadCache) {
            composer.startReplaceGroup(1867928985);
            ComposerKt.sourceInformation(composer, "107@4425L29,108@4507L35,105@4309L256");
            CommonDialogComponent component = ((MainComponent.DialogChild.DownloadCache) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -632476738, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$1$1 rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MainRouteKt$Children$1$2$1$1(mainComponent);
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) rememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -632474108, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(1868286756);
            ComposerKt.sourceInformation(composer, "114@4796L29,115@4863L29,112@4670L245");
            CommonDialogComponent component2 = ((MainComponent.DialogChild.RepairGameError) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -632464866, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance3 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$3$1 rememberedValue3 = composer.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new MainRouteKt$Children$1$2$3$1(mainComponent);
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, -632462722, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(1868636002);
            ComposerKt.sourceInformation(composer, "121@5150L29,122@5217L29,119@5022L247");
            CommonDialogComponent component3 = ((MainComponent.DialogChild.RepairGameSuccess) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -632453538, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance5 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$5$1 rememberedValue5 = composer.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MainRouteKt$Children$1$2$5$1(mainComponent);
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function03 = (Function0) ((KFunction) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composer, -632451394, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(1868982768);
            ComposerKt.sourceInformation(composer, "128@5498L2,129@5536L16,126@5373L201");
            ErrorDialogComponent component4 = ((MainComponent.DialogChild.ErrorNoNetwork) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -632442429, "CC(remember):MainRoute.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composer, -632441199, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(1869290846);
            ComposerKt.sourceInformation(composer, "136@5802L29,137@5869L35,138@5940L2,134@5681L283");
            ErrorDialogComponent component5 = ((MainComponent.DialogChild.RepairGameDialog) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -632432674, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance8 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$9$1 rememberedValue9 = composer.rememberedValue();
            if (changedInstance8 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new MainRouteKt$Children$1$2$9$1(mainComponent);
                composer.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function05 = (Function0) ((KFunction) rememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer, -632430524, "CC(remember):MainRoute.kt#9igjgp");
            boolean changedInstance9 = composer.changedInstance(mainComponent);
            MainRouteKt$Children$1$2$10$1 rememberedValue10 = composer.rememberedValue();
            if (changedInstance9 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new MainRouteKt$Children$1$2$10$1(mainComponent);
                composer.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function06 = (Function0) ((KFunction) rememberedValue10);
            ComposerKt.sourceInformationMarkerStart(composer, -632428285, "CC(remember):MainRoute.kt#9igjgp");
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
            composer.startReplaceGroup(-632484355);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        } else {
            composer.startReplaceGroup(1869671929);
            ComposerKt.sourceInformation(composer, "145@6196L3,146@6235L3,143@6068L192");
            ErrorDialogComponent component6 = ((MainComponent.DialogChild.ErrorActivity) dialogChild).getComponent();
            ComposerKt.sourceInformationMarkerStart(composer, -632420092, "CC(remember):MainRoute.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composer, -632418844, "CC(remember):MainRoute.kt#9igjgp");
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
