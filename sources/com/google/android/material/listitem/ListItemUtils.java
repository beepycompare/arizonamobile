package com.google.android.material.listitem;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
/* loaded from: classes4.dex */
class ListItemUtils {
    private ListItemUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isRightAligned(View view) {
        int i;
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams.gravity != -1) {
                i = layoutParams.gravity;
                return (GravityCompat.getAbsoluteGravity(i, view.getLayoutDirection()) & 7) != 5;
            }
        }
        i = GravityCompat.END;
        if ((GravityCompat.getAbsoluteGravity(i, view.getLayoutDirection()) & 7) != 5) {
        }
    }
}
