package com.miami.game.feature.select.server.ui.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.miami.game.core.design.system.theme.FavoriteButtonShape;
import com.miami.game.core.drawable.resources.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
/* compiled from: FavoriteButton.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"FavoriteButton", "", "isFavorite", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "select-server"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FavoriteButtonKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FavoriteButton$lambda$1(boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FavoriteButton(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FavoriteButton(final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        final Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        long m5347copywmQWz5c$default;
        Composer startRestartGroup = composer.startRestartGroup(-932208314);
        ComposerKt.sourceInformation(startRestartGroup, "C(FavoriteButton)N(isFavorite,modifier)26@1165L925:FavoriteButton.kt#2ojkxh");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if (startRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-932208314, i3, -1, "com.miami.game.feature.select.server.ui.compose.FavoriteButton (FavoriteButton.kt:24)");
                }
                if (z) {
                    startRestartGroup.startReplaceGroup(1795979405);
                    ComposerKt.sourceInformation(startRestartGroup, "25@1105L11");
                    m5347copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, MaterialTheme.$stable).m2322getPrimary0d7_KjU();
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1795980216);
                    startRestartGroup.endReplaceGroup();
                    m5347copywmQWz5c$default = Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                Modifier m301borderziNgDLE = BorderKt.m301borderziNgDLE(BackgroundKt.m287backgroundbw27NRU(SizeKt.m1119sizeVpY3zN4(OffsetKt.m1009offsetVpY3zN4(companion, Dp.m8160constructorimpl(-Dp.m8160constructorimpl(14.0f)), Dp.m8160constructorimpl(4.0f)), Dp.m8160constructorimpl(40.0f), Dp.m8160constructorimpl(26.0f)), m5347copywmQWz5c$default, new FavoriteButtonShape()), Dp.m8160constructorimpl(2.0f), Brush.Companion.m5303verticalGradient8A3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(Color.m5347copywmQWz5c$default(Color.Companion.m5380getLightGray0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5338boximpl(Color.Companion.m5383getTransparent0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), new FavoriteButtonShape());
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m301borderziNgDLE);
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1128560934, "C46@1899L19,46@1883L201:FavoriteButton.kt#2ojkxh");
                ImageKt.Image(PainterResources_androidKt.painterResource(z ? R.drawable.select_server_favorite_true : R.drawable.select_server_favorite_false, startRestartGroup, 0), (String) null, OffsetKt.m1010offsetVpY3zN4$default(SizeKt.m1103height3ABfNKs(Modifier.Companion, Dp.m8160constructorimpl(18.0f)), Dp.m8160constructorimpl(-Dp.m8160constructorimpl(1.0f)), 0.0f, 2, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, Painter.$stable | 25008, 104);
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
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.select.server.ui.compose.FavoriteButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return FavoriteButtonKt.FavoriteButton$lambda$1(z, companion, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if (startRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
