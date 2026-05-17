package com.miami.game.feature.home.ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.drawable.resources.R;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Images.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\r\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u001b"}, d2 = {"BackgroundImage", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/runtime/Composer;I)V", "SettingsImage", "(Landroidx/compose/runtime/Composer;I)V", "PlayImage", "isCheckingFiles", "", "(ZLandroidx/compose/runtime/Composer;I)V", "UpdateImage", "SetupImage", "ForumImage", "NotificationsImage", "notificationState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)V", "AccountImage", "ShopImage", "xdonate", "isArizona", "(IZLandroidx/compose/runtime/Composer;I)V", "DiscordImage", "TelegramImage", "VkImage", "home"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImagesKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AccountImage$lambda$0(int i, Composer composer, int i2) {
        AccountImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BackgroundImage$lambda$0(ImageBitmap imageBitmap, int i, Composer composer, int i2) {
        BackgroundImage(imageBitmap, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DiscordImage$lambda$0(int i, Composer composer, int i2) {
        DiscordImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ForumImage$lambda$0(int i, Composer composer, int i2) {
        ForumImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NotificationsImage$lambda$1(State state, int i, Composer composer, int i2) {
        NotificationsImage(state, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PlayImage$lambda$1(boolean z, int i, Composer composer, int i2) {
        PlayImage(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SettingsImage$lambda$0(int i, Composer composer, int i2) {
        SettingsImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SetupImage$lambda$1(int i, Composer composer, int i2) {
        SetupImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ShopImage$lambda$1(int i, boolean z, int i2, Composer composer, int i3) {
        ShopImage(i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TelegramImage$lambda$0(int i, Composer composer, int i2) {
        TelegramImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit UpdateImage$lambda$1(int i, Composer composer, int i2) {
        UpdateImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit VkImage$lambda$0(int i, Composer composer, int i2) {
        VkImage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BackgroundImage(ImageBitmap imageBitmap, Composer composer, final int i) {
        int i2;
        final ImageBitmap imageBitmap2;
        Intrinsics.checkNotNullParameter(imageBitmap, "imageBitmap");
        Composer startRestartGroup = composer.startRestartGroup(-1222174292);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(imageBitmap)26@995L162:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            imageBitmap2 = imageBitmap;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1222174292, i2, -1, "com.miami.game.feature.home.ui.compose.BackgroundImage (Images.kt:25)");
            }
            imageBitmap2 = imageBitmap;
            ImageKt.m321Image5hnEew(imageBitmap2, null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, ContentScale.Companion.getCrop(), 0.0f, null, 0, startRestartGroup, (i2 & 14) | 25008, 232);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.BackgroundImage$lambda$0(ImageBitmap.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SettingsImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-385149265);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsImage)39@1287L104,36@1208L267:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385149265, i, -1, "com.miami.game.feature.home.ui.compose.SettingsImage (Images.kt:35)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_setting, startRestartGroup, 0), (String) null, SizeKt.m864size3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(24.0f)), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.SettingsImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void PlayImage(final boolean z, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1050683340);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlayImage)N(isCheckingFiles)49@1546L427:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1050683340, i2, -1, "com.miami.game.feature.home.ui.compose.PlayImage (Images.kt:48)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -598791714, "C55@1862L55,52@1760L207:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(z ? R.drawable.ic_play_home_screen_inactive : R.drawable.ic_play_home_screen, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
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
                    return ImagesKt.PlayImage$lambda$1(z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void UpdateImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1202479543);
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdateImage)65@2022L253:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1202479543, i, -1, "com.miami.game.feature.home.ui.compose.UpdateImage (Images.kt:64)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -179924533, "C69@2138L81,66@2036L233:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.update_home_screen, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
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
                    return ImagesKt.UpdateImage$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SetupImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-371068495);
        ComposerKt.sourceInformation(startRestartGroup, "C(SetupImage)79@2323L285:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-371068495, i, -1, "com.miami.game.feature.home.ui.compose.SetupImage (Images.kt:78)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1934356849, "C83@2439L113,80@2337L265:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.setup_image, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.SetupImage$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ForumImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1452948083);
        ComposerKt.sourceInformation(startRestartGroup, "C(ForumImage)96@2746L64,93@2656L244:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1452948083, i, -1, "com.miami.game.feature.home.ui.compose.ForumImage (Images.kt:92)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_forum, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.ForumImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void NotificationsImage(final State<Integer> notificationState, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(notificationState, "notificationState");
        Composer startRestartGroup = composer.startRestartGroup(772996739);
        ComposerKt.sourceInformation(startRestartGroup, "C(NotificationsImage)N(notificationState)106@2986L1298:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(notificationState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(772996739, i2, -1, "com.miami.game.feature.home.ui.compose.NotificationsImage (Images.kt:105)");
            }
            Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(44.0f)), Dp.m7555constructorimpl(-Dp.m7555constructorimpl(10.0f)), 0.0f, 2, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m778offsetVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 80033659, "C113@3228L79,110@3126L283:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_notification, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(32.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (notificationState.getValue().intValue() > 0) {
                startRestartGroup.startReplaceGroup(80346944);
                ComposerKt.sourceInformation(startRestartGroup, "121@3466L801");
                Modifier m777offsetVpY3zN4 = OffsetKt.m777offsetVpY3zN4(SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(14.0f)), Dp.m7555constructorimpl(12.0f), Dp.m7555constructorimpl(-Dp.m7555constructorimpl(12.0f)));
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m777offsetVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4045initimpl(m4041constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4047reconcileimpl(m4041constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1132758621, "C128@3724L101,127@3687L264,137@4135L13,138@4181L13,134@3968L285:Images.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_notification_count, startRestartGroup, 0), (String) null, (Modifier) null, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 24624, 108);
                String valueOf = String.valueOf(notificationState.getValue().intValue());
                Modifier.Companion companion = Modifier.Companion;
                long m9154dpToSp8Feqmps = TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(10.0f), startRestartGroup, 6);
                TextKt.m2712TextNvy7gAk(valueOf, companion, Color.Companion.m4809getWhite0d7_KjU(), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(10.0f), startRestartGroup, 6), null, null, null, 0L, null, null, m9154dpToSp8Feqmps, 0, false, 0, 0, null, null, startRestartGroup, 432, 0, 260072);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(81139769);
                startRestartGroup.endReplaceGroup();
            }
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
                    return ImagesKt.NotificationsImage$lambda$1(State.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AccountImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(307092609);
        ComposerKt.sourceInformation(startRestartGroup, "C(AccountImage)153@4425L66,150@4335L246:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307092609, i, -1, "com.miami.game.feature.home.ui.compose.AccountImage (Images.kt:149)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_account, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.AccountImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ShopImage(final int i, final boolean z, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(601068787);
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopImage)N(xdonate,isArizona)163@4660L1248:Images.kt#dswm0d");
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
                ComposerKt.traceEventStart(601068787, i3, -1, "com.miami.game.feature.home.ui.compose.ShopImage (Images.kt:162)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -541691606, "C167@4767L113,164@4674L256:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_btn_shop, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
            if ((i > 2 && !z) || (i > 3 && z)) {
                startRestartGroup.startReplaceGroup(-541378321);
                ComposerKt.sourceInformation(startRestartGroup, "173@5014L878");
                Modifier align = boxScopeInstance.align(OffsetKt.m777offsetVpY3zN4(Modifier.Companion, Dp.m7555constructorimpl(-Dp.m7555constructorimpl(6.0f)), Dp.m7555constructorimpl(-Dp.m7555constructorimpl(6.0f))), Alignment.Companion.getTopEnd());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4045initimpl(m4041constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4047reconcileimpl(m4041constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -493011394, "C179@5298L100,176@5181L283,187@5644L13,188@5690L13,191@5838L10,184@5481L397:Images.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.shop_notificaiotns_bg, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(20.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                TextKt.m2712TextNvy7gAk("АКЦИЯ Х" + i + " ДОНАТ", Modifier.Companion, Color.Companion.m4809getWhite0d7_KjU(), null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(12.0f), startRestartGroup, 6), null, FontWeight.Companion.getW900(), null, 0L, null, null, TypeKt.m9154dpToSp8Feqmps(Dp.m7555constructorimpl(12.0f), startRestartGroup, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium(), startRestartGroup, 1573296, 0, 128936);
                startRestartGroup = startRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-540511499);
                startRestartGroup.endReplaceGroup();
            }
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
                    return ImagesKt.ShopImage$lambda$1(i, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void DiscordImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1376889058);
        ComposerKt.sourceInformation(startRestartGroup, "C(DiscordImage)203@6048L66,200@5958L246:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1376889058, i, -1, "com.miami.game.feature.home.ui.compose.DiscordImage (Images.kt:199)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_discord, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.DiscordImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TelegramImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1835780975);
        ComposerKt.sourceInformation(startRestartGroup, "C(TelegramImage)216@6345L67,213@6255L247:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835780975, i, -1, "com.miami.game.feature.home.ui.compose.TelegramImage (Images.kt:212)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_telegram, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.TelegramImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void VkImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1909789917);
        ComposerKt.sourceInformation(startRestartGroup, "C(VkImage)229@6637L61,226@6547L241:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1909789917, i, -1, "com.miami.game.feature.home.ui.compose.VkImage (Images.kt:225)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_vk, startRestartGroup, 0), (String) null, SizeKt.m850height3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.VkImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
