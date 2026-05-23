package androidx.compose.ui.adaptive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.os.Looper;
import android.view.InputDevice;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.UiMediaScope;
import androidx.compose.ui.platform.WindowInfo;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MediaQuery.android.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001a\u0017\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002\u001a\f\u0010 \u001a\u00020\u000f*\u00020!H\u0002\u001a\f\u0010\"\u001a\u00020\u000f*\u00020!H\u0002\u001a\f\u0010#\u001a\u00020\u000f*\u00020!H\u0002\u001a\f\u0010$\u001a\u00020\u000f*\u00020!H\u0002\u001a\u0014\u0010%\u001a\u00020\u000f*\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\"\u001a\u0010\u001a\u001a\u00020\u000f*\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006&"}, d2 = {"obtainUiMediaScope", "Landroidx/compose/ui/UiMediaScope;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "(Landroid/content/Context;Landroid/view/View;Landroidx/compose/ui/platform/WindowInfo;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/UiMediaScope;", "resolvePosture", "Landroidx/compose/ui/UiMediaScope$Posture;", "layoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "(Landroidx/window/layout/WindowLayoutInfo;)Ljava/lang/String;", "hasPhysicalKeyboard", "", "inputManager", "Landroid/hardware/input/InputManager;", "resolvePointerPrecision", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "(Landroid/hardware/input/InputManager;)Ljava/lang/String;", "hasValidPointerSource", "Landroid/view/InputDevice;", "source", "", "axis", "isImeVisible", "Landroidx/core/view/WindowInsetsCompat;", "(Landroidx/core/view/WindowInsetsCompat;)Z", "isDocked", "intent", "Landroid/content/Intent;", "isCameraAvailable", "Landroid/content/pm/PackageManager;", "isMicAvailable", "isAutomotiveDevice", "isTvDevice", "hasSource", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MediaQuery_androidKt {
    private static final boolean hasSource(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final UiMediaScope obtainUiMediaScope(final Context context, View view, WindowInfo windowInfo, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -590796729, "C(obtainUiMediaScope)N(context,view,windowInfo)122@4434L76,123@4542L62,124@4621L98,130@4806L174,130@4782L198,137@5063L716,137@5037L742,160@5847L336,160@5824L359,172@6261L613,172@6235L639:MediaQuery.android.kt#xs8cwh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-590796729, i, -1, "androidx.compose.ui.adaptive.obtainUiMediaScope (MediaQuery.android.kt:121)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -819969229, "CC(remember):MediaQuery.android.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            Object systemService = context.getSystemService("input");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.input.InputManager");
            rememberedValue = (InputManager) systemService;
            composer.updateRememberedValue(rememberedValue);
        }
        final InputManager inputManager = (InputManager) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -819965787, "CC(remember):MediaQuery.android.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = Boolean.valueOf(isImeVisible(ViewCompat.getRootWindowInsets(view)));
            composer.updateRememberedValue(rememberedValue2);
        }
        boolean booleanValue = ((Boolean) rememberedValue2).booleanValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -819963223, "CC(remember):MediaQuery.android.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new UiMediaScopeImpl(context, inputManager, windowInfo, booleanValue);
            composer.updateRememberedValue(rememberedValue3);
        }
        final UiMediaScopeImpl uiMediaScopeImpl = (UiMediaScopeImpl) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        uiMediaScopeImpl.set_windowInfo(windowInfo);
        ComposerKt.sourceInformationMarkerStart(composer, -819957227, "CC(remember):MediaQuery.android.kt#9igjgp");
        boolean changedInstance = composer.changedInstance(context);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = (Function2) new MediaQuery_androidKt$obtainUiMediaScope$1$1(context, uiMediaScopeImpl, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = i & 14;
        EffectsKt.LaunchedEffect(context, (Function2) rememberedValue4, composer, i2);
        ComposerKt.sourceInformationMarkerStart(composer, -819948461, "CC(remember):MediaQuery.android.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(inputManager);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$2$1$listener$1] */
                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final UiMediaScopeImpl uiMediaScopeImpl2 = uiMediaScopeImpl;
                    final InputManager inputManager2 = inputManager;
                    final ?? r5 = new InputManager.InputDeviceListener() { // from class: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$2$1$listener$1
                        @Override // android.hardware.input.InputManager.InputDeviceListener
                        public void onInputDeviceAdded(int i3) {
                            update();
                        }

                        @Override // android.hardware.input.InputManager.InputDeviceListener
                        public void onInputDeviceRemoved(int i3) {
                            update();
                        }

                        @Override // android.hardware.input.InputManager.InputDeviceListener
                        public void onInputDeviceChanged(int i3) {
                            update();
                        }

                        public final void update() {
                            String resolvePointerPrecision;
                            boolean hasPhysicalKeyboard;
                            UiMediaScopeImpl uiMediaScopeImpl3 = UiMediaScopeImpl.this;
                            resolvePointerPrecision = MediaQuery_androidKt.resolvePointerPrecision(inputManager2);
                            uiMediaScopeImpl3.m4843set_anyPointerZYK4Wgo(resolvePointerPrecision);
                            UiMediaScopeImpl uiMediaScopeImpl4 = UiMediaScopeImpl.this;
                            hasPhysicalKeyboard = MediaQuery_androidKt.hasPhysicalKeyboard(inputManager2);
                            uiMediaScopeImpl4.setHasPhysicalKeyboard(hasPhysicalKeyboard);
                        }
                    };
                    inputManager.registerInputDeviceListener((InputManager.InputDeviceListener) r5, new Handler(Looper.getMainLooper()));
                    r5.update();
                    final InputManager inputManager3 = inputManager;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            inputManager3.unregisterInputDeviceListener(r5);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(context, (Function1) rememberedValue5, composer, i2);
        ComposerKt.sourceInformationMarkerStart(composer, -819923753, "CC(remember):MediaQuery.android.kt#9igjgp");
        boolean changedInstance3 = composer.changedInstance(view);
        Object rememberedValue6 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue6 == Composer.Companion.getEmpty()) {
            rememberedValue6 = (Function1) new MediaQuery_androidKt$obtainUiMediaScope$3$1(view, uiMediaScopeImpl);
            composer.updateRememberedValue(rememberedValue6);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(view, (Function1) rememberedValue6, composer, (i >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -819910228, "CC(remember):MediaQuery.android.kt#9igjgp");
        boolean changedInstance4 = composer.changedInstance(context);
        Object rememberedValue7 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue7 == Composer.Companion.getEmpty()) {
            rememberedValue7 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$4$1$receiver$1] */
                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    boolean isDocked;
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.DOCK_EVENT");
                    final UiMediaScopeImpl uiMediaScopeImpl2 = uiMediaScopeImpl;
                    final ?? r0 = new BroadcastReceiver() { // from class: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$4$1$receiver$1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context2, Intent intent) {
                            boolean isDocked2;
                            UiMediaScopeImpl uiMediaScopeImpl3 = UiMediaScopeImpl.this;
                            isDocked2 = MediaQuery_androidKt.isDocked(intent);
                            uiMediaScopeImpl3.setDocked(isDocked2);
                        }
                    };
                    Intent registerReceiver = ContextCompat.registerReceiver(context, (BroadcastReceiver) r0, intentFilter, 2);
                    UiMediaScopeImpl uiMediaScopeImpl3 = uiMediaScopeImpl;
                    isDocked = MediaQuery_androidKt.isDocked(registerReceiver);
                    uiMediaScopeImpl3.setDocked(isDocked);
                    final Context context2 = context;
                    return new DisposableEffectResult() { // from class: androidx.compose.ui.adaptive.MediaQuery_androidKt$obtainUiMediaScope$4$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            context2.unregisterReceiver(r0);
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(context, (Function1) rememberedValue7, composer, i2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return uiMediaScopeImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolvePosture(WindowLayoutInfo windowLayoutInfo) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : windowLayoutInfo.getDisplayFeatures()) {
            if (obj2 instanceof FoldingFeature) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((FoldingFeature) obj).getState(), FoldingFeature.State.HALF_OPENED)) {
                break;
            }
        }
        FoldingFeature foldingFeature = (FoldingFeature) obj;
        if (foldingFeature == null) {
            return UiMediaScope.Posture.Companion.m4829getFlatm18o9QQ();
        }
        if (Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.HORIZONTAL)) {
            return UiMediaScope.Posture.Companion.m4830getTabletopm18o9QQ();
        }
        return UiMediaScope.Posture.Companion.m4828getBookm18o9QQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasPhysicalKeyboard(InputManager inputManager) {
        int[] inputDeviceIds;
        if (inputManager != null && (inputDeviceIds = inputManager.getInputDeviceIds()) != null) {
            for (int i : inputDeviceIds) {
                InputDevice inputDevice = inputManager.getInputDevice(i);
                if (inputDevice != null && inputDevice.getKeyboardType() == 2 && !inputDevice.isVirtual()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolvePointerPrecision(InputManager inputManager) {
        if (inputManager == null) {
            return UiMediaScope.PointerPrecision.Companion.m4820getNonefpxItnM();
        }
        String m4820getNonefpxItnM = UiMediaScope.PointerPrecision.Companion.m4820getNonefpxItnM();
        for (int i : inputManager.getInputDeviceIds()) {
            InputDevice inputDevice = inputManager.getInputDevice(i);
            if (inputDevice != null) {
                if (hasValidPointerSource$default(inputDevice, 8194, 0, 2, null) || hasValidPointerSource$default(inputDevice, InputDeviceCompat.SOURCE_STYLUS, 0, 2, null) || hasValidPointerSource$default(inputDevice, InputDeviceCompat.SOURCE_TOUCHPAD, 0, 2, null)) {
                    return UiMediaScope.PointerPrecision.Companion.m4819getFinefpxItnM();
                }
                if (hasValidPointerSource$default(inputDevice, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, 2, null)) {
                    m4820getNonefpxItnM = UiMediaScope.PointerPrecision.Companion.m4818getCoarsefpxItnM();
                } else if (UiMediaScope.PointerPrecision.m4813equalsimpl0(m4820getNonefpxItnM, UiMediaScope.PointerPrecision.Companion.m4820getNonefpxItnM()) && (hasValidPointerSource$default(inputDevice, InputDeviceCompat.SOURCE_JOYSTICK, 0, 2, null) || hasValidPointerSource$default(inputDevice, 1025, 0, 2, null))) {
                    m4820getNonefpxItnM = UiMediaScope.PointerPrecision.Companion.m4817getBluntfpxItnM();
                }
            }
        }
        return m4820getNonefpxItnM;
    }

    static /* synthetic */ boolean hasValidPointerSource$default(InputDevice inputDevice, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return hasValidPointerSource(inputDevice, i, i2);
    }

    private static final boolean hasValidPointerSource(InputDevice inputDevice, int i, int i2) {
        return (inputDevice.getSources() & i) == i && inputDevice.getMotionRange(i2, i) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isImeVisible(WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat != null && windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDocked(Intent intent) {
        return (intent == null || intent.getIntExtra("android.intent.extra.DOCK_STATE", 0) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCameraAvailable(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.camera.any");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMicAvailable(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.microphone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isAutomotiveDevice(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.type.automotive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTvDevice(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.software.leanback");
    }
}
