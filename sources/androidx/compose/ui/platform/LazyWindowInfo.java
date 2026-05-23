package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidWindowInfo.android.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bJ\u0016\u0010\u001b\u001a\u00020\u00192\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Landroidx/compose/ui/platform/LazyWindowInfo;", "Landroidx/compose/ui/platform/WindowInfo;", "<init>", "()V", "onInitializeContainerSize", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/DerivedSize;", "_containerSize", "Landroidx/compose/runtime/MutableState;", "<set-?>", "", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "isWindowFocused$delegate", "Landroidx/compose/runtime/MutableState;", "value", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "updateContainerSizeIfObserved", "", "calculateContainerSize", "setOnInitializeContainerSize", "containerSize", "Landroidx/compose/ui/unit/IntSize;", "getContainerSize-YbymL2g", "()J", "containerDpSize", "Landroidx/compose/ui/unit/DpSize;", "getContainerDpSize-MYxV2XQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LazyWindowInfo implements WindowInfo {
    public static final int $stable = 0;
    private MutableState<DerivedSize> _containerSize;
    private final MutableState isWindowFocused$delegate;
    private Function0<DerivedSize> onInitializeContainerSize;

    public LazyWindowInfo() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isWindowFocused$delegate = mutableStateOf$default;
    }

    public static final /* synthetic */ MutableState access$get_containerSize$p(LazyWindowInfo lazyWindowInfo) {
        return lazyWindowInfo._containerSize;
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return ((Boolean) this.isWindowFocused$delegate.getValue()).booleanValue();
    }

    public void setWindowFocused(boolean z) {
        this.isWindowFocused$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getKeyboardModifiers-k7X9c1A */
    public int mo7326getKeyboardModifiersk7X9c1A() {
        return WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui().getValue().m6754unboximpl();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0 */
    public void m7327setKeyboardModifiers5xRPYO0(int i) {
        WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui().setValue(PointerKeyboardModifiers.m6748boximpl(i));
    }

    public final void updateContainerSizeIfObserved(Function0<DerivedSize> function0) {
        MutableState mutableState = this._containerSize;
        if (mutableState != null) {
            mutableState.setValue(function0.invoke());
        }
    }

    public final void setOnInitializeContainerSize(Function0<DerivedSize> function0) {
        if (this._containerSize == null) {
            this.onInitializeContainerSize = function0;
        }
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getContainerSize-YbymL2g */
    public long mo7325getContainerSizeYbymL2g() {
        DerivedSize zero;
        MutableState<DerivedSize> mutableStateOf$default;
        if (this._containerSize == null) {
            Function0<DerivedSize> function0 = this.onInitializeContainerSize;
            if (function0 == null || (zero = function0.invoke()) == null) {
                zero = DerivedSize.Companion.getZero();
            }
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(zero, null, 2, null);
            this._containerSize = mutableStateOf$default;
            this.onInitializeContainerSize = null;
        }
        MutableState<DerivedSize> mutableState = this._containerSize;
        Intrinsics.checkNotNull(mutableState);
        return mutableState.getValue().m7293getPxSizeYbymL2g();
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getContainerDpSize-MYxV2XQ */
    public long mo7324getContainerDpSizeMYxV2XQ() {
        DerivedSize zero;
        MutableState<DerivedSize> mutableStateOf$default;
        if (this._containerSize == null) {
            Function0<DerivedSize> function0 = this.onInitializeContainerSize;
            if (function0 == null || (zero = function0.invoke()) == null) {
                zero = DerivedSize.Companion.getZero();
            }
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(zero, null, 2, null);
            this._containerSize = mutableStateOf$default;
            this.onInitializeContainerSize = null;
        }
        MutableState<DerivedSize> mutableState = this._containerSize;
        Intrinsics.checkNotNull(mutableState);
        return mutableState.getValue().m7292getDpSizeMYxV2XQ();
    }
}
