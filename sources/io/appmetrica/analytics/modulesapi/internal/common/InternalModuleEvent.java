package io.appmetrica.analytics.modulesapi.internal.common;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0003#$\"J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002J\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010!\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent;", "", "", "", "getEnvironment", "", "getExtras", "getAttributes", "toString", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "getType", "()I", "type", "b", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "c", "getValue", "value", "d", "Ljava/lang/Integer;", "getServiceDataReporterType", "()Ljava/lang/Integer;", "serviceDataReporterType", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "e", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "getCategory", "()Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "category", "Companion", "Builder", "Category", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class InternalModuleEvent {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f1209a;
    private final String b;
    private final String c;
    private final Integer d;
    private final Category e;
    private final List f;
    private final List g;
    private final List h;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b*\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u000f\u001a\u00020\u00002\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rJ\u001c\u0010\u0012\u001a\u00020\u00002\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rJ\u001c\u0010\u0014\u001a\u00020\u00002\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rJ\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\u001b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106¨\u0006?"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Builder;", "", "", "name", "withName", "value", "withValue", "", "serviceDataReporterType", "withServiceDataReporterType", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "category", "withCategory", "", "environment", "withEnvironment", "", "extras", "withExtras", "attributes", "withAttributes", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent;", "build", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "getType$modules_api_release", "()I", "type", "b", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "c", "getValue", "setValue", "d", "Ljava/lang/Integer;", "getServiceDataReporterType", "()Ljava/lang/Integer;", "setServiceDataReporterType", "(Ljava/lang/Integer;)V", "e", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "getCategory", "()Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "setCategory", "(Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;)V", "f", "Ljava/util/Map;", "getEnvironment", "()Ljava/util/Map;", "setEnvironment", "(Ljava/util/Map;)V", "g", "getExtras", "setExtras", CmcdData.STREAMING_FORMAT_HLS, "getAttributes", "setAttributes", "<init>", "(I)V", "modules-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f1210a;
        private String b;
        private String c;
        private Integer d;
        private Category e;
        private Map f;
        private Map g;
        private Map h;

        public Builder(int i) {
            this.f1210a = i;
        }

        public InternalModuleEvent build() {
            return new InternalModuleEvent(this, null);
        }

        public final Map<String, Object> getAttributes() {
            return this.h;
        }

        public final Category getCategory() {
            return this.e;
        }

        public final Map<String, Object> getEnvironment() {
            return this.f;
        }

        public final Map<String, byte[]> getExtras() {
            return this.g;
        }

        public final String getName() {
            return this.b;
        }

        public final Integer getServiceDataReporterType() {
            return this.d;
        }

        public final int getType$modules_api_release() {
            return this.f1210a;
        }

        public final String getValue() {
            return this.c;
        }

        public final void setAttributes(Map<String, ? extends Object> map) {
            this.h = map;
        }

        public final void setCategory(Category category) {
            this.e = category;
        }

        public final void setEnvironment(Map<String, ? extends Object> map) {
            this.f = map;
        }

        public final void setExtras(Map<String, byte[]> map) {
            this.g = map;
        }

        public final void setName(String str) {
            this.b = str;
        }

        public final void setServiceDataReporterType(Integer num) {
            this.d = num;
        }

        public final void setValue(String str) {
            this.c = str;
        }

        public final Builder withAttributes(Map<String, ? extends Object> map) {
            if (map != null) {
                this.h = new HashMap(map);
            }
            return this;
        }

        public final Builder withCategory(Category category) {
            this.e = category;
            return this;
        }

        public final Builder withEnvironment(Map<String, ? extends Object> map) {
            if (map != null) {
                this.f = new HashMap(map);
            }
            return this;
        }

        public final Builder withExtras(Map<String, byte[]> map) {
            if (map != null) {
                this.g = new HashMap(map);
            }
            return this;
        }

        public final Builder withName(String str) {
            this.b = str;
            return this;
        }

        public final Builder withServiceDataReporterType(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        public final Builder withValue(String str) {
            this.c = str;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Category;", "", "GENERAL", "SYSTEM", "modules-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public enum Category {
        GENERAL,
        SYSTEM
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Companion;", "", "", "type", "Lio/appmetrica/analytics/modulesapi/internal/common/InternalModuleEvent$Builder;", "newBuilder", "modules-api_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Builder newBuilder(int i) {
            return new Builder(i);
        }

        private Companion() {
        }
    }

    public /* synthetic */ InternalModuleEvent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final Builder newBuilder(int i) {
        return Companion.newBuilder(i);
    }

    public final Map<String, Object> getAttributes() {
        return CollectionUtils.getMapFromListOrNull(this.h);
    }

    public final Category getCategory() {
        return this.e;
    }

    public final Map<String, Object> getEnvironment() {
        return CollectionUtils.getMapFromListOrNull(this.f);
    }

    public final Map<String, byte[]> getExtras() {
        return CollectionUtils.getMapFromListOrNull(this.g);
    }

    public final String getName() {
        return this.b;
    }

    public final Integer getServiceDataReporterType() {
        return this.d;
    }

    public final int getType() {
        return this.f1209a;
    }

    public final String getValue() {
        return this.c;
    }

    public String toString() {
        return "ModuleEvent{type=" + this.f1209a + ", name='" + this.b + "', value='" + this.c + "', serviceDataReporterType=" + this.d + ", category=" + this.e + ", environment=" + this.f + ", extras=" + this.g + ", attributes=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }

    private InternalModuleEvent(Builder builder) {
        this.f1209a = builder.getType$modules_api_release();
        this.b = builder.getName();
        this.c = builder.getValue();
        this.d = builder.getServiceDataReporterType();
        this.e = builder.getCategory();
        this.f = CollectionUtils.getListFromMap(builder.getEnvironment());
        this.g = CollectionUtils.getListFromMap(builder.getExtras());
        this.h = CollectionUtils.getListFromMap(builder.getAttributes());
    }
}
