package ru.mrlargha.ui.kit;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.arizona.ui.kit.R;
/* compiled from: DamageInformerIcons.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"weaponIconCache", "", "", "damageInformerIcons", "weaponId", "context", "Landroid/content/Context;", "ui-kit"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DamageInformerIconsKt {
    private static final Map<Integer, Integer> weaponIconCache = new LinkedHashMap();

    public static final int damageInformerIcons(int i, Context context) {
        int identifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Map<Integer, Integer> map = weaponIconCache;
        Integer valueOf = Integer.valueOf(i);
        Integer num = map.get(valueOf);
        if (num == null) {
            if (i <= 0) {
                identifier = R.drawable.ic_weapon_0;
            } else {
                identifier = context.getResources().getIdentifier("ic_weapon_" + i, "drawable", context.getPackageName());
                if (identifier == 0) {
                    identifier = R.drawable.ic_weapon_0;
                }
            }
            num = Integer.valueOf(identifier);
            map.put(valueOf, num);
        }
        return num.intValue();
    }
}
