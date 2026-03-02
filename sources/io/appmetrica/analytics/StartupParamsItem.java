package io.appmetrica.analytics;

import java.util.Objects;
/* loaded from: classes3.dex */
public final class StartupParamsItem {

    /* renamed from: a  reason: collision with root package name */
    private final String f289a;
    private final StartupParamsItemStatus b;
    private final String c;

    public StartupParamsItem(String str, StartupParamsItemStatus startupParamsItemStatus, String str2) {
        this.f289a = str;
        this.b = startupParamsItemStatus;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StartupParamsItem.class == obj.getClass()) {
            StartupParamsItem startupParamsItem = (StartupParamsItem) obj;
            if (Objects.equals(this.f289a, startupParamsItem.f289a) && this.b == startupParamsItem.b && Objects.equals(this.c, startupParamsItem.c)) {
                return true;
            }
        }
        return false;
    }

    public String getErrorDetails() {
        return this.c;
    }

    public String getId() {
        return this.f289a;
    }

    public StartupParamsItemStatus getStatus() {
        return this.b;
    }

    public int hashCode() {
        return Objects.hash(this.f289a, this.b, this.c);
    }

    public String toString() {
        return "StartupParamsItem{id='" + this.f289a + "', status=" + this.b + ", errorDetails='" + this.c + "'}";
    }
}
