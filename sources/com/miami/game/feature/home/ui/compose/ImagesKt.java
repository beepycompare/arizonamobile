package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Images.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\r\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u001a"}, d2 = {"BackgroundImage", "", "id", "", "(ILandroidx/compose/runtime/Composer;I)V", "SettingsImage", "(Landroidx/compose/runtime/Composer;I)V", "PlayImage", "isCheckingFiles", "", "(ZLandroidx/compose/runtime/Composer;I)V", "UpdateImage", "SetupImage", "ForumImage", "NotificationsImage", "notificationState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)V", "AccountImage", "ShopImage", "xdonate", "isArizona", "(IZLandroidx/compose/runtime/Composer;I)V", "DiscordImage", "TelegramImage", "VkImage", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImagesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountImage$lambda$12(int i, Composer composer, int i2) {
        AccountImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundImage$lambda$0(int i, int i2, Composer composer, int i3) {
        BackgroundImage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DiscordImage$lambda$16(int i, Composer composer, int i2) {
        DiscordImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForumImage$lambda$8(int i, Composer composer, int i2) {
        ForumImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationsImage$lambda$11(State state, int i, Composer composer, int i2) {
        NotificationsImage(state, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlayImage$lambda$3(boolean z, int i, Composer composer, int i2) {
        PlayImage(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsImage$lambda$1(int i, Composer composer, int i2) {
        SettingsImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetupImage$lambda$7(int i, Composer composer, int i2) {
        SetupImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShopImage$lambda$15(int i, boolean z, int i2, Composer composer, int i3) {
        ShopImage(i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TelegramImage$lambda$17(int i, Composer composer, int i2) {
        TelegramImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpdateImage$lambda$5(int i, Composer composer, int i2) {
        UpdateImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VkImage$lambda$18(int i, Composer composer, int i2) {
        VkImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BackgroundImage(final int i, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-619260793);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)28@1057L46,26@989L198:Images.kt#dswm0d");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619260793, i3, -1, "com.miami.game.feature.home.ui.compose.BackgroundImage (Images.kt:25)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, i3 & 14), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackgroundImage$lambda$0;
                    BackgroundImage$lambda$0 = ImagesKt.BackgroundImage$lambda$0(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return BackgroundImage$lambda$0;
                }
            });
        }
    }

    public static final void SettingsImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-385149265);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsImage)41@1317L104,38@1238L267:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385149265, i, -1, "com.miami.game.feature.home.ui.compose.SettingsImage (Images.kt:37)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_setting, startRestartGroup, 0), (String) null, SizeKt.m785size3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(24)), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsImage$lambda$1;
                    SettingsImage$lambda$1 = ImagesKt.SettingsImage$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsImage$lambda$1;
                }
            });
        }
    }

    public static final void PlayImage(final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1050683340);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlayImage)51@1576L427:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1050683340, i2, -1, "com.miami.game.feature.home.ui.compose.PlayImage (Images.kt:50)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -598791714, "C57@1892L55,54@1790L207:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(z ? R.drawable.ic_play_home_screen_inactive : R.drawable.ic_play_home_screen, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PlayImage$lambda$3;
                    PlayImage$lambda$3 = ImagesKt.PlayImage$lambda$3(z, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PlayImage$lambda$3;
                }
            });
        }
    }

    public static final void UpdateImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1202479543);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdateImage)67@2052L253:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1202479543, i, -1, "com.miami.game.feature.home.ui.compose.UpdateImage (Images.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -179924533, "C71@2168L81,68@2066L233:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.update_home_screen, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpdateImage$lambda$5;
                    UpdateImage$lambda$5 = ImagesKt.UpdateImage$lambda$5(i, (Composer) obj, ((Integer) obj2).intValue());
                    return UpdateImage$lambda$5;
                }
            });
        }
    }

    public static final void SetupImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-371068495);
        ComposerKt.sourceInformation(startRestartGroup, "C(SetupImage)81@2353L285:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-371068495, i, -1, "com.miami.game.feature.home.ui.compose.SetupImage (Images.kt:80)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1934356849, "C85@2469L113,82@2367L265:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.setup_image, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetupImage$lambda$7;
                    SetupImage$lambda$7 = ImagesKt.SetupImage$lambda$7(i, (Composer) obj, ((Integer) obj2).intValue());
                    return SetupImage$lambda$7;
                }
            });
        }
    }

    public static final void ForumImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1452948083);
        ComposerKt.sourceInformation(startRestartGroup, "C(ForumImage)98@2776L64,95@2686L244:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1452948083, i, -1, "com.miami.game.feature.home.ui.compose.ForumImage (Images.kt:94)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_forum, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(54)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ForumImage$lambda$8;
                    ForumImage$lambda$8 = ImagesKt.ForumImage$lambda$8(i, (Composer) obj, ((Integer) obj2).intValue());
                    return ForumImage$lambda$8;
                }
            });
        }
    }

    public static final void NotificationsImage(final State<Integer> notificationState, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(notificationState, "notificationState");
        Composer startRestartGroup = composer.startRestartGroup(772996739);
        ComposerKt.sourceInformation(startRestartGroup, "C(NotificationsImage)108@3016L1298:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(notificationState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(772996739, i2, -1, "com.miami.game.feature.home.ui.compose.NotificationsImage (Images.kt:107)");
            }
            float f = 10;
            Modifier m698offsetVpY3zN4$default = OffsetKt.m698offsetVpY3zN4$default(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(44)), Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f)), 0.0f, 2, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m698offsetVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 80033659, "C115@3258L79,112@3156L283:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_notification, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(32)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (notificationState.getValue().intValue() <= 0) {
                startRestartGroup.startReplaceGroup(76866233);
            } else {
                startRestartGroup.startReplaceGroup(80346944);
                ComposerKt.sourceInformation(startRestartGroup, "123@3496L801");
                float f2 = 12;
                Modifier m697offsetVpY3zN4 = OffsetKt.m697offsetVpY3zN4(SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(14)), Dp.m6684constructorimpl(f2), Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f2)));
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m697offsetVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1132758621, "C130@3754L101,129@3717L264,139@4165L13,140@4211L13,136@3998L285:Images.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_notification_count, startRestartGroup, 0), (String) null, (Modifier) null, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 24624, 108);
                String valueOf = String.valueOf(notificationState.getValue().intValue());
                Modifier.Companion companion = Modifier.Companion;
                TextKt.m2497Text4IGK_g(valueOf, (Modifier) companion, Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f), startRestartGroup, 6), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, startRestartGroup, 432, 0, 130032);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotificationsImage$lambda$11;
                    NotificationsImage$lambda$11 = ImagesKt.NotificationsImage$lambda$11(State.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotificationsImage$lambda$11;
                }
            });
        }
    }

    public static final void AccountImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(307092609);
        ComposerKt.sourceInformation(startRestartGroup, "C(AccountImage)155@4455L66,152@4365L246:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307092609, i, -1, "com.miami.game.feature.home.ui.compose.AccountImage (Images.kt:151)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_account, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(54)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountImage$lambda$12;
                    AccountImage$lambda$12 = ImagesKt.AccountImage$lambda$12(i, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountImage$lambda$12;
                }
            });
        }
    }

    public static final void ShopImage(final int i, final boolean z, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(601068787);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopImage)P(1)165@4690L1248:Images.kt#dswm0d");
        if ((i2 & 6) == 0) {
            i3 = i2 | (startRestartGroup.changed(i) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(601068787, i3, -1, "com.miami.game.feature.home.ui.compose.ShopImage (Images.kt:164)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -541691606, "C169@4797L113,166@4704L256:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_btn_shop, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(72)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
            if ((i <= 2 || z) && (i <= 3 || !z)) {
                startRestartGroup.startReplaceGroup(-546397035);
            } else {
                startRestartGroup.startReplaceGroup(-541378321);
                ComposerKt.sourceInformation(startRestartGroup, "175@5044L878");
                float f = 6;
                Modifier align = boxScopeInstance.align(OffsetKt.m697offsetVpY3zN4(Modifier.Companion, Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f)), Dp.m6684constructorimpl(-Dp.m6684constructorimpl(f))), Alignment.Companion.getTopEnd());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -493011394, "C181@5328L100,178@5211L283,189@5674L13,190@5720L13,193@5868L10,186@5511L397:Images.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.shop_notificaiotns_bg, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(20)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 432, (int) MenuKt.InTransitionDuration);
                float f2 = 12;
                TextKt.m2497Text4IGK_g("АКЦИЯ Х" + i + " ДОНАТ", (Modifier) Modifier.Companion, Color.Companion.m4115getWhite0d7_KjU(), TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f2), startRestartGroup, 6), (FontStyle) null, FontWeight.Companion.getW900(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TypeKt.m8428dpToSp8Feqmps(Dp.m6684constructorimpl(f2), startRestartGroup, 6), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium(), startRestartGroup, 197040, 0, 64464);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShopImage$lambda$15;
                    ShopImage$lambda$15 = ImagesKt.ShopImage$lambda$15(i, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return ShopImage$lambda$15;
                }
            });
        }
    }

    public static final void DiscordImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1376889058);
        ComposerKt.sourceInformation(startRestartGroup, "C(DiscordImage)205@6078L66,202@5988L246:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1376889058, i, -1, "com.miami.game.feature.home.ui.compose.DiscordImage (Images.kt:201)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_discord, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(54)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DiscordImage$lambda$16;
                    DiscordImage$lambda$16 = ImagesKt.DiscordImage$lambda$16(i, (Composer) obj, ((Integer) obj2).intValue());
                    return DiscordImage$lambda$16;
                }
            });
        }
    }

    public static final void TelegramImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1835780975);
        ComposerKt.sourceInformation(startRestartGroup, "C(TelegramImage)218@6375L67,215@6285L247:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835780975, i, -1, "com.miami.game.feature.home.ui.compose.TelegramImage (Images.kt:214)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_telegram, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(54)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TelegramImage$lambda$17;
                    TelegramImage$lambda$17 = ImagesKt.TelegramImage$lambda$17(i, (Composer) obj, ((Integer) obj2).intValue());
                    return TelegramImage$lambda$17;
                }
            });
        }
    }

    public static final void VkImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1909789917);
        ComposerKt.sourceInformation(startRestartGroup, "C(VkImage)231@6667L61,228@6577L241:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1909789917, i, -1, "com.miami.game.feature.home.ui.compose.VkImage (Images.kt:227)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.feature.home.R.drawable.btn_vk, startRestartGroup, 0), (String) null, SizeKt.m771height3ABfNKs(Modifier.Companion, Dp.m6684constructorimpl(54)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VkImage$lambda$18;
                    VkImage$lambda$18 = ImagesKt.VkImage$lambda$18(i, (Composer) obj, ((Integer) obj2).intValue());
                    return VkImage$lambda$18;
                }
            });
        }
    }
}
