package androidx.media3.extractor.text.ssa;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes2.dex */
final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int i, int i2, int i3, int i4, int i5) {
        this.startTimeIndex = i;
        this.endTimeIndex = i2;
        this.styleIndex = i3;
        this.textIndex = i4;
        this.length = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SsaDialogueFormat fromFormatLine(String str) {
        char c;
        Assertions.checkArgument(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring("Format:".length()), StringUtils.COMMA);
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < split.length; i5++) {
            String lowerCase = Ascii.toLowerCase(split[i5].trim());
            lowerCase.hashCode();
            switch (lowerCase.hashCode()) {
                case 100571:
                    if (lowerCase.equals(TtmlNode.END)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (lowerCase.equals("text")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (lowerCase.equals(TtmlNode.START)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (lowerCase.equals("style")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    i2 = i5;
                    break;
                case 1:
                    i4 = i5;
                    break;
                case 2:
                    i = i5;
                    break;
                case 3:
                    i3 = i5;
                    break;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i, i2, i3, i4, split.length);
    }
}
