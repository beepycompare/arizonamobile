package androidx.media3.ui;

import android.graphics.Color;
import androidx.media3.common.util.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String toCssRgba(int i) {
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return "." + str + ",." + str + " *";
    }
}
