package kotlinx.serialization.json;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.json.internal.StringOpsKt;
/* compiled from: JsonElement.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001\"B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0011\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0096\u0001J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0003J\t\u0010\u0013\u001a\u00020\bH\u0096\u0001R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00160\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", FirebaseAnalytics.Param.CONTENT, "<init>", "(Ljava/util/Map;)V", "equals", "", "other", "", "hashCode", "", "toString", "containsKey", "key", "containsValue", "value", "get", "isEmpty", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "", "getEntries", "()Ljava/util/Set;", UserMetadata.KEYDATA_FILENAME, "getKeys", "size", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable(with = JsonObjectSerializer.class)
/* loaded from: classes5.dex */
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final Map<String, JsonElement> content;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement compute(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: compute  reason: avoid collision after fix types in other method */
    public JsonElement compute2(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement computeIfAbsent(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfAbsent  reason: avoid collision after fix types in other method */
    public JsonElement computeIfAbsent2(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement computeIfPresent(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfPresent  reason: avoid collision after fix types in other method */
    public JsonElement computeIfPresent2(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.containsKey(key);
    }

    public boolean containsValue(JsonElement value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.content.containsValue(value);
    }

    public JsonElement get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.content.get(key);
    }

    public Set<Map.Entry<String, JsonElement>> getEntries() {
        return this.content.entrySet();
    }

    public Set<String> getKeys() {
        return this.content.keySet();
    }

    public int getSize() {
        return this.content.size();
    }

    public Collection<JsonElement> getValues() {
        return this.content.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement merge(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: merge  reason: avoid collision after fix types in other method */
    public JsonElement merge2(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement put(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public JsonElement put2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement putIfAbsent(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: putIfAbsent  reason: avoid collision after fix types in other method */
    public JsonElement putIfAbsent2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ JsonElement replace(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public JsonElement replace2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public boolean replace2(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* compiled from: JsonElement.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/json/JsonObject$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<JsonObject> serializer() {
            return JsonObjectSerializer.INSTANCE;
        }
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof JsonElement) {
            return containsValue((JsonElement) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, JsonElement>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    /* renamed from: get  reason: avoid collision after fix types in other method */
    public final /* bridge */ JsonElement get2(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<JsonElement> values() {
        return getValues();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public JsonObject(Map<String, ? extends JsonElement> content) {
        super(null);
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Intrinsics.areEqual(this.content, obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.content.entrySet(), StringUtils.COMMA, "{", "}", 0, null, new Function1() { // from class: kotlinx.serialization.json.JsonObject$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence string$lambda$1;
                string$lambda$1 = JsonObject.toString$lambda$1((Map.Entry) obj);
                return string$lambda$1;
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$1(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        StringBuilder sb = new StringBuilder();
        StringOpsKt.printQuoted(sb, (String) entry.getKey());
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append((JsonElement) entry.getValue());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
