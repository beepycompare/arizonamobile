package androidx.window.area.adapter;

import androidx.core.app.NotificationCompat;
import androidx.window.area.WindowAreaCapability;
import kotlin.Metadata;
/* compiled from: WindowAreaAdapterApi4.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/window/area/adapter/WindowAreaAdapterApi4;", "", "<init>", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", NotificationCompat.CATEGORY_STATUS, "", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WindowAreaAdapterApi4 {
    public static final WindowAreaAdapterApi4 INSTANCE = new WindowAreaAdapterApi4();

    private WindowAreaAdapterApi4() {
    }

    public final WindowAreaCapability.Status translate(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return WindowAreaCapability.Status.WINDOW_AREA_STATUS_ACTIVE;
                    }
                    return WindowAreaCapability.Status.WINDOW_AREA_STATUS_UNSUPPORTED;
                }
                return WindowAreaCapability.Status.WINDOW_AREA_STATUS_AVAILABLE;
            }
            return WindowAreaCapability.Status.WINDOW_AREA_STATUS_UNAVAILABLE;
        }
        return WindowAreaCapability.Status.WINDOW_AREA_STATUS_UNSUPPORTED;
    }
}
