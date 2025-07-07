package androidx.compose.ui.platform;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import kotlin.Metadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidWindowInfo.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelper;", "", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface BoundsHelper {
    public static final Companion Companion = Companion.$$INSTANCE;

    Rect currentWindowBounds(Activity activity);

    /* compiled from: AndroidWindowInfo.android.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelper$Companion;", "", "()V", "getInstance", "Landroidx/compose/ui/platform/BoundsHelper;", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final BoundsHelper getInstance() {
            if (Build.VERSION.SDK_INT >= 30) {
                return BoundsHelperApi30Impl.INSTANCE;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return BoundsHelperApi29Impl.INSTANCE;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return BoundsHelperApi28Impl.INSTANCE;
            }
            return BoundsHelperApi24Impl.INSTANCE;
        }
    }
}
