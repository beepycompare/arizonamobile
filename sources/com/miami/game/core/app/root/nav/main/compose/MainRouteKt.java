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
import com.arkivanov.decompose.router.stack.ChildStack;
import com.arkivanov.decompose.value.Value;
import com.miami.game.core.app.root.MainScaffoldKt;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
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
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"MainRoute", "", "component", "Lcom/miami/game/core/app/root/nav/main/MainComponent;", "windowSizeClass", "Landroidx/compose/material3/windowsizeclass/WindowSizeClass;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Landroidx/compose/material3/windowsizeclass/WindowSizeClass;Landroidx/compose/runtime/Composer;I)V", "Children", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/miami/game/core/app/root/nav/main/MainComponent;Landroidx/compose/material3/windowsizeclass/WindowSizeClass;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app-root_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MainRouteKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$1(MainComponent mainComponent, WindowSizeClass windowSizeClass, Modifier modifier, int i, int i2, Composer composer, int i3) {
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
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-990346649, i2, -1, "com.miami.game.core.app.root.nav.main.compose.MainRoute (MainRoute.kt:26)");
            }
            mainComponent = component;
            windowSizeClass2 = windowSizeClass;
            Children(mainComponent, windowSizeClass2, null, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            mainComponent = component;
            windowSizeClass2 = windowSizeClass;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda1
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
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
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
        if ((i3 & 131) != 130 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1274878273, i3, -1, "com.miami.game.core.app.root.nav.main.compose.Children (MainRoute.kt:39)");
            }
            MainScaffoldKt.MainScaffold(WindowInsetsPadding_androidKt.imePadding(modifier), null, null, null, ComposableLambdaKt.rememberComposableLambda(-254427970, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                    invoke(paddingValues, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues it, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ComposerKt.sourceInformation(composer2, "C48@1881L2310,44@1760L2431,102@4328L2146,98@4201L2273:MainRoute.kt#v8698m");
                    if ((i5 & 17) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-254427970, i5, -1, "com.miami.game.core.app.root.nav.main.compose.Children.<anonymous> (MainRoute.kt:44)");
                        }
                        Value<ChildStack<?, MainComponent.Child>> stack = MainComponent.this.getStack();
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
                        final MainComponent mainComponent2 = MainComponent.this;
                        ChildrenKt.Children(stack, fillMaxSize$default, (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(-1130363621, true, new Function3<Child.Created<? extends Object, ? extends MainComponent.Child>, Composer, Integer, Unit>() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Child.Created<? extends Object, ? extends MainComponent.Child> created, Composer composer3, Integer num) {
                                invoke(created, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Child.Created<? extends Object, ? extends MainComponent.Child> it2, Composer composer3, int i6) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                ComposerKt.sourceInformation(composer3, "C:MainRoute.kt#v8698m");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1130363621, i6, -1, "com.miami.game.core.app.root.nav.main.compose.Children.<anonymous>.<anonymous> (MainRoute.kt:49)");
                                }
                                MainComponent.Child created = it2.getInstance();
                                if (created instanceof MainComponent.Child.Home) {
                                    composer3.startReplaceGroup(-2118916536);
                                    ComposerKt.sourceInformation(composer3, "53@2106L29,54@2187L34,55@2274L35,56@2359L32,57@2444L35,58@2536L44,59@2631L39,51@1997L695");
                                    HomeComponent component = ((MainComponent.Child.Home) created).getComponent();
                                    MainComponent mainComponent3 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance = composer3.changedInstance(mainComponent3);
                                    MainRouteKt$Children$1$1$1$1 rememberedValue = composer3.rememberedValue();
                                    if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new MainRouteKt$Children$1$1$1$1(mainComponent3);
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    KFunction kFunction = (KFunction) rememberedValue;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent4 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance2 = composer3.changedInstance(mainComponent4);
                                    MainRouteKt$Children$1$1$2$1 rememberedValue2 = composer3.rememberedValue();
                                    if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new MainRouteKt$Children$1$1$2$1(mainComponent4);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    KFunction kFunction2 = (KFunction) rememberedValue2;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent5 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance3 = composer3.changedInstance(mainComponent5);
                                    MainRouteKt$Children$1$1$3$1 rememberedValue3 = composer3.rememberedValue();
                                    if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = new MainRouteKt$Children$1$1$3$1(mainComponent5);
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    KFunction kFunction3 = (KFunction) rememberedValue3;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent6 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance4 = composer3.changedInstance(mainComponent6);
                                    MainRouteKt$Children$1$1$4$1 rememberedValue4 = composer3.rememberedValue();
                                    if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                        rememberedValue4 = new MainRouteKt$Children$1$1$4$1(mainComponent6);
                                        composer3.updateRememberedValue(rememberedValue4);
                                    }
                                    KFunction kFunction4 = (KFunction) rememberedValue4;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent7 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance5 = composer3.changedInstance(mainComponent7);
                                    MainRouteKt$Children$1$1$5$1 rememberedValue5 = composer3.rememberedValue();
                                    if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                        rememberedValue5 = new MainRouteKt$Children$1$1$5$1(mainComponent7);
                                        composer3.updateRememberedValue(rememberedValue5);
                                    }
                                    KFunction kFunction5 = (KFunction) rememberedValue5;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent8 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance6 = composer3.changedInstance(mainComponent8);
                                    MainRouteKt$Children$1$1$6$1 rememberedValue6 = composer3.rememberedValue();
                                    if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                        rememberedValue6 = new MainRouteKt$Children$1$1$6$1(mainComponent8);
                                        composer3.updateRememberedValue(rememberedValue6);
                                    }
                                    KFunction kFunction6 = (KFunction) rememberedValue6;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent9 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance7 = composer3.changedInstance(mainComponent9);
                                    MainRouteKt$Children$1$1$7$1 rememberedValue7 = composer3.rememberedValue();
                                    if (changedInstance7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                        rememberedValue7 = new MainRouteKt$Children$1$1$7$1(mainComponent9);
                                        composer3.updateRememberedValue(rememberedValue7);
                                    }
                                    composer3.endReplaceGroup();
                                    HomeScreenKt.HomeRoute(component, (Function0) kFunction, (Function0) kFunction2, (Function0) kFunction6, (Function1) kFunction3, (Function0) kFunction5, (Function2) kFunction4, (Function0) ((KFunction) rememberedValue7), composer3, HomeComponent.$stable);
                                    composer3.endReplaceGroup();
                                } else if (created instanceof MainComponent.Child.SelectServer) {
                                    composer3.startReplaceGroup(-2118147519);
                                    ComposerKt.sourceInformation(composer3, "66@2900L25,64@2789L158");
                                    SelectServerComponent component2 = ((MainComponent.Child.SelectServer) created).getComponent();
                                    MainComponent mainComponent10 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance8 = composer3.changedInstance(mainComponent10);
                                    MainRouteKt$Children$1$1$8$1 rememberedValue8 = composer3.rememberedValue();
                                    if (changedInstance8 || rememberedValue8 == Composer.Companion.getEmpty()) {
                                        rememberedValue8 = new MainRouteKt$Children$1$1$8$1(mainComponent10);
                                        composer3.updateRememberedValue(rememberedValue8);
                                    }
                                    composer3.endReplaceGroup();
                                    SelectServerScreenKt.SelectServerRoute((Function0) ((KFunction) rememberedValue8), component2, composer3, SelectServerComponent.$stable << 3);
                                    composer3.endReplaceGroup();
                                } else if (created instanceof MainComponent.Child.Settings) {
                                    composer3.startReplaceGroup(-2117888018);
                                    ComposerKt.sourceInformation(composer3, "73@3146L23,74@3216L35,75@3299L44,76@3389L42,77@3478L37,71@3040L497");
                                    SettingsComponent component3 = ((MainComponent.Child.Settings) created).getComponent();
                                    MainComponent mainComponent11 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance9 = composer3.changedInstance(mainComponent11);
                                    MainRouteKt$Children$1$1$9$1 rememberedValue9 = composer3.rememberedValue();
                                    if (changedInstance9 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                        rememberedValue9 = new MainRouteKt$Children$1$1$9$1(mainComponent11);
                                        composer3.updateRememberedValue(rememberedValue9);
                                    }
                                    KFunction kFunction7 = (KFunction) rememberedValue9;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent12 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance10 = composer3.changedInstance(mainComponent12);
                                    MainRouteKt$Children$1$1$10$1 rememberedValue10 = composer3.rememberedValue();
                                    if (changedInstance10 || rememberedValue10 == Composer.Companion.getEmpty()) {
                                        rememberedValue10 = new MainRouteKt$Children$1$1$10$1(mainComponent12);
                                        composer3.updateRememberedValue(rememberedValue10);
                                    }
                                    KFunction kFunction8 = (KFunction) rememberedValue10;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent13 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance11 = composer3.changedInstance(mainComponent13);
                                    MainRouteKt$Children$1$1$11$1 rememberedValue11 = composer3.rememberedValue();
                                    if (changedInstance11 || rememberedValue11 == Composer.Companion.getEmpty()) {
                                        rememberedValue11 = new MainRouteKt$Children$1$1$11$1(mainComponent13);
                                        composer3.updateRememberedValue(rememberedValue11);
                                    }
                                    KFunction kFunction9 = (KFunction) rememberedValue11;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent14 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance12 = composer3.changedInstance(mainComponent14);
                                    MainRouteKt$Children$1$1$12$1 rememberedValue12 = composer3.rememberedValue();
                                    if (changedInstance12 || rememberedValue12 == Composer.Companion.getEmpty()) {
                                        rememberedValue12 = new MainRouteKt$Children$1$1$12$1(mainComponent14);
                                        composer3.updateRememberedValue(rememberedValue12);
                                    }
                                    KFunction kFunction10 = (KFunction) rememberedValue12;
                                    composer3.endReplaceGroup();
                                    MainComponent mainComponent15 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance13 = composer3.changedInstance(mainComponent15);
                                    MainRouteKt$Children$1$1$13$1 rememberedValue13 = composer3.rememberedValue();
                                    if (changedInstance13 || rememberedValue13 == Composer.Companion.getEmpty()) {
                                        rememberedValue13 = new MainRouteKt$Children$1$1$13$1(mainComponent15);
                                        composer3.updateRememberedValue(rememberedValue13);
                                    }
                                    composer3.endReplaceGroup();
                                    SettingsScreenKt.SettingsRoute(component3, (Function0) kFunction7, (Function0) kFunction9, (Function0) kFunction10, (Function0) kFunction8, (Function1) ((KFunction) rememberedValue13), composer3, SettingsComponent.$stable);
                                    composer3.endReplaceGroup();
                                } else if (created instanceof MainComponent.Child.DownloadScreen) {
                                    composer3.startReplaceGroup(-2117304288);
                                    ComposerKt.sourceInformation(composer3, "82@3636L255");
                                    DownloadScreenKt.DownloadScreenRoute(((MainComponent.Child.DownloadScreen) created).getComponent(), composer3, DownloadScreenComponent.$stable);
                                    composer3.endReplaceGroup();
                                } else if (!(created instanceof MainComponent.Child.Notification)) {
                                    composer3.startReplaceGroup(347288841);
                                    composer3.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    composer3.startReplaceGroup(-2116958018);
                                    ComposerKt.sourceInformation(composer3, "92@4102L25,90@3988L161");
                                    NotificationsComponent component4 = ((MainComponent.Child.Notification) created).getComponent();
                                    MainComponent mainComponent16 = MainComponent.this;
                                    composer3.startReplaceGroup(5004770);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):MainRoute.kt#9igjgp");
                                    boolean changedInstance14 = composer3.changedInstance(mainComponent16);
                                    MainRouteKt$Children$1$1$14$1 rememberedValue14 = composer3.rememberedValue();
                                    if (changedInstance14 || rememberedValue14 == Composer.Companion.getEmpty()) {
                                        rememberedValue14 = new MainRouteKt$Children$1$1$14$1(mainComponent16);
                                        composer3.updateRememberedValue(rememberedValue14);
                                    }
                                    composer3.endReplaceGroup();
                                    NotificationsScreentKt.NotificationsScreent((Function0) ((KFunction) rememberedValue14), component4, composer3, NotificationsComponent.$stable << 3);
                                    composer3.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 3120, 4);
                        ChildrenKt.Children(MainComponent.this.getStackDialog(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (StackAnimation) null, ComposableLambdaKt.rememberComposableLambda(-326115246, true, new AnonymousClass2(MainComponent.this), composer2, 54), composer2, 3120, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: MainRoute.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1$2  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass2 implements Function3<Child.Created<? extends Object, ? extends MainComponent.DialogChild>, Composer, Integer, Unit> {
                    final /* synthetic */ MainComponent $component;

                    AnonymousClass2(MainComponent mainComponent) {
                        this.$component = mainComponent;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Child.Created<? extends Object, ? extends MainComponent.DialogChild> created, Composer composer, Integer num) {
                        invoke(created, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Child.Created<? extends Object, ? extends MainComponent.DialogChild> it, Composer composer, int i) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ComposerKt.sourceInformation(composer, "C:MainRoute.kt#v8698m");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-326115246, i, -1, "com.miami.game.core.app.root.nav.main.compose.Children.<anonymous>.<anonymous> (MainRoute.kt:103)");
                        }
                        MainComponent.DialogChild created = it.getInstance();
                        if (Intrinsics.areEqual(created, MainComponent.DialogChild.EMPTY.INSTANCE)) {
                            composer.startReplaceGroup(-83170987);
                            composer.endReplaceGroup();
                        } else if (created instanceof MainComponent.DialogChild.DownloadCache) {
                            composer.startReplaceGroup(-83041841);
                            ComposerKt.sourceInformation(composer, "111@4680L29,112@4762L35,109@4571L249");
                            CommonDialogComponent component = ((MainComponent.DialogChild.DownloadCache) created).getComponent();
                            MainComponent mainComponent = this.$component;
                            composer.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            boolean changedInstance = composer.changedInstance(mainComponent);
                            MainRouteKt$Children$1$2$1$1 rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new MainRouteKt$Children$1$2$1$1(mainComponent);
                                composer.updateRememberedValue(rememberedValue);
                            }
                            composer.endReplaceGroup();
                            Function0 function0 = (Function0) ((KFunction) rememberedValue);
                            MainComponent mainComponent2 = this.$component;
                            composer.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            boolean changedInstance2 = composer.changedInstance(mainComponent2);
                            MainRouteKt$Children$1$2$2$1 rememberedValue2 = composer.rememberedValue();
                            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new MainRouteKt$Children$1$2$2$1(mainComponent2);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            composer.endReplaceGroup();
                            SetupDialogKt.SetupDialogRoute(component, function0, (Function0) ((KFunction) rememberedValue2), composer, CommonDialogComponent.$stable);
                            composer.endReplaceGroup();
                        } else if (created instanceof MainComponent.DialogChild.RepairGameError) {
                            composer.startReplaceGroup(-82691014);
                            ComposerKt.sourceInformation(composer, "118@5044L29,119@5111L29,116@4925L238");
                            CommonDialogComponent component2 = ((MainComponent.DialogChild.RepairGameError) created).getComponent();
                            MainComponent mainComponent3 = this.$component;
                            composer.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            boolean changedInstance3 = composer.changedInstance(mainComponent3);
                            MainRouteKt$Children$1$2$3$1 rememberedValue3 = composer.rememberedValue();
                            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new MainRouteKt$Children$1$2$3$1(mainComponent3);
                                composer.updateRememberedValue(rememberedValue3);
                            }
                            composer.endReplaceGroup();
                            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
                            MainComponent mainComponent4 = this.$component;
                            composer.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            boolean changedInstance4 = composer.changedInstance(mainComponent4);
                            MainRouteKt$Children$1$2$4$1 rememberedValue4 = composer.rememberedValue();
                            if (changedInstance4 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new MainRouteKt$Children$1$2$4$1(mainComponent4);
                                composer.updateRememberedValue(rememberedValue4);
                            }
                            composer.endReplaceGroup();
                            RepairGameErrorKt.RepairGameErrorDialogRoute(component2, function02, (Function0) ((KFunction) rememberedValue4), composer, CommonDialogComponent.$stable);
                            composer.endReplaceGroup();
                        } else if (created instanceof MainComponent.DialogChild.RepairGameSuccess) {
                            composer.startReplaceGroup(-82348712);
                            ComposerKt.sourceInformation(composer, "125@5391L29,126@5458L29,123@5270L240");
                            CommonDialogComponent component3 = ((MainComponent.DialogChild.RepairGameSuccess) created).getComponent();
                            MainComponent mainComponent5 = this.$component;
                            composer.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            boolean changedInstance5 = composer.changedInstance(mainComponent5);
                            MainRouteKt$Children$1$2$5$1 rememberedValue5 = composer.rememberedValue();
                            if (changedInstance5 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = new MainRouteKt$Children$1$2$5$1(mainComponent5);
                                composer.updateRememberedValue(rememberedValue5);
                            }
                            composer.endReplaceGroup();
                            Function0 function03 = (Function0) ((KFunction) rememberedValue5);
                            MainComponent mainComponent6 = this.$component;
                            composer.startReplaceGroup(5004770);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            boolean changedInstance6 = composer.changedInstance(mainComponent6);
                            MainRouteKt$Children$1$2$6$1 rememberedValue6 = composer.rememberedValue();
                            if (changedInstance6 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new MainRouteKt$Children$1$2$6$1(mainComponent6);
                                composer.updateRememberedValue(rememberedValue6);
                            }
                            composer.endReplaceGroup();
                            RepairGameSuccessKt.RepairGameSuccessDialogRoute(component3, function03, (Function0) ((KFunction) rememberedValue6), composer, CommonDialogComponent.$stable);
                            composer.endReplaceGroup();
                        } else if (created instanceof MainComponent.DialogChild.ErrorNoNetwork) {
                            composer.startReplaceGroup(-82008890);
                            ComposerKt.sourceInformation(composer, "132@5732L2,133@5770L16,130@5614L194");
                            ErrorDialogComponent component4 = ((MainComponent.DialogChild.ErrorNoNetwork) created).getComponent();
                            composer.startReplaceGroup(1849434622);
                            ComposerKt.sourceInformation(composer, "CC(remember):MainRoute.kt#9igjgp");
                            Object rememberedValue7 = composer.rememberedValue();
                            if (rememberedValue7 == Composer.Companion.getEmpty()) {
                                rememberedValue7 = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01c8: CONSTRUCTOR  (r1v24 'rememberedValue7' java.lang.Object) =  call: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1$2$$ExternalSyntheticLambda0.<init>():void type: CONSTRUCTOR in method: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1.2.invoke(com.arkivanov.decompose.Child$Created<? extends java.lang.Object, ? extends com.miami.game.core.app.root.nav.main.MainComponent$DialogChild>, androidx.compose.runtime.Composer, int):void, file: classes4.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                    	... 35 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 798
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$Children$1.AnonymousClass2.invoke(com.arkivanov.decompose.Child$Created, androidx.compose.runtime.Composer, int):void");
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, 24576, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
                final Modifier modifier2 = modifier;
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.app.root.nav.main.compose.MainRouteKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit Children$lambda$1;
                            Children$lambda$1 = MainRouteKt.Children$lambda$1(MainComponent.this, windowSizeClass, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return Children$lambda$1;
                        }
                    });
                }
            }
        }
