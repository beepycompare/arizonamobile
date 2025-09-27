package com.miami.game.feature.download.dialog.ui.connection;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.ui.theme.TypeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InputField.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"InputField", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/runtime/MutableState;", "", "width", "Landroidx/compose/ui/unit/Dp;", "bgId", "", "InputField-rAjV9yQ", "(Landroidx/compose/runtime/MutableState;FILandroidx/compose/runtime/Composer;I)V", "dialogs_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField_rAjV9yQ$lambda$1(MutableState mutableState, float f, int i, int i2, Composer composer, int i3) {
        m8967InputFieldrAjV9yQ(mutableState, f, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: InputField-rAjV9yQ  reason: not valid java name */
    public static final void m8967InputFieldrAjV9yQ(final MutableState<String> state, final float f, final int i, Composer composer, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(-155401538);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputField)N(state,width:c#ui.unit.Dp,bgId)35@1354L851:InputField.kt#yp5s1q");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(state) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(i) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-155401538, i3, -1, "com.miami.game.feature.download.dialog.ui.connection.InputField (InputField.kt:34)");
            }
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
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
            Composer m3867constructorimpl = Updater.m3867constructorimpl(startRestartGroup);
            Updater.m3874setimpl(m3867constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3874setimpl(m3867constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3867constructorimpl.getInserting() || !Intrinsics.areEqual(m3867constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                m3867constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                m3867constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
            }
            Updater.m3874setimpl(m3867constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -561676279, "C41@1521L21,41@1505L166,49@1880L10,50@1934L13,51@1978L13,48@1804L36,45@1681L518:InputField.kt#yp5s1q");
            int i4 = i3;
            ImageKt.Image(PainterResources_androidKt.painterResource(i, startRestartGroup, (i3 >> 6) & 14), (String) null, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null), (Alignment) null, ContentScale.Companion.getFillHeight(), 0.0f, (ColorFilter) null, startRestartGroup, 25008, 104);
            Modifier m899width3ABfNKs = SizeKt.m899width3ABfNKs(Modifier.Companion, f);
            String value = state.getValue();
            float f2 = 24;
            TextStyle m6739copyp1EtxEg$default = TextStyle.m6739copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getBodySmall(), Color.m4548copywmQWz5c$default(Color.Companion.m4586getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TypeKt.m9061dpToSp8Feqmps(Dp.m7264constructorimpl(f2), startRestartGroup, 6), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TypeKt.m9061dpToSp8Feqmps(Dp.m7264constructorimpl(f2), startRestartGroup, 6), null, null, null, 0, 0, null, 16646140, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -295204344, "CC(remember):InputField.kt#9igjgp");
            boolean z = (i4 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.download.dialog.ui.connection.InputFieldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit InputField_rAjV9yQ$lambda$0$0$0;
                        InputField_rAjV9yQ$lambda$0$0$0 = InputFieldKt.InputField_rAjV9yQ$lambda$0$0$0(MutableState.this, (String) obj);
                        return InputField_rAjV9yQ$lambda$0$0$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BasicTextFieldKt.BasicTextField(value, (Function1<? super String, Unit>) rememberedValue, m899width3ABfNKs, false, false, m6739copyp1EtxEg$default, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) null, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableSingletons$InputFieldKt.INSTANCE.m8963getLambda$1682333503$dialogs_release(), startRestartGroup, 100663296, (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 32472);
            startRestartGroup = startRestartGroup;
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.download.dialog.ui.connection.InputFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputField_rAjV9yQ$lambda$1;
                    InputField_rAjV9yQ$lambda$1 = InputFieldKt.InputField_rAjV9yQ$lambda$1(MutableState.this, f, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return InputField_rAjV9yQ$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputField_rAjV9yQ$lambda$0$0$0(MutableState mutableState, String newText) {
        Intrinsics.checkNotNullParameter(newText, "newText");
        mutableState.setValue(newText);
        return Unit.INSTANCE;
    }
}
