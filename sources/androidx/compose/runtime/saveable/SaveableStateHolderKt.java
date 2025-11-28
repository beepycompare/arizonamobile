package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: SaveableStateHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberSaveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/saveable/SaveableStateHolder;", "runtime-saveable"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SaveableStateHolderKt {
    public static final SaveableStateHolder rememberSaveableStateHolder(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 15454635, "C(rememberSaveableStateHolder)57@2611L29,57@2555L85:SaveableStateHolder.kt#r2ddri");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(15454635, i, -1, "androidx.compose.runtime.saveable.rememberSaveableStateHolder (SaveableStateHolder.kt:57)");
        }
        composer.startReplaceGroup(1967008021);
        ComposerKt.sourceInformation(composer, "*58@2715L7");
        Object[] objArr = new Object[0];
        Saver<SaveableStateHolderImpl, ?> saver = SaveableStateHolderImpl.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 1967006728, "CC(remember):SaveableStateHolder.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    SaveableStateHolderImpl rememberSaveableStateHolder$lambda$1$lambda$0;
                    rememberSaveableStateHolder$lambda$1$lambda$0 = SaveableStateHolderKt.rememberSaveableStateHolder$lambda$1$lambda$0();
                    return rememberSaveableStateHolder$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) RememberSaveableKt.m4726rememberSaveable(objArr, saver, (Function0<? extends Object>) rememberedValue, composer, (int) RendererCapabilities.DECODER_SUPPORT_MASK);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        ComposerKt.sourceInformationMarkerEnd(composer);
        saveableStateHolderImpl.setParentSaveableStateRegistry((SaveableStateRegistry) consume);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return saveableStateHolderImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaveableStateHolderImpl rememberSaveableStateHolder$lambda$1$lambda$0() {
        return new SaveableStateHolderImpl(null, 1, null);
    }
}
