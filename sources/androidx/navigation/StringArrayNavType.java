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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0014J-\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0016J-\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u001aJ#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, d2 = {"Landroidx/navigation/StringArrayNavType;", "Landroidx/navigation/CollectionNavType;", "", "", "<init>", "()V", "name", "getName", "()Ljava/lang/String;", "put", "", "bundle", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "key", "value", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "parseValue", "(Ljava/lang/String;)[Ljava/lang/String;", "previousValue", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "valueEquals", "", "other", "([Ljava/lang/String;[Ljava/lang/String;)Z", "serializeAsValues", "", "([Ljava/lang/String;)Ljava/util/List;", "emptyCollection", "()[Ljava/lang/String;", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringArrayNavType extends CollectionNavType<String[]> {
    @Override // androidx.navigation.CollectionNavType
    public String[] emptyCollection() {
        return new String[0];
    }

    public StringArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "string[]";
    }

    @Override // androidx.navigation.NavType
    public String[] parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new String[]{value};
    }

    @Override // androidx.navigation.NavType
    public String[] parseValue(String value, String[] strArr) {
        String[] strArr2;
        Intrinsics.checkNotNullParameter(value, "value");
        return (strArr == null || (strArr2 = (String[]) ArraysKt.plus((Object[]) strArr, (Object[]) parseValue(value))) == null) ? parseValue(value) : strArr2;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(String[] strArr, String[] strArr2) {
        return ArraysKt.contentDeepEquals(strArr, strArr2);
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, String[] strArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundle);
        if (strArr != null) {
            SavedStateWriter.m7700putStringArrayimpl(m7666constructorimpl, key, strArr);
        } else {
            SavedStateWriter.m7689putNullimpl(m7666constructorimpl, key);
        }
    }

    @Override // androidx.navigation.NavType
    public String[] get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
        if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
            return null;
        }
        return SavedStateReader.m7652getStringArrayimpl(m7580constructorimpl, key);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(String[] strArr) {
        if (strArr == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(NavUriUtils.encode$default(NavUriUtils.INSTANCE, str, null, 2, null));
        }
        return arrayList;
    }
}
