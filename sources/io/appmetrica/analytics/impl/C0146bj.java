package io.appmetrica.analytics.impl;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.bj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0146bj {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:3:0x0003, B:9:0x0011, B:11:0x0020), top: B:27:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011 A[Catch: all -> 0x0030, TRY_ENTER, TryCatch #0 {all -> 0x0030, blocks: (B:3:0x0003, B:9:0x0011, B:11:0x0020), top: B:27:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ScreenInfo a(Context context) {
        Point point;
        int i;
        float f;
        DisplayMetrics displayMetrics;
        Display display;
        if (AndroidUtils.isApiAchieved(30)) {
            try {
                display = context.getDisplay();
            } catch (Throwable unused) {
            }
            if (display == null) {
                display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            if (display != null) {
                point = (Point) SystemServiceUtils.accessSystemServiceSafely(display, "getting display metrics", "Display", new C0120aj());
                if (point == null) {
                    return null;
                }
                int max = Math.max(point.x, point.y);
                int min = Math.min(point.x, point.y);
                try {
                    displayMetrics = context.getResources().getDisplayMetrics();
                    i = displayMetrics.densityDpi;
                } catch (Throwable unused2) {
                    i = 0;
                }
                try {
                    f = displayMetrics.density;
                } catch (Throwable unused3) {
                    f = 0.0f;
                    return new ScreenInfo(max, min, i, f);
                }
                return new ScreenInfo(max, min, i, f);
            }
            point = null;
            if (point == null) {
            }
        }
        display = null;
        if (display == null) {
        }
        if (display != null) {
        }
        point = null;
        if (point == null) {
        }
    }
}
