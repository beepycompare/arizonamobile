package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: WindowInfo.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006!"}, d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/platform/WindowInfo;", "<init>", "()V", "_containerSize", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "_containerDpSize", "Landroidx/compose/ui/unit/DpSize;", "<set-?>", "", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "isWindowFocused$delegate", "Landroidx/compose/runtime/MutableState;", "value", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "containerSize", "getContainerSize-YbymL2g", "()J", "setContainerSize-ozmzZPI", "(J)V", "containerDpSize", "getContainerDpSize-MYxV2XQ", "setContainerDpSize-EaSLcWc", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WindowInfoImpl implements WindowInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final MutableState<PointerKeyboardModifiers> GlobalKeyboardModifiers;
    private final MutableState<DpSize> _containerDpSize;
    private final MutableState<IntSize> _containerSize;
    private final MutableState isWindowFocused$delegate;

    public WindowInfoImpl() {
        MutableState<IntSize> mutableStateOf$default;
        MutableState<DpSize> mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8323boximpl(IntSize.Companion.m8336getZeroYbymL2g()), null, 2, null);
        this._containerSize = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DpSize.m8246boximpl(DpSize.Companion.m8268getZeroMYxV2XQ()), null, 2, null);
        this._containerDpSize = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isWindowFocused$delegate = mutableStateOf$default3;
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
        return GlobalKeyboardModifiers.getValue().m6754unboximpl();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0  reason: not valid java name */
    public void m7361setKeyboardModifiers5xRPYO0(int i) {
        GlobalKeyboardModifiers.setValue(PointerKeyboardModifiers.m6748boximpl(i));
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getContainerSize-YbymL2g */
    public long mo7325getContainerSizeYbymL2g() {
        return this._containerSize.getValue().m8335unboximpl();
    }

    /* renamed from: setContainerSize-ozmzZPI  reason: not valid java name */
    public void m7360setContainerSizeozmzZPI(long j) {
        this._containerSize.setValue(IntSize.m8323boximpl(j));
    }

    @Override // androidx.compose.ui.platform.WindowInfo
    /* renamed from: getContainerDpSize-MYxV2XQ */
    public long mo7324getContainerDpSizeMYxV2XQ() {
        return this._containerDpSize.getValue().m8266unboximpl();
    }

    /* renamed from: setContainerDpSize-EaSLcWc  reason: not valid java name */
    public void m7359setContainerDpSizeEaSLcWc(long j) {
        this._containerDpSize.setValue(DpSize.m8246boximpl(j));
    }

    /* compiled from: WindowInfo.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl$Companion;", "", "<init>", "()V", "GlobalKeyboardModifiers", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getGlobalKeyboardModifiers$ui", "()Landroidx/compose/runtime/MutableState;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MutableState<PointerKeyboardModifiers> getGlobalKeyboardModifiers$ui() {
            return WindowInfoImpl.GlobalKeyboardModifiers;
        }
    }

    static {
        MutableState<PointerKeyboardModifiers> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PointerKeyboardModifiers.m6748boximpl(PointerEvent_androidKt.EmptyPointerKeyboardModifiers()), null, 2, null);
        GlobalKeyboardModifiers = mutableStateOf$default;
    }
}
