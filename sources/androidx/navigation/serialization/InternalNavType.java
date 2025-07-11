package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import androidx.navigation.NavUriUtils;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: NavTypeConverter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\bR!\u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR!\u0010\u001d\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\bR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u001f\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Landroidx/navigation/serialization/InternalNavType;", "", "<init>", "()V", "IntNullableType", "Landroidx/navigation/NavType;", "", "getIntNullableType", "()Landroidx/navigation/NavType;", "BoolNullableType", "", "getBoolNullableType", "DoubleType", "", "getDoubleType", "DoubleNullableType", "getDoubleNullableType", "FloatNullableType", "", "getFloatNullableType", "LongNullableType", "", "getLongNullableType", "StringNonNullableType", "", "getStringNonNullableType", "StringNullableArrayType", "", "getStringNullableArrayType", "StringNullableListType", "", "getStringNullableListType", "DoubleArrayType", "", "getDoubleArrayType", "DoubleListType", "getDoubleListType", "navigation-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InternalNavType {
    public static final InternalNavType INSTANCE = new InternalNavType();
    private static final NavType<Integer> IntNullableType = new NavType<Integer>() { // from class: androidx.navigation.serialization.InternalNavType$IntNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "integer_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
                return null;
            }
            return NavType.IntType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Integer num) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (num == null) {
                SavedStateWriter.m7689putNullimpl(SavedStateWriter.m7666constructorimpl(bundle), key);
            } else {
                NavType.IntType.put(bundle, key, num);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Integer get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return Integer.valueOf(SavedStateReader.m7611getIntimpl(m7580constructorimpl, key));
        }
    };
    private static final NavType<Boolean> BoolNullableType = new NavType<Boolean>() { // from class: androidx.navigation.serialization.InternalNavType$BoolNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "boolean_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
                return null;
            }
            return NavType.BoolType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Boolean bool) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (bool == null) {
                SavedStateWriter.m7689putNullimpl(SavedStateWriter.m7666constructorimpl(bundle), key);
            } else {
                NavType.BoolType.put(bundle, key, bool);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Boolean get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return Boolean.valueOf(SavedStateReader.m7589getBooleanimpl(m7580constructorimpl, key));
        }
    };
    private static final NavType<Double> DoubleType = new NavType<Double>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleType$1
        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Double d) {
            put(bundle, str, d.doubleValue());
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "double";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Double.valueOf(Double.parseDouble(value));
        }

        public void put(Bundle bundle, String key, double d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            SavedStateWriter.m7679putDoubleimpl(SavedStateWriter.m7666constructorimpl(bundle), key, d);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return Double.valueOf(SavedStateReader.m7603getDoubleimpl(SavedStateReader.m7580constructorimpl(bundle), key));
        }
    };
    private static final NavType<Double> DoubleNullableType = new NavType<Double>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "double_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
                return null;
            }
            return InternalNavType.INSTANCE.getDoubleType().parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Double d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (d == null) {
                SavedStateWriter.m7689putNullimpl(SavedStateWriter.m7666constructorimpl(bundle), key);
            } else {
                InternalNavType.INSTANCE.getDoubleType().put(bundle, key, d);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Double get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return Double.valueOf(SavedStateReader.m7603getDoubleimpl(m7580constructorimpl, key));
        }
    };
    private static final NavType<Float> FloatNullableType = new NavType<Float>() { // from class: androidx.navigation.serialization.InternalNavType$FloatNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "float_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
                return null;
            }
            return NavType.FloatType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Float f) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (f == null) {
                SavedStateWriter.m7689putNullimpl(SavedStateWriter.m7666constructorimpl(bundle), key);
            } else {
                NavType.FloatType.put(bundle, key, f);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Float get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return Float.valueOf(SavedStateReader.m7607getFloatimpl(m7580constructorimpl, key));
        }
    };
    private static final NavType<Long> LongNullableType = new NavType<Long>() { // from class: androidx.navigation.serialization.InternalNavType$LongNullableType$1
        @Override // androidx.navigation.NavType
        public String getName() {
            return "long_nullable";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
                return null;
            }
            return NavType.LongType.parseValue(value);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, Long l) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (l == null) {
                SavedStateWriter.m7689putNullimpl(SavedStateWriter.m7666constructorimpl(bundle), key);
            } else {
                NavType.LongType.put(bundle, key, l);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.navigation.NavType
        public Long get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return Long.valueOf(SavedStateReader.m7621getLongimpl(m7580constructorimpl, key));
        }
    };
    private static final NavType<String> StringNonNullableType = new NavType<String>() { // from class: androidx.navigation.serialization.InternalNavType$StringNonNullableType$1
        @Override // androidx.navigation.NavType
        public String parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "string_non_nullable";
        }

        @Override // androidx.navigation.NavType
        public String serializeAsValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return NavUriUtils.encode$default(NavUriUtils.INSTANCE, value, null, 2, null);
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, String value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            SavedStateWriter.m7699putStringimpl(SavedStateWriter.m7666constructorimpl(bundle), key, value);
        }

        @Override // androidx.navigation.NavType
        public String get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            return (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) ? AbstractJsonLexerKt.NULL : SavedStateReader.m7651getStringimpl(m7580constructorimpl, key);
        }
    };
    private static final NavType<String[]> StringNullableArrayType = new CollectionNavType<String[]>() { // from class: androidx.navigation.serialization.InternalNavType$StringNullableArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public String[] emptyCollection() {
            return new String[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "string_nullable[]";
        }

        @Override // androidx.navigation.NavType
        public String[] parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new String[]{NavType.StringType.parseValue(value)};
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
            if (strArr == null) {
                SavedStateWriter.m7689putNullimpl(m7666constructorimpl, key);
                return;
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (str == null) {
                    str = AbstractJsonLexerKt.NULL;
                }
                arrayList.add(str);
            }
            SavedStateWriter.m7700putStringArrayimpl(m7666constructorimpl, key, (String[]) arrayList.toArray(new String[0]));
        }

        @Override // androidx.navigation.NavType
        public String[] get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            String[] m7652getStringArrayimpl = SavedStateReader.m7652getStringArrayimpl(m7580constructorimpl, key);
            ArrayList arrayList = new ArrayList(m7652getStringArrayimpl.length);
            for (String str : m7652getStringArrayimpl) {
                arrayList.add(NavType.StringType.parseValue(str));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(String[] strArr) {
            String str;
            if (strArr == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str2 : strArr) {
                if (str2 == null || (str = NavUriUtils.encode$default(NavUriUtils.INSTANCE, str2, null, 2, null)) == null) {
                    str = AbstractJsonLexerKt.NULL;
                }
                arrayList.add(str);
            }
            return arrayList;
        }
    };
    private static final NavType<List<String>> StringNullableListType = new CollectionNavType<List<? extends String>>() { // from class: androidx.navigation.serialization.InternalNavType$StringNullableListType$1
        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends String> list) {
            return serializeAsValues2((List<String>) list);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<String?>";
        }

        @Override // androidx.navigation.NavType
        public List<String> parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CollectionsKt.listOf(NavType.StringType.parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<String> parseValue(String value, List<String> list) {
            List<String> plus;
            Intrinsics.checkNotNullParameter(value, "value");
            return (list == null || (plus = CollectionsKt.plus((Collection) list, (Iterable) parseValue(value))) == null) ? parseValue(value) : plus;
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<String> list, List<String> list2) {
            return ArraysKt.contentDeepEquals(list != null ? (String[]) list.toArray(new String[0]) : null, list2 != null ? (String[]) list2.toArray(new String[0]) : null);
        }

        /* renamed from: serializeAsValues  reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<String> list) {
            String str;
            if (list != null) {
                List<String> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (String str2 : list2) {
                    if (str2 == null || (str = NavUriUtils.encode$default(NavUriUtils.INSTANCE, str2, null, 2, null)) == null) {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    arrayList.add(str);
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends String> emptyCollection() {
            return CollectionsKt.emptyList();
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<String> list) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundle);
            if (list == null) {
                SavedStateWriter.m7689putNullimpl(m7666constructorimpl, key);
                return;
            }
            List<String> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str : list2) {
                if (str == null) {
                    str = AbstractJsonLexerKt.NULL;
                }
                arrayList.add(str);
            }
            SavedStateWriter.m7700putStringArrayimpl(m7666constructorimpl, key, (String[]) arrayList.toArray(new String[0]));
        }

        @Override // androidx.navigation.NavType
        public List<String> get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            List<String> list = ArraysKt.toList(SavedStateReader.m7652getStringArrayimpl(m7580constructorimpl, key));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str : list) {
                arrayList.add(NavType.StringType.parseValue(str));
            }
            return arrayList;
        }
    };
    private static final NavType<double[]> DoubleArrayType = new CollectionNavType<double[]>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleArrayType$1
        @Override // androidx.navigation.CollectionNavType
        public double[] emptyCollection() {
            return new double[0];
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "double[]";
        }

        @Override // androidx.navigation.NavType
        public double[] parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new double[]{InternalNavType.INSTANCE.getDoubleType().parseValue(value).doubleValue()};
        }

        @Override // androidx.navigation.NavType
        public double[] parseValue(String value, double[] dArr) {
            double[] plus;
            Intrinsics.checkNotNullParameter(value, "value");
            return (dArr == null || (plus = ArraysKt.plus(dArr, parseValue(value))) == null) ? parseValue(value) : plus;
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(double[] dArr, double[] dArr2) {
            return ArraysKt.contentDeepEquals(dArr != null ? ArraysKt.toTypedArray(dArr) : null, dArr2 != null ? ArraysKt.toTypedArray(dArr2) : null);
        }

        @Override // androidx.navigation.CollectionNavType
        public List<String> serializeAsValues(double[] dArr) {
            List<Double> list;
            if (dArr == null || (list = ArraysKt.toList(dArr)) == null) {
                return CollectionsKt.emptyList();
            }
            List<Double> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Number number : list2) {
                arrayList.add(String.valueOf(number.doubleValue()));
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, double[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundle);
            if (dArr == null) {
                SavedStateWriter.m7689putNullimpl(m7666constructorimpl, key);
            } else {
                SavedStateWriter.m7680putDoubleArrayimpl(m7666constructorimpl, key, dArr);
            }
        }

        @Override // androidx.navigation.NavType
        public double[] get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return SavedStateReader.m7604getDoubleArrayimpl(m7580constructorimpl, key);
        }
    };
    private static final NavType<List<Double>> DoubleListType = new CollectionNavType<List<? extends Double>>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleListType$1
        @Override // androidx.navigation.CollectionNavType
        public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Double> list) {
            return serializeAsValues2((List<Double>) list);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            return "List<Double>";
        }

        @Override // androidx.navigation.NavType
        public List<Double> parseValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CollectionsKt.listOf(InternalNavType.INSTANCE.getDoubleType().parseValue(value));
        }

        @Override // androidx.navigation.NavType
        public List<Double> parseValue(String value, List<Double> list) {
            List<Double> plus;
            Intrinsics.checkNotNullParameter(value, "value");
            return (list == null || (plus = CollectionsKt.plus((Collection) list, (Iterable) parseValue(value))) == null) ? parseValue(value) : plus;
        }

        @Override // androidx.navigation.NavType
        public boolean valueEquals(List<Double> list, List<Double> list2) {
            return ArraysKt.contentDeepEquals(list != null ? (Double[]) list.toArray(new Double[0]) : null, list2 != null ? (Double[]) list2.toArray(new Double[0]) : null);
        }

        /* renamed from: serializeAsValues  reason: avoid collision after fix types in other method */
        public List<String> serializeAsValues2(List<Double> list) {
            if (list != null) {
                List<Double> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Number number : list2) {
                    arrayList.add(String.valueOf(number.doubleValue()));
                }
                return arrayList;
            }
            return CollectionsKt.emptyList();
        }

        @Override // androidx.navigation.CollectionNavType
        public List<? extends Double> emptyCollection() {
            return CollectionsKt.emptyList();
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle bundle, String key, List<Double> list) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7666constructorimpl = SavedStateWriter.m7666constructorimpl(bundle);
            if (list == null) {
                SavedStateWriter.m7689putNullimpl(m7666constructorimpl, key);
            } else {
                SavedStateWriter.m7680putDoubleArrayimpl(m7666constructorimpl, key, CollectionsKt.toDoubleArray(list));
            }
        }

        @Override // androidx.navigation.NavType
        public List<Double> get(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle m7580constructorimpl = SavedStateReader.m7580constructorimpl(bundle);
            if (!SavedStateReader.m7581containsimpl(m7580constructorimpl, key) || SavedStateReader.m7659isNullimpl(m7580constructorimpl, key)) {
                return null;
            }
            return ArraysKt.toList(SavedStateReader.m7604getDoubleArrayimpl(m7580constructorimpl, key));
        }
    };

    private InternalNavType() {
    }

    public final NavType<Integer> getIntNullableType() {
        return IntNullableType;
    }

    public final NavType<Boolean> getBoolNullableType() {
        return BoolNullableType;
    }

    public final NavType<Double> getDoubleType() {
        return DoubleType;
    }

    public final NavType<Double> getDoubleNullableType() {
        return DoubleNullableType;
    }

    public final NavType<Float> getFloatNullableType() {
        return FloatNullableType;
    }

    public final NavType<Long> getLongNullableType() {
        return LongNullableType;
    }

    public final NavType<String> getStringNonNullableType() {
        return StringNonNullableType;
    }

    public final NavType<String[]> getStringNullableArrayType() {
        return StringNullableArrayType;
    }

    public final NavType<List<String>> getStringNullableListType() {
        return StringNullableListType;
    }

    public final NavType<double[]> getDoubleArrayType() {
        return DoubleArrayType;
    }

    public final NavType<List<Double>> getDoubleListType() {
        return DoubleListType;
    }
}
