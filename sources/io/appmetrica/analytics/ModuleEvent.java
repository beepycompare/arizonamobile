package io.appmetrica.analytics;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public final class ModuleEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f198a;
    private final String b;
    private final String c;
    private final int d;
    private final Category e;
    private final List f;
    private final List g;
    private final List h;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f199a;
        private String b;
        private String c;
        private int d;
        private Category e;
        private HashMap f;
        private HashMap g;
        private HashMap h;

        /* synthetic */ Builder(int i, int i2) {
            this(i);
        }

        public ModuleEvent build() {
            return new ModuleEvent(this, 0);
        }

        public Builder withAttributes(Map<String, Object> map) {
            if (map != null) {
                this.h = new HashMap(map);
            }
            return this;
        }

        public Builder withCategory(Category category) {
            this.e = category;
            return this;
        }

        public Builder withEnvironment(Map<String, Object> map) {
            if (map != null) {
                this.f = new HashMap(map);
            }
            return this;
        }

        public Builder withExtras(Map<String, byte[]> map) {
            if (map != null) {
                this.g = new HashMap(map);
            }
            return this;
        }

        public Builder withName(String str) {
            this.b = str;
            return this;
        }

        public Builder withServiceDataReporterType(int i) {
            this.d = i;
            return this;
        }

        public Builder withValue(String str) {
            this.c = str;
            return this;
        }

        private Builder(int i) {
            this.d = 1;
            this.e = Category.GENERAL;
            this.f199a = i;
        }
    }

    /* loaded from: classes4.dex */
    public enum Category {
        GENERAL,
        SYSTEM
    }

    /* synthetic */ ModuleEvent(Builder builder, int i) {
        this(builder);
    }

    public static Builder newBuilder(int i) {
        return new Builder(i, 0);
    }

    public Map<String, Object> getAttributes() {
        return CollectionUtils.getMapFromListOrNull(this.h);
    }

    public Category getCategory() {
        return this.e;
    }

    public Map<String, Object> getEnvironment() {
        return CollectionUtils.getMapFromListOrNull(this.f);
    }

    public Map<String, byte[]> getExtras() {
        return CollectionUtils.getMapFromListOrNull(this.g);
    }

    public String getName() {
        return this.b;
    }

    public int getServiceDataReporterType() {
        return this.d;
    }

    public int getType() {
        return this.f198a;
    }

    public String getValue() {
        return this.c;
    }

    public String toString() {
        return "ModuleEvent{type=" + this.f198a + ", name='" + this.b + "', value='" + this.c + "', serviceDataReporterType=" + this.d + ", category=" + this.e + ", environment=" + this.f + ", extras=" + this.g + ", attributes=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }

    private ModuleEvent(Builder builder) {
        this.f198a = builder.f199a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = CollectionUtils.getListFromMap(builder.f);
        this.g = CollectionUtils.getListFromMap(builder.g);
        this.h = CollectionUtils.getListFromMap(builder.h);
    }
}
