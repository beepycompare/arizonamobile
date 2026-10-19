package com.arizona.game.diagnostics;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RestartHandoff.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0007J*\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/game/diagnostics/RestartHandoff;", "Landroid/os/Binder;", "<init>", "()V", "decision", "Ljava/util/concurrent/atomic/AtomicInteger;", "hostPaused", "", "getHostPaused", "()Z", "setHostPaused", "(Z)V", "cancelPending", "onTransact", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RestartHandoff extends Binder {
    private static final int ACKNOWLEDGED = 1;
    private static final int CANCELLED = 2;
    private static final String DESCRIPTOR = "com.arizona.game.diagnostics.RestartHandoff";
    private static final int PENDING = 0;
    private final AtomicInteger decision = new AtomicInteger(0);
    private boolean hostPaused;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final boolean getHostPaused() {
        return this.hostPaused;
    }

    public final void setHostPaused(boolean z) {
        this.hostPaused = z;
    }

    public final boolean cancelPending() {
        return this.decision.compareAndSet(0, 2);
    }

    @Override // android.os.Binder
    protected boolean onTransact(int i, Parcel data, Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i != 1 || parcel == null) {
            return super.onTransact(i, data, parcel, i2);
        }
        data.enforceInterface(DESCRIPTOR);
        boolean compareAndSet = this.decision.compareAndSet(0, 1);
        parcel.writeNoException();
        parcel.writeInt(compareAndSet ? 1 : 0);
        return true;
    }

    /* compiled from: RestartHandoff.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arizona/game/diagnostics/RestartHandoff$Companion;", "", "<init>", "()V", "DESCRIPTOR", "", "PENDING", "", "ACKNOWLEDGED", "CANCELLED", "acknowledge", "", "binder", "Landroid/os/IBinder;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean acknowledge(IBinder iBinder) {
            boolean z = false;
            if (iBinder == null) {
                return false;
            }
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain(...)");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "obtain(...)");
            try {
                obtain.writeInterfaceToken(RestartHandoff.DESCRIPTOR);
                if (iBinder.transact(1, obtain, obtain2, 0)) {
                    obtain2.readException();
                    if (obtain2.readInt() == 1) {
                        z = true;
                    }
                }
            } catch (RemoteException unused) {
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            obtain.recycle();
            obtain2.recycle();
            return z;
        }
    }
}
