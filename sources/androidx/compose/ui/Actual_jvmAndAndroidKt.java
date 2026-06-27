package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
/* compiled from: Actual.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\b\u001a\u00020\t*\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0000¨\u0006\r"}, d2 = {"currentTimeMillis", "", "areObjectsOfSameType", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", "classKeyForObject", "tryPopulateReflectively", "", "Landroidx/compose/ui/platform/InspectorInfo;", "element", "Landroidx/compose/ui/node/ModifierNodeElement;", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Actual_jvmAndAndroidKt {
    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static final boolean areObjectsOfSameType(Object obj, Object obj2) {
        return obj.getClass() == obj2.getClass();
    }

    public static final Object classKeyForObject(Object obj) {
        return obj.getClass();
    }

    public static final void tryPopulateReflectively(InspectorInfo inspectorInfo, ModifierNodeElement<?> modifierNodeElement) {
        List sortedWith = ArraysKt.sortedWith(modifierNodeElement.getClass().getDeclaredFields(), new Comparator() { // from class: androidx.compose.ui.Actual_jvmAndAndroidKt$tryPopulateReflectively$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Field) t).getName(), ((Field) t2).getName());
            }
        });
        int size = sortedWith.size();
        for (int i = 0; i < size; i++) {
            Field field = (Field) sortedWith.get(i);
            if (!field.getDeclaringClass().isAssignableFrom(ModifierNodeElement.class)) {
                try {
                    field.setAccessible(true);
                    inspectorInfo.getProperties().set(field.getName(), field.get(modifierNodeElement));
                } catch (IllegalAccessException | SecurityException unused) {
                }
            }
        }
    }
}
