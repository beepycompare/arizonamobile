package com.google.android.gms.internal.measurement;

import com.google.common.base.Joiner;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzsp {
    private static final Pattern zza = Pattern.compile("(\\w+).*");

    public static String zza(String str) {
        Matcher matcher = zza.matcher(str);
        if (!matcher.matches()) {
            String.valueOf(str);
            throw new IllegalArgumentException("Invalid fragment spec: ".concat(String.valueOf(str)));
        }
        return matcher.group(1);
    }

    @Nullable
    public static String zzb(List list) {
        if (list.isEmpty()) {
            return null;
        }
        String join = Joiner.on("+").join(list);
        String.valueOf(join);
        return "transform=".concat(String.valueOf(join));
    }
}
