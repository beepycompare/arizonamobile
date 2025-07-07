package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: ActivityResultRegistry.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultRegistryKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(ActivityResultContract<I, O> activityResultContract, Function1<? super O, Unit> function1, Composer composer, int i) {
        ActivityResultRegistry activityResultRegistry;
        String str;
        ComposerKt.sourceInformationMarkerStart(composer, -1408504823, "C(rememberLauncherForActivityResult)84@3541L30,85@3598L30,89@3767L49,*92@3905L7,96@4088L46,97@4162L73,101@4418L176,101@4362L232:ActivityResultRegistry.kt#q1dkbc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1408504823, i, -1, "androidx.activity.compose.rememberLauncherForActivityResult (ActivityResultRegistry.kt:82)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(activityResultContract, composer, i & 14);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        String str2 = (String) RememberSaveableKt.m3635rememberSaveable(new Object[0], (Saver<Object, ? extends Object>) null, (String) null, (Function0<? extends Object>) new Function0<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, (Composer) composer, 3072, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
        }
        ActivityResultRegistry activityResultRegistry2 = current.getActivityResultRegistry();
        ComposerKt.sourceInformationMarkerStart(composer, -316131648, "CC(remember):ActivityResultRegistry.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ActivityResultLauncherHolder();
            composer.updateRememberedValue(rememberedValue);
        }
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -316129253, "CC(remember):ActivityResultRegistry.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ManagedActivityResultLauncher(activityResultLauncherHolder, rememberUpdatedState);
            composer.updateRememberedValue(rememberedValue2);
        }
        ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -316120958, "CC(remember):ActivityResultRegistry.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(activityResultLauncherHolder) | composer.changedInstance(activityResultRegistry2) | composer.changed(str2) | composer.changedInstance(activityResultContract) | composer.changed(rememberUpdatedState2);
        ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1 rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1 activityResultRegistryKt$rememberLauncherForActivityResult$1$1 = new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1(activityResultLauncherHolder, activityResultRegistry2, str2, activityResultContract, rememberUpdatedState2);
            activityResultRegistry = activityResultRegistry2;
            str = str2;
            rememberedValue3 = activityResultRegistryKt$rememberLauncherForActivityResult$1$1;
            composer.updateRememberedValue(rememberedValue3);
        } else {
            str = str2;
            activityResultRegistry = activityResultRegistry2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(activityResultRegistry, str, activityResultContract, rememberedValue3, composer, (i << 6) & 896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return managedActivityResultLauncher;
    }
}
