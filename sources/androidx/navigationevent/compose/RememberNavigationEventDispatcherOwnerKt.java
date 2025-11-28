package androidx.navigationevent.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: RememberNavigationEventDispatcherOwner.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberNavigationEventDispatcherOwner", "Landroidx/navigationevent/NavigationEventDispatcherOwner;", "enabled", "", "parent", "(ZLandroidx/navigationevent/NavigationEventDispatcherOwner;Landroidx/compose/runtime/Composer;II)Landroidx/navigationevent/NavigationEventDispatcherOwner;", "navigationevent-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RememberNavigationEventDispatcherOwnerKt {
    public static final NavigationEventDispatcherOwner rememberNavigationEventDispatcherOwner(boolean z, NavigationEventDispatcherOwner navigationEventDispatcherOwner, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -336636597, "C(rememberNavigationEventDispatcherOwner)N(enabled,parent)61@3115L7,67@3406L325,76@3761L39,76@3737L63,79@3907L43,79@3873L77,81@3963L124:RememberNavigationEventDispatcherOwner.kt#wc8b4r");
        boolean z2 = true;
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) == 0 || (navigationEventDispatcherOwner = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(composer, 6)) != null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-336636597, i, -1, "androidx.navigationevent.compose.rememberNavigationEventDispatcherOwner (RememberNavigationEventDispatcherOwner.kt:65)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1385206640, "CC(remember):RememberNavigationEventDispatcherOwner.kt#9igjgp");
            boolean changed = composer.changed(navigationEventDispatcherOwner);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                if (navigationEventDispatcherOwner != null) {
                    rememberedValue = new NavigationEventDispatcher(navigationEventDispatcherOwner.getNavigationEventDispatcher());
                } else {
                    rememberedValue = new NavigationEventDispatcher();
                }
                composer.updateRememberedValue(rememberedValue);
            }
            final NavigationEventDispatcher navigationEventDispatcher = (NavigationEventDispatcher) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Boolean valueOf = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composer, -1385195566, "CC(remember):RememberNavigationEventDispatcherOwner.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(navigationEventDispatcher);
            int i3 = i & 14;
            if (((i3 ^ 6) <= 4 || !composer.changed(z)) && (i & 6) != 4) {
                z2 = false;
            }
            boolean z3 = changedInstance | z2;
            Object rememberedValue2 = composer.rememberedValue();
            if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function2) new RememberNavigationEventDispatcherOwnerKt$rememberNavigationEventDispatcherOwner$2$1(navigationEventDispatcher, z, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, composer, i3);
            ComposerKt.sourceInformationMarkerStart(composer, -1385190890, "CC(remember):RememberNavigationEventDispatcherOwner.kt#9igjgp");
            boolean changedInstance2 = composer.changedInstance(navigationEventDispatcher);
            Object rememberedValue3 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.navigationevent.compose.RememberNavigationEventDispatcherOwnerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult rememberNavigationEventDispatcherOwner$lambda$5$lambda$4;
                        rememberNavigationEventDispatcherOwner$lambda$5$lambda$4 = RememberNavigationEventDispatcherOwnerKt.rememberNavigationEventDispatcherOwner$lambda$5$lambda$4(NavigationEventDispatcher.this, (DisposableEffectScope) obj);
                        return rememberNavigationEventDispatcherOwner$lambda$5$lambda$4;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(navigationEventDispatcher, (Function1) rememberedValue3, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1385189017, "CC(remember):RememberNavigationEventDispatcherOwner.kt#9igjgp");
            boolean changed2 = composer.changed(navigationEventDispatcher);
            Object rememberedValue4 = composer.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new ComposeNavigationEventDispatcherOwner(navigationEventDispatcher);
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposeNavigationEventDispatcherOwner composeNavigationEventDispatcherOwner = (ComposeNavigationEventDispatcherOwner) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return composeNavigationEventDispatcherOwner;
        }
        throw new IllegalStateException("No NavigationEventDispatcherOwner provided in LocalNavigationEventDispatcherOwner. If you intended to create a root dispatcher, explicitly pass null as the parent.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberNavigationEventDispatcherOwner$lambda$5$lambda$4(final NavigationEventDispatcher navigationEventDispatcher, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.navigationevent.compose.RememberNavigationEventDispatcherOwnerKt$rememberNavigationEventDispatcherOwner$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                NavigationEventDispatcher.this.dispose();
            }
        };
    }
}
