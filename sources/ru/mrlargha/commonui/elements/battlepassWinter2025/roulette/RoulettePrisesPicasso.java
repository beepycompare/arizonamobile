package ru.mrlargha.commonui.elements.battlepassWinter2025.roulette;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.data.PossiblePrise;
/* compiled from: RoulettePicasso.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/RoulettePrisesPicasso;", "", "<init>", "()V", "priseList", "", "Lru/mrlargha/commonui/elements/battlepassWinter2025/roulette/data/PossiblePrise;", "isArizona", "", "imageMap", "", "", "Landroid/graphics/Bitmap;", "", "getItem", "id", "", "randomItem", "addPrise", "prise", "getBitmap", "image", "clear", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RoulettePrisesPicasso {
    public static final RoulettePrisesPicasso INSTANCE = new RoulettePrisesPicasso();
    private static List<PossiblePrise> priseList = new ArrayList();
    private static boolean isArizona = true;
    private static Map<String, Bitmap> imageMap = new LinkedHashMap();

    private RoulettePrisesPicasso() {
    }

    public final void isArizona(boolean z) {
        isArizona = z;
    }

    public final PossiblePrise getItem(int i) {
        Object obj;
        Iterator<T> it = priseList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((PossiblePrise) obj).getId() == i) {
                break;
            }
        }
        return (PossiblePrise) obj;
    }

    public final PossiblePrise randomItem() {
        try {
            try {
                return getItem(Random.Default.nextInt(priseList.size()));
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
            return (PossiblePrise) CollectionsKt.firstOrNull((List<? extends Object>) priseList);
        }
    }

    public final void addPrise(PossiblePrise prise) {
        Intrinsics.checkNotNullParameter(prise, "prise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RoulettePrisesPicasso$addPrise$1(prise, null), 3, null);
        priseList.add(prise);
    }

    public final Bitmap getBitmap(String image) {
        Intrinsics.checkNotNullParameter(image, "image");
        Bitmap bitmap = imageMap.get(image);
        if (bitmap != null) {
            return bitmap;
        }
        return null;
    }

    public final void clear() {
        imageMap.clear();
        priseList.clear();
    }
}
