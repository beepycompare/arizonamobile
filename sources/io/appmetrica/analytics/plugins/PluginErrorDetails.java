package io.appmetrica.analytics.plugins;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class PluginErrorDetails {

    /* renamed from: a  reason: collision with root package name */
    private final String f1248a;
    private final String b;
    private final ArrayList c;
    private final String d;
    private final String e;
    private final Map f;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f1249a;
        private String b;
        private List c;
        private String d;
        private String e;
        private Map f;

        public PluginErrorDetails build() {
            return new PluginErrorDetails(this.f1249a, this.b, (List) WrapUtils.getOrDefault(this.c, new ArrayList()), this.d, this.e, (Map) WrapUtils.getOrDefault(this.f, new HashMap()), 0);
        }

        public Builder withExceptionClass(String str) {
            this.f1249a = str;
            return this;
        }

        public Builder withMessage(String str) {
            this.b = str;
            return this;
        }

        public Builder withPlatform(String str) {
            this.d = str;
            return this;
        }

        public Builder withPluginEnvironment(Map<String, String> map) {
            this.f = map;
            return this;
        }

        public Builder withStacktrace(List<StackTraceItem> list) {
            this.c = list;
            return this;
        }

        public Builder withVirtualMachineVersion(String str) {
            this.e = str;
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Platform {
        public static final String CORDOVA = "cordova";
        public static final String FLUTTER = "flutter";
        public static final String NATIVE = "native";
        public static final String REACT_NATIVE = "react_native";
        public static final String UNITY = "unity";
        public static final String XAMARIN = "xamarin";
    }

    /* synthetic */ PluginErrorDetails(String str, String str2, List list, String str3, String str4, Map map, int i) {
        this(str, str2, list, str3, str4, map);
    }

    public String getExceptionClass() {
        return this.f1248a;
    }

    public String getMessage() {
        return this.b;
    }

    public String getPlatform() {
        return this.d;
    }

    public Map<String, String> getPluginEnvironment() {
        return this.f;
    }

    public List<StackTraceItem> getStacktrace() {
        return this.c;
    }

    public String getVirtualMachineVersion() {
        return this.e;
    }

    private PluginErrorDetails(String str, String str2, List list, String str3, String str4, Map map) {
        this.f1248a = str;
        this.b = str2;
        this.c = new ArrayList(list);
        this.d = str3;
        this.e = str4;
        this.f = CollectionUtils.getMapFromList(CollectionUtils.getListFromMap(map));
    }
}
