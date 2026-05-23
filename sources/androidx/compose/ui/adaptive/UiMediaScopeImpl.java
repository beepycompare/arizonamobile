package androidx.compose.ui.adaptive;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.input.InputManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.UiMediaScope;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
/* compiled from: MediaQuery.android.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00178F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u001e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR+\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R+\u0010+\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0016\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\u0014\u0010/\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010$R\u0014\u00101\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010$R\u0014\u00103\u001a\u0002048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0002048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001aR\u0014\u0010;\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u001aR\u0014\u0010=\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u001aR\u0014\u0010@\u001a\u00020A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u001a¨\u0006C"}, d2 = {"Landroidx/compose/ui/adaptive/UiMediaScopeImpl;", "Landroidx/compose/ui/UiMediaScope;", "context", "Landroid/content/Context;", "inputManager", "Landroid/hardware/input/InputManager;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "imeVisibility", "", "<init>", "(Landroid/content/Context;Landroid/hardware/input/InputManager;Landroidx/compose/ui/platform/WindowInfo;Z)V", "packageManager", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "<set-?>", "_windowInfo", "get_windowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "set_windowInfo", "(Landroidx/compose/ui/platform/WindowInfo;)V", "_windowInfo$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/UiMediaScope$Posture;", "_windowPosture", "get_windowPosture-m18o9QQ", "()Ljava/lang/String;", "set_windowPosture-InyEWag", "(Ljava/lang/String;)V", "_windowPosture$delegate", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "_anyPointer", "get_anyPointer-fpxItnM", "set_anyPointer-ZYK4Wgo", "_anyPointer$delegate", "isDocked", "()Z", "setDocked", "(Z)V", "isDocked$delegate", "isImeVisible", "setImeVisible", "isImeVisible$delegate", "hasPhysicalKeyboard", "getHasPhysicalKeyboard", "setHasPhysicalKeyboard", "hasPhysicalKeyboard$delegate", "hasMicrophone", "getHasMicrophone", "hasCamera", "getHasCamera", "windowWidth", "Landroidx/compose/ui/unit/Dp;", "getWindowWidth-D9Ej5fM", "()F", "windowHeight", "getWindowHeight-D9Ej5fM", "windowPosture", "getWindowPosture-m18o9QQ", "pointerPrecision", "getPointerPrecision-fpxItnM", "keyboardKind", "Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "getKeyboardKind-J9_QTjY", "viewingDistance", "Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "getViewingDistance-tKro-MQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UiMediaScopeImpl implements UiMediaScope {
    public static final int $stable = 0;
    private final MutableState _anyPointer$delegate;
    private final MutableState _windowInfo$delegate;
    private final MutableState _windowPosture$delegate;
    private final MutableState hasPhysicalKeyboard$delegate;
    private final MutableState isDocked$delegate;
    private final MutableState isImeVisible$delegate;
    private final PackageManager packageManager;

    public UiMediaScopeImpl(Context context, InputManager inputManager, WindowInfo windowInfo, boolean z) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        String resolvePointerPrecision;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        boolean hasPhysicalKeyboard;
        MutableState mutableStateOf$default6;
        this.packageManager = context.getPackageManager();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInfo, null, 2, null);
        this._windowInfo$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UiMediaScope.Posture.m4821boximpl(UiMediaScope.Posture.Companion.m4829getFlatm18o9QQ()), null, 2, null);
        this._windowPosture$delegate = mutableStateOf$default2;
        resolvePointerPrecision = MediaQuery_androidKt.resolvePointerPrecision(inputManager);
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(UiMediaScope.PointerPrecision.m4810boximpl(resolvePointerPrecision), null, 2, null);
        this._anyPointer$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isDocked$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.isImeVisible$delegate = mutableStateOf$default5;
        hasPhysicalKeyboard = MediaQuery_androidKt.hasPhysicalKeyboard(inputManager);
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(hasPhysicalKeyboard), null, 2, null);
        this.hasPhysicalKeyboard$delegate = mutableStateOf$default6;
    }

    public final WindowInfo get_windowInfo() {
        return (WindowInfo) this._windowInfo$delegate.getValue();
    }

    public final void set_windowInfo(WindowInfo windowInfo) {
        this._windowInfo$delegate.setValue(windowInfo);
    }

    /* renamed from: get_windowPosture-m18o9QQ  reason: not valid java name */
    public final String m4842get_windowPosturem18o9QQ() {
        return ((UiMediaScope.Posture) this._windowPosture$delegate.getValue()).m4827unboximpl();
    }

    /* renamed from: set_windowPosture-InyEWag  reason: not valid java name */
    public final void m4844set_windowPostureInyEWag(String str) {
        this._windowPosture$delegate.setValue(UiMediaScope.Posture.m4821boximpl(str));
    }

    /* renamed from: get_anyPointer-fpxItnM  reason: not valid java name */
    public final String m4841get_anyPointerfpxItnM() {
        return ((UiMediaScope.PointerPrecision) this._anyPointer$delegate.getValue()).m4816unboximpl();
    }

    /* renamed from: set_anyPointer-ZYK4Wgo  reason: not valid java name */
    public final void m4843set_anyPointerZYK4Wgo(String str) {
        this._anyPointer$delegate.setValue(UiMediaScope.PointerPrecision.m4810boximpl(str));
    }

    public final boolean isDocked() {
        return ((Boolean) this.isDocked$delegate.getValue()).booleanValue();
    }

    public final void setDocked(boolean z) {
        this.isDocked$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isImeVisible() {
        return ((Boolean) this.isImeVisible$delegate.getValue()).booleanValue();
    }

    public final void setImeVisible(boolean z) {
        this.isImeVisible$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getHasPhysicalKeyboard() {
        return ((Boolean) this.hasPhysicalKeyboard$delegate.getValue()).booleanValue();
    }

    public final void setHasPhysicalKeyboard(boolean z) {
        this.hasPhysicalKeyboard$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.ui.UiMediaScope
    public boolean getHasMicrophone() {
        boolean isMicAvailable;
        isMicAvailable = MediaQuery_androidKt.isMicAvailable(this.packageManager);
        return isMicAvailable;
    }

    @Override // androidx.compose.ui.UiMediaScope
    public boolean getHasCamera() {
        boolean isCameraAvailable;
        isCameraAvailable = MediaQuery_androidKt.isCameraAvailable(this.packageManager);
        return isCameraAvailable;
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* renamed from: getWindowWidth-D9Ej5fM */
    public float mo4799getWindowWidthD9Ej5fM() {
        return DpSize.m8258getWidthD9Ej5fM(get_windowInfo().mo7324getContainerDpSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* renamed from: getWindowHeight-D9Ej5fM */
    public float mo4797getWindowHeightD9Ej5fM() {
        return DpSize.m8256getHeightD9Ej5fM(get_windowInfo().mo7324getContainerDpSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* renamed from: getWindowPosture-m18o9QQ */
    public String mo4798getWindowPosturem18o9QQ() {
        return m4842get_windowPosturem18o9QQ();
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* renamed from: getPointerPrecision-fpxItnM */
    public String mo4795getPointerPrecisionfpxItnM() {
        return m4841get_anyPointerfpxItnM();
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* renamed from: getKeyboardKind-J9_QTjY */
    public String mo4794getKeyboardKindJ9_QTjY() {
        return getHasPhysicalKeyboard() ? UiMediaScope.KeyboardKind.Companion.m4808getPhysicalJ9_QTjY() : isImeVisible() ? UiMediaScope.KeyboardKind.Companion.m4809getVirtualJ9_QTjY() : UiMediaScope.KeyboardKind.Companion.m4807getNoneJ9_QTjY();
    }

    @Override // androidx.compose.ui.UiMediaScope
    /* renamed from: getViewingDistance-tKro-MQ */
    public String mo4796getViewingDistancetKroMQ() {
        boolean isTvDevice;
        boolean isAutomotiveDevice;
        isTvDevice = MediaQuery_androidKt.isTvDevice(this.packageManager);
        if (isTvDevice) {
            return UiMediaScope.ViewingDistance.Companion.m4838getFartKroMQ();
        }
        isAutomotiveDevice = MediaQuery_androidKt.isAutomotiveDevice(this.packageManager);
        if (isAutomotiveDevice || isDocked()) {
            return UiMediaScope.ViewingDistance.Companion.m4839getMediumtKroMQ();
        }
        return UiMediaScope.ViewingDistance.Companion.m4840getNeartKroMQ();
    }
}
