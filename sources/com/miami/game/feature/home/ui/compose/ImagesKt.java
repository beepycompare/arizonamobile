package com.miami.game.feature.home.ui.compose;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageResources_androidKt;
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
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\r\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u001a\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u001b\u001a\u00020\u00012\b\b\u0001\u0010\u001c\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u001c\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"BackgroundImage", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/runtime/Composer;I)V", "SettingsImage", "(Landroidx/compose/runtime/Composer;I)V", "PlayImage", "isCheckingFiles", "", "(ZLandroidx/compose/runtime/Composer;I)V", "UpdateImage", "SetupImage", "ForumImage", "NotificationsImage", "notificationState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)V", "AccountImage", "ShopImage", "xdonate", "isArizona", "(IZLandroidx/compose/runtime/Composer;I)V", "DiscordImage", "TelegramImage", "VkImage", "SocialButtonImage", "resId", "(ILandroidx/compose/runtime/Composer;I)V", "safeImageBitmapResource", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/ImageBitmap;", "home"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
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
    public static final Unit SocialButtonImage$lambda$0(int i, int i2, Composer composer, int i3) {
        SocialButtonImage(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
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
        ComposerKt.sourceInformation(startRestartGroup, "C(BackgroundImage)N(imageBitmap)33@1309L162:Images.kt#dswm0d");
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
                ComposerKt.traceEventStart(-1222174292, i2, -1, "com.miami.game.feature.home.ui.compose.BackgroundImage (Images.kt:32)");
            }
            imageBitmap2 = imageBitmap;
            ImageKt.m345Image5hnEew(imageBitmap2, null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, ContentScale.Companion.getCrop(), 0.0f, null, 0, startRestartGroup, (i2 & 14) | 25008, 232);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.BackgroundImage$lambda$0(ImageBitmap.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SettingsImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-385149265);
        ComposerKt.sourceInformation(startRestartGroup, "C(SettingsImage)46@1601L104,43@1522L267:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-385149265, i, -1, "com.miami.game.feature.home.ui.compose.SettingsImage (Images.kt:42)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_setting, startRestartGroup, 0), (String) null, SizeKt.m1117size3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(24.0f)), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda3
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
        ComposerKt.sourceInformation(startRestartGroup, "C(PlayImage)N(isCheckingFiles)56@1860L427:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1050683340, i2, -1, "com.miami.game.feature.home.ui.compose.PlayImage (Images.kt:55)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -598791714, "C62@2176L55,59@2074L207:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(z ? R.drawable.ic_play_home_screen_inactive : R.drawable.ic_play_home_screen, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
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
        ComposerKt.sourceInformation(startRestartGroup, "C(UpdateImage)72@2336L253:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1202479543, i, -1, "com.miami.game.feature.home.ui.compose.UpdateImage (Images.kt:71)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -179924533, "C76@2452L81,73@2350L233:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.update_home_screen, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
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
                    return ImagesKt.UpdateImage$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SetupImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-371068495);
        ComposerKt.sourceInformation(startRestartGroup, "C(SetupImage)86@2637L285:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-371068495, i, -1, "com.miami.game.feature.home.ui.compose.SetupImage (Images.kt:85)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1934356849, "C90@2753L113,87@2651L265:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.setup_image, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.SetupImage$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ForumImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1452948083);
        ComposerKt.sourceInformation(startRestartGroup, "C(ForumImage)103@3060L64,100@2970L244:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1452948083, i, -1, "com.miami.game.feature.home.ui.compose.ForumImage (Images.kt:99)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_forum, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda6
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
        ComposerKt.sourceInformation(startRestartGroup, "C(NotificationsImage)N(notificationState)113@3300L1298:Images.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(notificationState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(772996739, i2, -1, "com.miami.game.feature.home.ui.compose.NotificationsImage (Images.kt:112)");
            }
            Modifier m1010offsetVpY3zN4$default = OffsetKt.m1010offsetVpY3zN4$default(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(44.0f)), Dp.m8160constructorimpl(-Dp.m8160constructorimpl(10.0f)), 0.0f, 2, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1010offsetVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 80033659, "C120@3542L79,117@3440L283:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_notification, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(32.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (notificationState.getValue().intValue() > 0) {
                startRestartGroup.startReplaceGroup(80346944);
                ComposerKt.sourceInformation(startRestartGroup, "128@3780L801");
                Modifier m1009offsetVpY3zN4 = OffsetKt.m1009offsetVpY3zN4(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(14.0f)), Dp.m8160constructorimpl(12.0f), Dp.m8160constructorimpl(-Dp.m8160constructorimpl(12.0f)));
                Alignment center2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1009offsetVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4467constructorimpl2 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1132758621, "C135@4038L101,134@4001L264,144@4449L13,145@4495L13,141@4282L285:Images.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_notification_count, startRestartGroup, 0), (String) null, (Modifier) null, (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 24624, 108);
                String valueOf = String.valueOf(notificationState.getValue().intValue());
                Modifier.Companion companion = Modifier.Companion;
                long m9793dpToSp8Feqmps = TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(10.0f), startRestartGroup, 6);
                TextKt.m3157TextNvy7gAk(valueOf, companion, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(10.0f), startRestartGroup, 6), null, null, null, 0L, null, null, m9793dpToSp8Feqmps, 0, false, 0, 0, null, null, startRestartGroup, 432, 0, 260072);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.NotificationsImage$lambda$1(State.this, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AccountImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(307092609);
        ComposerKt.sourceInformation(startRestartGroup, "C(AccountImage)160@4739L66,157@4649L246:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(307092609, i, -1, "com.miami.game.feature.home.ui.compose.AccountImage (Images.kt:156)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.btn_account, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(54.0f)), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda12
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
        ComposerKt.sourceInformation(startRestartGroup, "C(ShopImage)N(xdonate,isArizona)170@4974L1248:Images.kt#dswm0d");
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
                ComposerKt.traceEventStart(601068787, i3, -1, "com.miami.game.feature.home.ui.compose.ShopImage (Images.kt:169)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -541691606, "C174@5081L113,171@4988L256:Images.kt#dswm0d");
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_btn_shop, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(72.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
            if ((i > 2 && !z) || (i > 3 && z)) {
                startRestartGroup.startReplaceGroup(-541378321);
                ComposerKt.sourceInformation(startRestartGroup, "180@5328L878");
                Modifier align = boxScopeInstance.align(OffsetKt.m1009offsetVpY3zN4(Modifier.Companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(6.0f)), Dp.m8160constructorimpl(-Dp.m8160constructorimpl(6.0f))), Alignment.Companion.getTopEnd());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4467constructorimpl2 = Updater.m4467constructorimpl(startRestartGroup);
                Updater.m4475setimpl(m4467constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -493011394, "C186@5612L100,183@5495L283,194@5958L13,195@6004L13,198@6152L10,191@5795L397:Images.kt#dswm0d");
                ImageKt.Image(PainterResources_androidKt.painterResource(com.miami.game.ui.classic.home.R.drawable.shop_notificaiotns_bg, startRestartGroup, 0), (String) null, SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(20.0f)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 432, 120);
                TextKt.m3157TextNvy7gAk("АКЦИЯ Х" + i + " ДОНАТ", Modifier.Companion, Color.Companion.m5385getWhite0d7_KjU(), null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(12.0f), startRestartGroup, 6), null, FontWeight.Companion.getW900(), null, 0L, null, null, TypeKt.m9793dpToSp8Feqmps(Dp.m8160constructorimpl(12.0f), startRestartGroup, 6), 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getLabelMedium(), startRestartGroup, 1573296, 0, 128936);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.ShopImage$lambda$1(i, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void DiscordImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1376889058);
        ComposerKt.sourceInformation(startRestartGroup, "C(DiscordImage)207@6272L41:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1376889058, i, -1, "com.miami.game.feature.home.ui.compose.DiscordImage (Images.kt:206)");
            }
            SocialButtonImage(com.miami.game.ui.classic.home.R.drawable.btn_discord, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.DiscordImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TelegramImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1835780975);
        ComposerKt.sourceInformation(startRestartGroup, "C(TelegramImage)212@6364L42:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835780975, i, -1, "com.miami.game.feature.home.ui.compose.TelegramImage (Images.kt:211)");
            }
            SocialButtonImage(com.miami.game.ui.classic.home.R.drawable.btn_telegram, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.TelegramImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void VkImage(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1909789917);
        ComposerKt.sourceInformation(startRestartGroup, "C(VkImage)217@6451L36:Images.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1909789917, i, -1, "com.miami.game.feature.home.ui.compose.VkImage (Images.kt:216)");
            }
            SocialButtonImage(com.miami.game.ui.classic.home.R.drawable.btn_vk, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.VkImage$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SocialButtonImage(final int i, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1216030680);
        ComposerKt.sourceInformation(startRestartGroup, "C(SocialButtonImage)N(resId)225@6643L30:Images.kt#dswm0d");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!startRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1216030680, i3, -1, "com.miami.game.feature.home.ui.compose.SocialButtonImage (Images.kt:221)");
            }
            Modifier m1103height3ABfNKs = SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(54.0f));
            ImageBitmap safeImageBitmapResource = safeImageBitmapResource(i, startRestartGroup, i3 & 14);
            if (safeImageBitmapResource != null) {
                startRestartGroup.startReplaceGroup(-1278948100);
                ComposerKt.sourceInformation(startRestartGroup, "227@6713L174");
                ImageKt.m345Image5hnEew(safeImageBitmapResource, null, m1103height3ABfNKs, null, ContentScale.Companion.getFillHeight(), 0.0f, null, 0, startRestartGroup, 25008, 232);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1278767649);
                ComposerKt.sourceInformation(startRestartGroup, "234@6909L27");
                SpacerKt.Spacer(m1103height3ABfNKs, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.ImagesKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImagesKt.SocialButtonImage$lambda$0(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ImageBitmap safeImageBitmapResource(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 238925733, "C(safeImageBitmapResource)N(resId)240@7068L7,241@7097L255:Images.kt#dswm0d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(238925733, i2, -1, "com.miami.game.feature.home.ui.compose.safeImageBitmapResource (Images.kt:239)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = ((Context) consume).getResources();
        ComposerKt.sourceInformationMarkerStart(composer, 1974367172, "CC(remember):Images.kt#9igjgp");
        boolean changed = ((((i2 & 14) ^ 6) > 4 && composer.changed(i)) || (i2 & 6) == 4) | composer.changed(resources);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            try {
                ImageBitmap.Companion companion = ImageBitmap.Companion;
                Intrinsics.checkNotNull(resources);
                rememberedValue = ImageResources_androidKt.imageResource(companion, resources, i);
            } catch (Resources.NotFoundException | RuntimeException unused) {
                rememberedValue = null;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        ImageBitmap imageBitmap = (ImageBitmap) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imageBitmap;
    }
}
