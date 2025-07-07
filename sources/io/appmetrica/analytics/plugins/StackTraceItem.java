package io.appmetrica.analytics.plugins;
/* loaded from: classes4.dex */
public class StackTraceItem {

    /* renamed from: a  reason: collision with root package name */
    private final String f1249a;
    private final String b;
    private final Integer c;
    private final Integer d;
    private final String e;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f1250a;
        private String b;
        private Integer c;
        private Integer d;
        private String e;

        public StackTraceItem build() {
            return new StackTraceItem(this.f1250a, this.b, this.c, this.d, this.e, 0);
        }

        public Builder withClassName(String str) {
            this.f1250a = str;
            return this;
        }

        public Builder withColumn(Integer num) {
            this.d = num;
            return this;
        }

        public Builder withFileName(String str) {
            this.b = str;
            return this;
        }

        public Builder withLine(Integer num) {
            this.c = num;
            return this;
        }

        public Builder withMethodName(String str) {
            this.e = str;
            return this;
        }
    }

    /* synthetic */ StackTraceItem(String str, String str2, Integer num, Integer num2, String str3, int i) {
        this(str, str2, num, num2, str3);
    }

    public String getClassName() {
        return this.f1249a;
    }

    public Integer getColumn() {
        return this.d;
    }

    public String getFileName() {
        return this.b;
    }

    public Integer getLine() {
        return this.c;
    }

    public String getMethodName() {
        return this.e;
    }

    private StackTraceItem(String str, String str2, Integer num, Integer num2, String str3) {
        this.f1249a = str;
        this.b = str2;
        this.c = num;
        this.d = num2;
        this.e = str3;
    }
}
