package io.appmetrica.analytics;

import java.util.Objects;
/* loaded from: classes3.dex */
public final class StartupParamsItem {

    /* renamed from: a  reason: collision with root package name */
    private final String f275a;
    private final StartupParamsItemStatus b;
    private final String c;

    public StartupParamsItem(String str, StartupParamsItemStatus startupParamsItemStatus, String str2) {
        this.f275a = str;
        this.b = startupParamsItemStatus;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StartupParamsItem.class == obj.getClass()) {
            StartupParamsItem startupParamsItem = (StartupParamsItem) obj;
            if (Objects.equals(this.f275a, startupParamsItem.f275a) && this.b == startupParamsItem.b && Objects.equals(this.c, startupParamsItem.c)) {
                return true;
            }
        }
        return false;
    }

    public String getErrorDetails() {
        return this.c;
    }

    public String getId() {
        return this.f275a;
    }

    public StartupParamsItemStatus getStatus() {
        return this.b;
    }

    public int hashCode() {
        return Objects.hash(this.f275a, this.b, this.c);
    }

    public String toString() {
        return "StartupParamsItem{id='" + this.f275a + "', status=" + this.b + ", errorDetails='" + this.c + "'}";
    }
}
