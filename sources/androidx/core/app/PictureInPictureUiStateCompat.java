package androidx.core.app;

import android.app.PictureInPictureUiState;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PictureInPictureUiStateCompat.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/core/app/PictureInPictureUiStateCompat;", "", "isStashed", "", "isTransitioningToPip", "<init>", "(ZZ)V", "()Z", "Companion", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PictureInPictureUiStateCompat {
    public static final Companion Companion = new Companion(null);
    private final boolean isStashed;
    private final boolean isTransitioningToPip;

    @JvmStatic
    public static final PictureInPictureUiStateCompat fromPictureInPictureUiState(PictureInPictureUiState pictureInPictureUiState) {
        return Companion.fromPictureInPictureUiState(pictureInPictureUiState);
    }

    public PictureInPictureUiStateCompat(boolean z, boolean z2) {
        this.isStashed = z;
        this.isTransitioningToPip = z2;
    }

    public final boolean isStashed() {
        return this.isStashed;
    }

    public final boolean isTransitioningToPip() {
        return this.isTransitioningToPip;
    }

    /* compiled from: PictureInPictureUiStateCompat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Landroidx/core/app/PictureInPictureUiStateCompat$Companion;", "", "<init>", "()V", "fromPictureInPictureUiState", "Landroidx/core/app/PictureInPictureUiStateCompat;", "uiState", "Landroid/app/PictureInPictureUiState;", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PictureInPictureUiStateCompat fromPictureInPictureUiState(PictureInPictureUiState uiState) {
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            if (Build.VERSION.SDK_INT >= 35) {
                return new PictureInPictureUiStateCompat(uiState.isStashed(), uiState.isTransitioningToPip());
            }
            if (Build.VERSION.SDK_INT >= 31) {
                return new PictureInPictureUiStateCompat(uiState.isStashed(), false);
            }
            return new PictureInPictureUiStateCompat(false, false);
        }
    }
}
