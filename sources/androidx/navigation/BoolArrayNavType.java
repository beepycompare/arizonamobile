package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NavType.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Landroidx/navigation/BoolArrayNavType;", "Landroidx/navigation/CollectionNavType;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "put", "", "bundle", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "key", "value", "get", "parseValue", "previousValue", "valueEquals", "", "other", "serializeAsValues", "", "emptyCollection", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoolArrayNavType extends CollectionNavType<boolean[]> {
    @Override // androidx.navigation.CollectionNavType
    public boolean[] emptyCollection() {
        return new boolean[0];
    }

    public BoolArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "boolean[]";
    }

    @Override // androidx.navigation.NavType
    public boolean[] parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new boolean[]{NavType.BoolType.parseValue(value).booleanValue()};
    }

    @Override // androidx.navigation.NavType
    public boolean[] parseValue(String value, boolean[] zArr) {
        boolean[] plus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (zArr == null || (plus = ArraysKt.plus(zArr, parseValue(value))) == null) ? parseValue(value) : plus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(boolean[] zArr, boolean[] zArr2) {
        return ArraysKt.contentDeepEquals(zArr != null ? ArraysKt.toTypedArray(zArr) : null, zArr2 != null ? ArraysKt.toTypedArray(zArr2) : null);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(boolean[] zArr) {
        List<Boolean> list;
        if (zArr == null || (list = ArraysKt.toList(zArr)) == null) {
            return CollectionsKt.emptyList();
        }
        List<Boolean> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Boolean bool : list2) {
            arrayList.add(String.valueOf(bool.booleanValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, boolean[] zArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle m7665constructorimpl = SavedStateWriter.m7665constructorimpl(bundle);
        if (zArr != null) {
            SavedStateWriter.m7672putBooleanArrayimpl(m7665constructorimpl, key, zArr);
        } else {
            SavedStateWriter.m7688putNullimpl(m7665constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public boolean[] get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle m7579constructorimpl = SavedStateReader.m7579constructorimpl(bundle);
        if (!SavedStateReader.m7580containsimpl(m7579constructorimpl, key) || SavedStateReader.m7658isNullimpl(m7579constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m7589getBooleanArrayimpl(m7579constructorimpl, key);
    }
}
