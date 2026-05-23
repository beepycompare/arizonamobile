package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: InputModeManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/input/InputModeManager;", "initialInputMode", "Landroidx/compose/ui/input/InputMode;", "onRequestInputModeChange", "Landroidx/compose/ui/input/InputModeChangeRequester;", "<init>", "(ILandroidx/compose/ui/input/InputModeChangeRequester;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "inputMode", "getInputMode-aOaMEAU", "()I", "setInputMode-iuPiT84", "(I)V", "inputMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestInputMode", "", "requestInputMode-iuPiT84", "(I)Z", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InputModeManagerImpl implements InputModeManager {
    public static final int $stable = 8;
    private final MutableState inputMode$delegate;
    private final InputModeChangeRequester onRequestInputModeChange;

    public /* synthetic */ InputModeManagerImpl(int i, InputModeChangeRequester inputModeChangeRequester, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, inputModeChangeRequester);
    }

    private InputModeManagerImpl(int i, InputModeChangeRequester inputModeChangeRequester) {
        MutableState mutableStateOf$default;
        this.onRequestInputModeChange = inputModeChangeRequester;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m6151boximpl(i), null, 2, null);
        this.inputMode$delegate = mutableStateOf$default;
    }

    @Override // androidx.compose.ui.input.InputModeManager
    /* renamed from: getInputMode-aOaMEAU */
    public int mo6161getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m6157unboximpl();
    }

    /* renamed from: setInputMode-iuPiT84  reason: not valid java name */
    public void m6163setInputModeiuPiT84(int i) {
        this.inputMode$delegate.setValue(InputMode.m6151boximpl(i));
    }

    @Override // androidx.compose.ui.input.InputModeManager
    /* renamed from: requestInputMode-iuPiT84 */
    public boolean mo6162requestInputModeiuPiT84(int i) {
        return this.onRequestInputModeChange.mo6160requestiuPiT84(i);
    }
}
